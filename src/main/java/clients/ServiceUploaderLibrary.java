//package robotlib;
package clients;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import org.wso2.carbon.aarservices.stub.types.carbon.AARServiceData;
import org.wso2.carbon.aarservices.stub.ServiceUploaderStub;

import client.configuration.AutomationConfigurationReader;
import client.support.modules.AuthenticationLibrary;


public class ServiceUploaderLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ServiceUploaderStub stub;


	//Constructor		
	public ServiceUploaderLibrary(){

	}		

	public String uploadService(AARServiceData[] arg)  throws java.lang.Exception{

		this.uploadService=stub.uploadService(arg);
		return this.uploadService;

	}

	private String uploadService;

	public void  AssertuploadService(String expected) {	
		Assert.assertEquals(uploadService , expected );		
	}


	public static void main(String[] args) {
		//ServiceUploaderLibrary l=new ServiceUploaderLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initServiceUploader() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ServiceUploader";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
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