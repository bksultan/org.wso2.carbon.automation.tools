package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.aarservices.stub.types.carbon.AARServiceData;
import org.wso2.carbon.aarservices.stub.ServiceUploaderStub;


/**
 * Auto generated ServiceUploader service Client
 *
 * Service name : ServiceUploader
 * Service WSDL : ServiceUploader.wsdl
 * Service stub class : ServiceUploaderStub
 * Client Library : ServiceUploaderLibrary
 *
 * @author rukshan
 * 
 */

public class ServiceUploaderClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ServiceUploaderStub stub;


	//Constructor		
	public ServiceUploaderClient(){

	}		

	public String uploadService(AARServiceData[] arg)  throws java.lang.Exception{

		this.uploadService=stub.uploadService(arg);
		return this.uploadService;

	}

	private String uploadService;

	public void  AssertuploadService(String expected) {	
		Assert.assertEquals(uploadService , expected );		
	}



	public void initServiceUploader() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ServiceUploader";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new ServiceUploaderStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}