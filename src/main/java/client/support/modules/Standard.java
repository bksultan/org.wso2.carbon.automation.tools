package client.support.modules;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathExpressionException;

import org.apache.axiom.om.OMElement;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import client.configuration.AutomationConfigurationReader;
import client.genration.ClientGenerator;

/**
 * Provide the standard Asserting functions
 * @author rukshan
 *
 */
public class Standard {
	static final Logger logger = Logger.getLogger(Standard.class);

	public Standard() {
		System.setProperty("framework.resource.location", "src/main/resources/");
		// TODO Auto-generated constructor stub
		// InputStream is = ClassLoader
		// .getSystemResourceAsStream("log4j.properties");
		// URL url=ClassLoader
		// .getSystemResource("src/main/resources/log4j.properties");
		// try{
		// PropertyConfigurator.configure("src/main/resources/log4j.properties");
		// }catch(Exception e){
		// System.out.println(e.getMessage());
		// }
		// PropertyConfigurator.configure(is);
		// PropertyConfigurator.configure(url);
	}

	/**
	 * create array of objects
	 * 
	 * @param x
	 *            list of objects
	 * @return object array
	 */
	public Object[] CreateArray(Object... x) {
		return x;
	}

	/**
	 * assert the array length
	 * 
	 * @param x
	 *            actual array
	 * @param y
	 *            expected length
	 */
	public void AssertArrayLength(Object[] x, int y) {
		Assert.assertEquals(x.length, y);
	}

	/**
	 * assert the two object array
	 * 
	 * @param x
	 *            actual array
	 * @param y
	 *            expected array
	 */
	public void AssertArrayLengths(Object[] x, Object[] y) {
		Assert.assertEquals(x.length, y.length); // first assert the array
													// length

		for (int i = 0; i < y.length; i++) {
			Assert.assertEquals(x[i], y[i]); // assert the objects values
												// considering order
		}

	}

	/**
	 * create the object array from child element of om element
	 * 
	 * @param result
	 *            OM element
	 * @return child array
	 */
	public Object[] createArrayFromOME(OMElement result) {
		ArrayList<Object> q = new ArrayList<Object>();
		Iterator<?> ite = result.getChildren();
		// iterate over chile element
		for (Iterator<?> iterator = ite; iterator.hasNext();) {
			OMElement type = (OMElement) iterator.next();
			System.out.println(type.getText());
			q.add(type.getText()); // add the child element to list
		}
		return q.toArray(); // return list as array
	}

	public String testContext() throws XPathExpressionException {

		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);

		ClassLoader loader = Standard.class.getClassLoader();
		a = loader.getResource(".").toString();

		return a;
	}

	/**
	 * check object contain the expected string. if object is not string,
	 * consider it as object.toString()
	 * 
	 * @param o
	 *            Object
	 * @param v
	 *            expected sub string
	 * @return true if it contains and false if not
	 */
	public boolean containString(Object o, String v) {
		return o.toString().toLowerCase().contains(v.toLowerCase());
	}

	/**
	 * used to generate libraries as a command of robot script
	 */
	private static void log() {

		File f = new File("/home/rukshan/log4j/log.out");
		f.delete();

		File pomfile = new File("src/main/resources/service.xml"); // load the
																	// services.xml
		String[] res;
		try {

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = dBuilder.parse(pomfile); // load to read services
			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList service = doc.getElementsByTagName("service"); // get the
																	// service
																	// elements
			for (int i = 0; i < service.getLength(); i++) { // iterate over
															// service elements
				Element ele = (Element) service.item(i);
				res = new String[2];
				res[0] = ele.getAttribute("stub"); // get the stub class name
				res[1] = ele.getAttribute("wsdl"); // get the wsdl name

				new ClientGenerator().generateClient(res); // generate class one
															// by one

			}
			logger.debug("Standard class: Client Generated");
			System.out.println("Standard class: Client Generated");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.debug("Standard class: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		log();
	}
}
