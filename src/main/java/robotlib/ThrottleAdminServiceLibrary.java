//package robotlib;
package robotlib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.throttle.stub.ThrottleAdminServiceStub;
import org.wso2.carbon.throttle.stub.types.ThrottlePolicy;


public class ThrottleAdminServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ThrottleAdminServiceStub stub;


	//Constructor		
	public ThrottleAdminServiceLibrary(){

	}		

	public String throttlePolicyToString(ThrottlePolicy arg)  throws java.lang.Exception{

		this.throttlePolicyToString=stub.throttlePolicyToString(arg);
		return this.throttlePolicyToString;

	}

	private String throttlePolicyToString;

	public void  AssertthrottlePolicyToString(String expected) {	
		Assert.assertEquals(throttlePolicyToString , expected );		
	}
	public ThrottlePolicy getPolicyConfigs(String arg)  throws java.lang.Exception{

		this.getPolicyConfigs=stub.getPolicyConfigs(arg);
		return this.getPolicyConfigs;

	}

	private ThrottlePolicy getPolicyConfigs;

	public void  AssertgetPolicyConfigs(ThrottlePolicy expected) {	
		Assert.assertEquals(getPolicyConfigs , expected );		
	}
	public ThrottlePolicy getGlobalPolicyConfigs()  throws java.lang.Exception{

		this.getGlobalPolicyConfigs=stub.getGlobalPolicyConfigs();
		return this.getGlobalPolicyConfigs;

	}

	private ThrottlePolicy getGlobalPolicyConfigs;

	public void  AssertgetGlobalPolicyConfigs(ThrottlePolicy expected) {	
		Assert.assertEquals(getGlobalPolicyConfigs , expected );		
	}
	public void disableThrottling(String arg)  throws java.lang.Exception{

	stub.disableThrottling(arg);

	}

	public boolean engageThrottlingForOperation(ThrottlePolicy arg0,String arg1,String arg)  throws java.lang.Exception{

		this.engageThrottlingForOperation=stub.engageThrottlingForOperation(arg0,arg1,arg);
		return this.engageThrottlingForOperation;

	}

	private boolean engageThrottlingForOperation;

	public void  AssertengageThrottlingForOperation(boolean expected) {	
		Assert.assertEquals(engageThrottlingForOperation , expected );		
	}
	public void disengageGlobalThrottling()  throws java.lang.Exception{

	stub.disengageGlobalThrottling();

	}

	public ThrottlePolicy getOperationPolicyConfigs(String arg0,String arg)  throws java.lang.Exception{

		this.getOperationPolicyConfigs=stub.getOperationPolicyConfigs(arg0,arg);
		return this.getOperationPolicyConfigs;

	}

	private ThrottlePolicy getOperationPolicyConfigs;

	public void  AssertgetOperationPolicyConfigs(ThrottlePolicy expected) {	
		Assert.assertEquals(getOperationPolicyConfigs , expected );		
	}
	public void enableThrottling(String arg0,ThrottlePolicy arg)  throws java.lang.Exception{

	stub.enableThrottling(arg0,arg);

	}

	public void globallyEngageThrottling(ThrottlePolicy arg)  throws java.lang.Exception{

	stub.globallyEngageThrottling(arg);

	}

	public ThrottlePolicy toThrottlePolicy(String arg)  throws java.lang.Exception{

		this.toThrottlePolicy=stub.toThrottlePolicy(arg);
		return this.toThrottlePolicy;

	}

	private ThrottlePolicy toThrottlePolicy;

	public void  AsserttoThrottlePolicy(ThrottlePolicy expected) {	
		Assert.assertEquals(toThrottlePolicy , expected );		
	}
	public boolean disengageThrottlingForOperation(String arg0,String arg)  throws java.lang.Exception{

		this.disengageThrottlingForOperation=stub.disengageThrottlingForOperation(arg0,arg);
		return this.disengageThrottlingForOperation;

	}

	private boolean disengageThrottlingForOperation;

	public void  AssertdisengageThrottlingForOperation(boolean expected) {	
		Assert.assertEquals(disengageThrottlingForOperation , expected );		
	}


	public static void main(String[] args) {
		//ThrottleAdminServiceLibrary l=new ThrottleAdminServiceLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initThrottleAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ThrottleAdminService";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new ThrottleAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}