package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.jarservices.stub.types.Resource;
import org.wso2.carbon.jarservices.stub.types.UploadArtifactsResponse;
import org.wso2.carbon.jarservices.stub.types.Service;
import org.wso2.carbon.jarservices.stub.JarServiceCreatorAdminStub;


/**
 * Auto generated JarServiceCreatorAdmin service Client
 *
 * Service name : JarServiceCreatorAdmin
 * Service WSDL : JarServiceCreatorAdmin.wsdl
 * Service stub class : JarServiceCreatorAdminStub
 * Client Library : JarServiceCreatorAdminLibrary
 *
 * @author rukshan
 * 
 */

public class JarServiceCreatorAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private JarServiceCreatorAdminStub stub;


	//Constructor		
	public JarServiceCreatorAdminLibrary(){

	}		

	public void createAndDeployService(String arg0,String arg1,String arg2,Service[] arg)  throws java.lang.Exception{

	stub.createAndDeployService(arg0,arg1,arg2,arg);

	}

	public Service[] getClassMethods(String arg0,Service[] arg)  throws java.lang.Exception{

		this.getClassMethods=stub.getClassMethods(arg0,arg);
		return this.getClassMethods;

	}

	private Service[] getClassMethods;

	public void  AssertgetClassMethods(Service[] expected) {	
		Assert.assertEquals(getClassMethods , expected );		
	}
	public void uploadService()  throws java.lang.Exception{

	stub.uploadService();

	}

	public UploadArtifactsResponse upload(String arg0,Resource arg1,Resource[] arg)  throws java.lang.Exception{

		this.upload=stub.upload(arg0,arg1,arg);
		return this.upload;

	}

	private UploadArtifactsResponse upload;

	public void  Assertupload(UploadArtifactsResponse expected) {	
		Assert.assertEquals(upload , expected );		
	}



	public void initJarServiceCreatorAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "JarServiceCreatorAdmin";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new JarServiceCreatorAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}