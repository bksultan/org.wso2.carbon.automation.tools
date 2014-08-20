package client.configuration;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.wso2.carbon.automation.engine.configurations.AutomationConfiguration;

/**
 * Read the automation.xml and provide the configuration data.
 * @author rukshan
 *
 */
public class AutomationConfigurationReader {

	/**
	 * list of default xpath of configuration values
	 */
	public static final String PRODUCT_AXIS2 = "/automation/robotconfig/server/axis2";
	public static final String PRODUCT_LOCATION = "/automation/robotconfig/product/location";
	public static final String PRODUCT_HOST = "/automation/robotconfig/product/host";
	public static final String PRODUCT_PORT = "/automation/robotconfig/product/port";
	public static final String PROJECT_LOCATION = "/automation/robotconfig/project/location";
	public static final String ATTEMPTS = "/automation/robotconfig/exe/attemt";

	private static Document xmlDocument;

	/**
	 * Load the automation.xml, read to the document
	 */
	static {
		// TODO Auto-generated constructor stub
		FileInputStream file;

		try {
			String s = "src/main/resources/automation.xml";
			file = new FileInputStream(new File(s));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			xmlDocument = builder.parse(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Get the specific attribute value from the automation.xml
	 * 
	 * @param xpath
	 *            xpath of the attribute
	 * @return return value as string
	 */
	public static String context(String xpath) {
		try {

			XPath xPath = XPathFactory.newInstance().newXPath();

			String val = xPath.compile(xpath).evaluate(xmlDocument);
			return val;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			return null;
		}

	}

	/**
	 * get the username of the user from tenet group
	 * @param tenet	tenet group
	 * @param user	user
	 * @return	username
	 * @throws XPathExpressionException
	 */
	public static String getUserName(String tenet, String user)
			throws XPathExpressionException {
		return AutomationConfiguration
				.getConfigurationValue("//userManagement/tenants/tenant[@key='wso2']/"
						+ tenet + "/user[@key='" + user + "']/userName");
	}

	/**
	 * get the password of the user from tenet group
	 * @param tenet	tenet group
	 * @param user	user
	 * @return	password
	 * @throws XPathExpressionException
	 */
	public static String getPassword(String tenet, String user)
			throws XPathExpressionException {
		return AutomationConfiguration
				.getConfigurationValue("//userManagement/tenants/tenant[@key='wso2']/"
						+ tenet + "/user[@key='" + user + "']/password");
	}

	/**
	 * get the default testing host
	 * @return	host
	 * @throws XPathExpressionException
	 */
	public static String getHostName() throws XPathExpressionException {
		return AutomationConfiguration
				.getConfigurationValue("//platform/productGroup[@name='ESB']/instance[@name='esbs001']/hosts/host[@type='default']");
	}

	/**
	 * return the deployment delay
	 * @return	return delay in int
	 * @throws XPathExpressionException
	 */
	public static int getDeploymentDelay() throws XPathExpressionException {
		String t=AutomationConfiguration
				.getConfigurationValue("//configurations/deploymentDelay");
		try {
			int time=Integer.parseInt(t);
			return time;
		} catch (Exception e) {
			System.out.println("error getting delaytime: use 60 000ms");
			return 60000;
		}
	}
}
