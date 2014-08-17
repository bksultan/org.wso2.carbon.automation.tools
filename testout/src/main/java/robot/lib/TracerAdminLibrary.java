//package robotlib;
package robot.lib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.tracer.stub.types.carbon.TracerServiceInfo;
import org.wso2.carbon.tracer.stub.types.carbon.MessagePayload;
import org.wso2.carbon.tracer.stub.TracerAdminStub;


public class TracerAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private TracerAdminStub stub;


	//Constructor		
	public TracerAdminLibrary(){

	}		

	public MessagePayload getMessage(String arg0,String arg1,long arg)  throws java.lang.Exception{

		this.getMessage=stub.getMessage(arg0,arg1,arg);
		return this.getMessage;

	}

	private MessagePayload getMessage;

	public void  AssertgetMessage(MessagePayload expected) {	
		Assert.assertEquals(getMessage , expected );		
	}
	public TracerServiceInfo setMonitoring(String arg)  throws java.lang.Exception{

		this.setMonitoring=stub.setMonitoring(arg);
		return this.setMonitoring;

	}

	private TracerServiceInfo setMonitoring;

	public void  AssertsetMonitoring(TracerServiceInfo expected) {	
		Assert.assertEquals(setMonitoring , expected );		
	}
	public TracerServiceInfo getMessages(int arg0,String arg)  throws java.lang.Exception{

		this.getMessages=stub.getMessages(arg0,arg);
		return this.getMessages;

	}

	private TracerServiceInfo getMessages;

	public void  AssertgetMessages(TracerServiceInfo expected) {	
		Assert.assertEquals(getMessages , expected );		
	}
	public void clearAllSoapMessages()  throws java.lang.Exception{

	stub.clearAllSoapMessages();

	}



	public static void main(String[] args) {
		//TracerAdminLibrary l=new TracerAdminLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initTracerAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "TracerAdmin";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
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