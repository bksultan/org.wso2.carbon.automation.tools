package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.application.mgt.webapp.stub.WarApplicationAdminStub;
import org.wso2.carbon.application.mgt.webapp.stub.types.carbon.WarCappMetadata;


/**
 * Auto generated WarApplicationAdmin service Client
 *
 * Service name : WarApplicationAdmin
 * Service WSDL : WarApplicationAdmin.wsdl
 * Service stub class : WarApplicationAdminStub
 * Client Library : WarApplicationAdminLibrary
 *
 * @author rukshan
 * 
 */

public class WarApplicationAdminClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WarApplicationAdminStub stub;


	//Constructor		
	public WarApplicationAdminClient(){

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



	public void initWarApplicationAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WarApplicationAdmin";
		String endPoint;
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