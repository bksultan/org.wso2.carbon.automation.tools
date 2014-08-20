package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;
import org.wso2.carbon.application.mgt.stub.upload.CarbonAppUploaderStub;


/**
 * Auto generated CarbonAppUploader service Client
 *
 * Service name : CarbonAppUploader
 * Service WSDL : CarbonAppUploader.wsdl
 * Service stub class : CarbonAppUploaderStub
 * Client Library : CarbonAppUploaderLibrary
 *
 * @author rukshan
 * 
 */

public class CarbonAppUploaderLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private CarbonAppUploaderStub stub;


	//Constructor		
	public CarbonAppUploaderLibrary(){

	}		

	public void uploadApp(UploadedFileItem[] arg)  throws java.lang.Exception{

	stub.uploadApp(arg);

	}




	public void initCarbonAppUploader() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "CarbonAppUploader";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new CarbonAppUploaderStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}