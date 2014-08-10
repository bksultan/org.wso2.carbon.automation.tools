package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.Operation;
import com.predic8.wsdl.PortType;
import com.predic8.wsdl.WSDLParser;

public class ClientGenerator {
	static Logger log = Logger.getLogger(ClientGenerator.class.getName());
	static ArrayList<String> operations;
	private static String path = "/src/main/java";
	private static String packageName;
	private static Document doc;
	private static STGroup group;

	public ClientGenerator() {
		File pomfile = new File("src/main/resources/service.xml");
		try {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			doc = dBuilder.parse(pomfile);
			group = new STGroupFile("src/main/resources/templateR.stg");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		ClientGenerator g = new ClientGenerator();
//		 g.GenerateLibraries("robotlib");
		if (args.length == 0) {
			System.out.println("INFO: using default package");
			g.GenerateLibraries();
		} else if (args.length > 0) {
			g.GenerateLibraries(args[0]);
		}

	}

	public void setPackageName(String name) {
		packageName = name;
	}

	private static void save(String className, String result) {
		try {
			String loc = System.getProperty("user.dir");
			System.out.println("user dir: " + loc);
			// File ff1 = new File(loc + path);
			// if (!ff1.exists()) {
			// ff1.mkdir();
			// log.debug("Client Gen: Create " + ff1.getAbsolutePath());
			// }
			String pName;
			if (packageName != null) {
				pName = packageName.replaceAll("\\.","/") + "/";
			} else {
				pName = "";
			}

			File ff2 = new File(loc + path + "/" + pName);
			if (!ff2.exists()) {
				ff2.mkdirs();
				log.debug("Client Gen: Create " + ff2.getAbsolutePath());
			}

			File f = new File(loc + path + "/" + pName + className
					+ "Library.java");
			BufferedWriter wri = new BufferedWriter(new FileWriter(f));
			wri.write(result);
			wri.close();
			System.out.println("Client Gen: Create " + f.getAbsolutePath());
			log.debug("ClientGen Created " + f.getAbsolutePath());
		} catch (IOException e) {
			log.debug("ClientGen Created " + e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private static boolean isMethodNameValid(String name) {

		if (operations.contains(name)) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean isNameValid(String name) {
		// System.out.println(name);
		String[] type = { "int", "boolean", "String", "Class", "Object",
				"void", "java.lang.String", "double", "long" };
		for (String s : type) {
			if (name.equals(s)) {
				return false;
			}
		}

		return true;
	}

	private static ArrayList<String> getOperations(Class<?> c, String wsdl) {

		ArrayList<String> li = new ArrayList<String>();
		try {
			InputStream input = c.getResourceAsStream(wsdl);
			WSDLParser parser = new WSDLParser();
			Definitions defs = parser.parse(input);
			for (PortType pt : defs.getPortTypes()) {
				for (Operation op : pt.getOperations()) {
					li.add(op.getName());
				}
			}
		} catch (Exception x) {
			System.out.println(x.getMessage());
		}

		return li;

	}

	private static String getServiceName(Class<?> c, String wsdl) {

		InputStream input = c.getResourceAsStream(wsdl);
		WSDLParser parser = new WSDLParser();
		Definitions defs = parser.parse(input);

		try {
			return defs.getServices().get(0).getName();
		} catch (Exception e) {
			return "newLib";
		}

	}

	public void generateClient(String[] res) {
		Set<String> importLib = new HashSet<String>();
		// URL
		// url=ClientGenerator.class.getResource("src/main/resources/templateR.stg");
		// URL url = null;
		// try {
		// url = ClassLoader.getSystemResource("templateR.stg");
		// } catch (Exception e) {
		// System.out.println("here" + e.getMessage());
		// }

		// ClientGenerator.class.getResource("src/main/resources/templateR.stg");

		// STGroup group = new STGroupFile(url,"UTF-8",'<','>');
//		STGroup group = new STGroupFile("src/main/resources/templateR.stg");
		try {
			if (res == null) {
				System.out.println("error: No Service named ");
				return;
			}

			String servicestub = res[0];
			String wsdl = "/" + res[1] + ".wsdl";

			Class<?> c = Class.forName(servicestub);

			System.out.println(c.getPackage().getName());
			importLib.add(servicestub);

			String methods = "";
			String poolmethods = "";

			operations = getOperations(c, wsdl);

			for (Method m : c.getMethods()) {
				if (!isMethodNameValid(m.getName())) {
					continue;
				}

				ST methodTem = group.getInstanceOf("method");
				methodTem.add("returnType", m.getReturnType().getSimpleName());
				methodTem.add("methodName", m.getName());
				String retType = m.getReturnType().getSimpleName();
				retType = retType.replace("[]", "");
				if (isNameValid(retType)) {
					importLib.add(m.getReturnType().getCanonicalName()
							.replace("[]", ""));
				}
				String paras = "";
				String parasRet = "";
				int i = 0;
				for (Class<?> pc : m.getParameterTypes()) {
					String retType1 = pc.getSimpleName();

					retType1 = retType1.replace("[]", "");
					if (isNameValid(retType1)) {
						importLib.add(pc.getCanonicalName().replace("[]", ""));
						System.out.println("------------------------");
						System.out.println("complex: " + retType1);
						// String
						// mm=creatMethods(pc.getCanonicalName().replace("[]",
						// ""));
						// poolmethods+=mm;
						System.out.println("------------------------");
					}
					paras += pc.getSimpleName() + " " + "arg" + (i) + ",";
					parasRet += "arg" + (i++) + ",";
				}
				if (!paras.equals("")) {
					methodTem.add("paras",
							paras.substring(0, paras.length() - 2));
					methodTem.add("parasRet",
							parasRet.substring(0, parasRet.length() - 2));

				}

				methodTem.add("cond", !m.getReturnType().getSimpleName()
						.equals("void"));
				methods += methodTem.render();
			}

			methods += poolmethods;

			ST classTem = group.getInstanceOf("class");

			String serviceName = getServiceName(c, wsdl);
			System.out.println("className " + serviceName);

			classTem.add("name", serviceName);
			classTem.add("namestub", serviceName + "Stub");
			classTem.add("methods", methods);

			if (packageName != null) {
				classTem.add("package", "package " + packageName + ";");
			}

			String imports = "";
			for (String s : importLib) {
				imports += "import " + s + ";\n";
			}

			classTem.add("clsimport", imports);

			save(serviceName, classTem.render());
			log.debug("info: Client generated " + serviceName);
		} catch (ClassNotFoundException e) {
			System.out.println("error " + e.getMessage());
		}
	}

	public void GenerateLibraries() {
		GenerateLibraries(null);
	}

	public void GenerateLibraries(String pName) {

		if (pName == "" || pName == null) {
			setPackageName(null);
		} else {
			setPackageName(pName);
		}

		// PropertyConfigurator.configure("src/main/resources/log4j.properties");

		File f = new File("/home/rukshan/log4j/log.out");
		f.delete();

		// InputStream
		// s=ClientGenerator.class.getResourceAsStream("src/main/resources/service.xml");
		// InputStream
		// s=getClass().getResourceAsStream("src/main/resources/service.xml");
		// File pomfile = new File("src/main/resources/service.xml");
		// InputStream s=ClassLoader.getSystemResourceAsStream("service.xml");
		String[] res;
		try {

			// DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
			// .newDocumentBuilder();
			// Document doc = dBuilder.parse(pomfile);
			// Document doc = dBuilder.parse(s);
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList service = doc.getElementsByTagName("service");
			for (int i = 0; i < service.getLength(); i++) {
				Element ele = (Element) service.item(i);
				res = new String[2];
				res[0] = ele.getAttribute("stub");
				res[1] = ele.getAttribute("wsdl");

				generateClient(res);

			}
			log.debug("Standard class: Client Generated");
			System.out.println("Standard class: Client Generated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("er" + e.getMessage());
			log.debug("Standard class: " + e.getMessage());
		}
	}

}
