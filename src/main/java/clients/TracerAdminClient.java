package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.tracer.stub.types.carbon.TracerServiceInfo;
import org.wso2.carbon.tracer.stub.types.carbon.MessagePayload;
import org.wso2.carbon.tracer.stub.TracerAdminStub;


/**
 * Auto generated TracerAdmin service Client
 *
 * Service name : TracerAdmin
 * Service WSDL : TracerAdmin.wsdl
 * Service stub class : TracerAdminStub
 * Client Library : TracerAdminLibrary
 *
 * @author rukshan
 * 
 */

public class TracerAdminClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private TracerAdminStub stub;


	//Constructor		
	public TracerAdminClient(){

	}		

	public TracerServiceInfo setMonitoring(String arg)  throws java.lang.Exception{

		this.setMonitoring=stub.setMonitoring(arg);
		return this.setMonitoring;

	}

	private TracerServiceInfo setMonitoring;

	public void  AssertsetMonitoring(TracerServiceInfo expected) {	
		Assert.assertEquals(setMonitoring , expected );		
	}
	public void clearAllSoapMessages()  throws java.lang.Exception{

	stub.clearAllSoapMessages();

	}

	public TracerServiceInfo getMessages(int arg0,String arg)  throws java.lang.Exception{

		this.getMessages=stub.getMessages(arg0,arg);
		return this.getMessages;

	}

	private TracerServiceInfo getMessages;

	public void  AssertgetMessages(TracerServiceInfo expected) {	
		Assert.assertEquals(getMessages , expected );		
	}
	public MessagePayload getMessage(String arg0,String arg1,long arg)  throws java.lang.Exception{

		this.getMessage=stub.getMessage(arg0,arg1,arg);
		return this.getMessage;

	}

	private MessagePayload getMessage;

	public void  AssertgetMessage(MessagePayload expected) {	
		Assert.assertEquals(getMessage , expected );		
	}



	public void initTracerAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "TracerAdmin";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new TracerAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}