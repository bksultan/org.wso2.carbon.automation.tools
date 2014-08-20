//package robotlib;
package clients;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import org.wso2.carbon.application.mgt.webapp.stub.WarApplicationAdminStub;
import org.wso2.carbon.application.mgt.webapp.stub.types.carbon.WarCappMetadata;

import client.configuration.AutomationConfigurationReader;
import client.support.modules.AuthenticationLibrary;


public class WarApplicationAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WarApplicationAdminStub stub;


	//Constructor		
	public WarApplicationAdminLibrary(){

	}		

	public WarCappMetadata[] getWarAppData(String arg)  throws java.lang.Exception{

		this.getWarAppData=stub.getWarAppData(arg);
		return this.getWarAppData;

	}

	private WarCappMetadata[] getWarAppData;

	public void  AssertgetWarAppData(WarCappMetadata[] expected) {	
		Assert.assertEquals(getWarAppData , expected );		
	}
	public WarCappMetadata[] getJaxWSWarAppData(String arg)  throws java.lang.Exception{

		this.getJaxWSWarAppData=stub.getJaxWSWarAppData(arg);
		return this.getJaxWSWarAppData;

	}

	private WarCappMetadata[] getJaxWSWarAppData;

	public void  AssertgetJaxWSWarAppData(WarCappMetadata[] expected) {	
		Assert.assertEquals(getJaxWSWarAppData , expected );		
	}


	public static void main(String[] args) {
		//WarApplicationAdminLibrary l=new WarApplicationAdminLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initWarApplicationAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WarApplicationAdmin";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new WarApplicationAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}