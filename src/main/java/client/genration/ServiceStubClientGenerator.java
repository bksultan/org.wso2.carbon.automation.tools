package client.genration;

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


/**
 * 
 * @author rukshan
 * 
 * Generate the service client in to the specified package.
 *
 */
public class ServiceStubClientGenerator {
	static Logger log = Logger.getLogger(ServiceStubClientGenerator.class.getName());
	static ArrayList<String> operations;				// keep operation of service listed as wsdl
	private static String path = "/src/main/java";		// path of client should be generated
	private static String packageName;					// keep the package name
	private static Document doc;						// xml reading document
	private static STGroup group;						// String template group file instance
	private static String suffix="Client";

	/**
	 * Constructor- define and import resources
	 */
	public ServiceStubClientGenerator() {
		//load the service.xml 
		File pomfile = new File("src/main/resources/service.xml");
		try {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			//init service.xml for start reading content
			doc = dBuilder.parse(pomfile);
			
			//Load the string template group file. it contain template 
			//for generate WSO2 Client library
			group = new STGroupFile("src/main/resources/templateR.stg");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
	}

	/**
	 * main method. start generate java class library
	 * 
	 * @param args args[0] as package name 
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		
		//new instance
		ServiceStubClientGenerator g = new ServiceStubClientGenerator();
		
//		 g.GenerateLibraries("robotlib");
		
		//if no argument assume generate to default package
		if (args.length == 0) {
			System.out.println("INFO: using default package");
			g.GenerateLibraries();
		} else if (args.length > 0) { // args[0] is take as package name 
			g.GenerateLibraries(args[0]);
		}

	}

	/**
	 * set the package name
	 * 
	 * @param name package name
	 */
	public void setPackageName(String name) {
		packageName = name;
	}

	/**
	 * save file on disk with provided content and name. 
	 * Library.java is append to the class name
	 * 
	 * @param className filename to be saved
	 * @param result content to be saved
	 */
	private static void save(String className, String result) {
		try {
			String loc = System.getProperty("user.dir");// get the current Directory
			System.out.println("user dir: " + loc);
			String pName;
			if (packageName != null) {
				//package name format is robot.lib, to save create directory path 
				//replacing "." with "/"
				pName = packageName.replaceAll("\\.","/") + "/"; 
				System.out.println("package dir: "+pName);
			} else {
				pName = "";
			}

			//create file with package path
			File ff2 = new File(loc + path + "/" + pName);
			if (!ff2.exists()) {
				ff2.mkdirs();//if directory not exist create
				log.debug("Client Gen: Create " + ff2.getAbsolutePath());
			}

			//create java file to be saved
			File f = new File(loc + path + "/" + pName + className
					+suffix+".java");
			
			//save to the disk
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

	/**
	 * check the operation is available in the WSDL as web service operation.
	 * name is the method name in the stub
	 * 
	 * @param name method name
	 * @return
	 */
	private static boolean isMethodNameValid(String name) {

		if (operations.contains(name)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * check the parameters, return type of any class is primitive type.
	 * if class name is primitive, return as false
	 * 
	 * @param name class name
	 * @return true if class is not primitive
	 */
	private static boolean isNameValid(String name) {
		String[] type = { "int", "boolean", "String", "Class", "Object",
				"void", "java.lang.String", "double", "long" };
		for (String s : type) {
			if (name.equals(s)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * get the operation of the web service based on the WSDL file.
	 * 
	 * @param cls full class name(stub) that jar contain WSDL file
	 * @param wsdl name of the WSDL
	 * @return return list of opeation's name
	 */
	private static ArrayList<String> getOperations(Class<?> cls, String wsdl) {

		ArrayList<String> li = new ArrayList<String>();
		try {
			InputStream input = cls.getResourceAsStream(wsdl);
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

	/**
	 * get the service name of the web service based on the WSDL file.
	 * 
	 * @param cls full class name(stub) that jar contain WSDL file
	 * @param wsdl name of the WSDL
	 * @return return service name
	 */
	private static String getServiceName(Class<?> cls, String wsdl) {

		InputStream input = cls.getResourceAsStream(wsdl);
		WSDLParser parser = new WSDLParser();
		Definitions defs = parser.parse(input);

		try {
			return defs.getServices().get(0).getName();
		} catch (Exception e) {
			return "newLib";
		}

	}

	/**
	 * generate java class content using string template and save to disk
	 * 
	 * @param res array with res[0] is stub class name and res[1] is wsdl file name
	 */
	public void generateClient(String[] res) {
		// list is for keep the list of classes should be imported to the generating class
		Set<String> importLib = new HashSet<String>(); 
		
		try {
			//res should contain the stub and wsdl information
			if (res == null) {
				System.out.println("error: No Service named ");
				return;
			}

			String servicestub = res[0];
			String wsdl = "/" + res[1] + ".wsdl";

			Class<?> c = Class.forName(servicestub); //get the class of the stub

			System.out.println(c.getPackage().getName());
			importLib.add(servicestub); // add the stub class to import to library later

			String methods = "";
//			String poolmethods = "";

			operations = getOperations(c, wsdl); // get the wsdl operations

			// iterate over stub methods
			for (Method m : c.getMethods()) {
				if (!isMethodNameValid(m.getName())) {
					continue; // if method is not listed in wsdl skip it
				}

				ST methodTem = group.getInstanceOf("method");					// load the method template
				methodTem.add("returnType", m.getReturnType().getSimpleName());	//	set the method return type
				methodTem.add("methodName", m.getName());						//	set the method name
				String retType = m.getReturnType().getSimpleName();
				retType = retType.replace("[]", "");
				if (isNameValid(retType)) {										// if the return type is complex  
					importLib.add(m.getReturnType().getCanonicalName()			// add to importLib list
							.replace("[]", ""));
				}
				String paras = "";
				String parasRet = "";
				int i = 0;
				
				// iterate over operation parameters
				for (Class<?> pc : m.getParameterTypes()) {
					String retType1 = pc.getSimpleName();

					retType1 = retType1.replace("[]", "");
					if (isNameValid(retType1)) {									// check para is complex
						importLib.add(pc.getCanonicalName().replace("[]", ""));		// if complex add to importlib list
						System.out.println("------------------------");
						System.out.println("complex: " + retType1);
						System.out.println("------------------------");
					}
					paras += pc.getSimpleName() + " " + "arg" + (i) + ",";			//set the method parameters with para type
					parasRet += "arg" + (i++) + ",";								// set the para for stub method
				}
				if (!paras.equals("")) {									// check operation have parameters
					methodTem.add("paras",										// if accept format string to remove last "," symbol and 
							paras.substring(0, paras.length() - 2));				// set the template paras
					methodTem.add("parasRet",
							parasRet.substring(0, parasRet.length() - 2));

				}

				//set the is operation is return value 
				methodTem.add("cond", !m.getReturnType().getSimpleName()
						.equals("void"));
				//rendor the template as string and concat all the methods of string into one
				methods += methodTem.render();
			}

//			methods += poolmethods;

			ST classTem = group.getInstanceOf("class");			//load the class template

			String serviceName = getServiceName(c, wsdl);		// get the service name of wsdl
			System.out.println("className " + serviceName);

			classTem.add("name", serviceName);					//set the class name as service name
			classTem.add("namestub", serviceName + "Stub");		//set the service stub class name
			classTem.add("methods", methods);

			// if package name has set, set the class package name 
			if (packageName != null) {				
				classTem.add("package", "package " + packageName + ";");
			}

			//iterate over list of class that should import, format
			String imports = "";
			for (String s : importLib) {
				imports += "import " + s + ";\n";
			}

			classTem.add("suffix", suffix);					//set the client suffix name as Client
			classTem.add("clsimport", imports);					//set the imported class

			save(serviceName, classTem.render());				// save the template into file
			log.debug("info: Client generated " + serviceName);
		} catch (ClassNotFoundException e) {
			System.out.println("error " + e.getMessage());
		}
	}

	/**
	 * default method to generate libraries. Assume package is default package.
	 *  generate libraries based on the services.xml
	 */
	public void GenerateLibraries() {
		GenerateLibraries(null);
	}
	
	/**
	 * generate libraries based on the services.xml
	 * @param pName package name of the java library classes
	 */
	public void GenerateLibraries(String pName) {

		if (pName == "" || pName == null) {
			setPackageName(null);				// if name is empty assume package is default 
		} else {
			setPackageName(pName);
		}

		// PropertyConfigurator.configure("src/main/resources/log4j.properties");

		//File f = new File("/home/rukshan/log4j/log.out");
		//f.delete();

		String[] res;
		try {

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList service = doc.getElementsByTagName("service");		// read the service.xml and load service tag
			for (int i = 0; i < service.getLength(); i++) {				// iterate over list of service tag
				Element ele = (Element) service.item(i);
				res = new String[2];
				res[0] = ele.getAttribute("stub");						// get the stub attribute
				res[1] = ele.getAttribute("wsdl");						// get the wsdl attribute

				generateClient(res);									// generate library and save 

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
