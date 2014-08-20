//package robotlib;
package clients;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import org.wso2.carbon.caching.stub.types.CachingConfigData;
import org.wso2.carbon.caching.stub.CachingAdminServiceStub;

import client.configuration.AutomationConfigurationReader;
import client.support.modules.AuthenticationLibrary;


public class CachingAdminServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private CachingAdminServiceStub stub;


	//Constructor		
	public CachingAdminServiceLibrary(){

	}		

	public boolean isCachingEnabledForOperation(String arg0,String arg)  throws java.lang.Exception{

		this.isCachingEnabledForOperation=stub.isCachingEnabledForOperation(arg0,arg);
		return this.isCachingEnabledForOperation;

	}

	private boolean isCachingEnabledForOperation;

	public void  AssertisCachingEnabledForOperation(boolean expected) {	
		Assert.assertEquals(isCachingEnabledForOperation , expected );		
	}
	public CachingConfigData getCachingPolicyForOperation(String arg0,String arg)  throws java.lang.Exception{

		this.getCachingPolicyForOperation=stub.getCachingPolicyForOperation(arg0,arg);
		return this.getCachingPolicyForOperation;

	}

	private CachingConfigData getCachingPolicyForOperation;

	public void  AssertgetCachingPolicyForOperation(CachingConfigData expected) {	
		Assert.assertEquals(getCachingPolicyForOperation , expected );		
	}
	public boolean engageCachingForOperation(String arg0,String arg1,CachingConfigData arg)  throws java.lang.Exception{

		this.engageCachingForOperation=stub.engageCachingForOperation(arg0,arg1,arg);
		return this.engageCachingForOperation;

	}

	private boolean engageCachingForOperation;

	public void  AssertengageCachingForOperation(boolean expected) {	
		Assert.assertEquals(engageCachingForOperation , expected );		
	}
	public CachingConfigData getGlobalCachingPolicy()  throws java.lang.Exception{

		this.getGlobalCachingPolicy=stub.getGlobalCachingPolicy();
		return this.getGlobalCachingPolicy;

	}

	private CachingConfigData getGlobalCachingPolicy;

	public void  AssertgetGlobalCachingPolicy(CachingConfigData expected) {	
		Assert.assertEquals(getGlobalCachingPolicy , expected );		
	}
	public boolean disengageCachingForOperation(String arg0,String arg)  throws java.lang.Exception{

		this.disengageCachingForOperation=stub.disengageCachingForOperation(arg0,arg);
		return this.disengageCachingForOperation;

	}

	private boolean disengageCachingForOperation;

	public void  AssertdisengageCachingForOperation(boolean expected) {	
		Assert.assertEquals(disengageCachingForOperation , expected );		
	}
	public void disengageCachingForService(String arg)  throws java.lang.Exception{

	stub.disengageCachingForService(arg);

	}

	public CachingConfigData getCachingPolicyForService(String arg)  throws java.lang.Exception{

		this.getCachingPolicyForService=stub.getCachingPolicyForService(arg);
		return this.getCachingPolicyForService;

	}

	private CachingConfigData getCachingPolicyForService;

	public void  AssertgetCachingPolicyForService(CachingConfigData expected) {	
		Assert.assertEquals(getCachingPolicyForService , expected );		
	}
	public void disengageGlobalCaching()  throws java.lang.Exception{

	stub.disengageGlobalCaching();

	}

	public void globallyEngageCaching(CachingConfigData arg)  throws java.lang.Exception{

	stub.globallyEngageCaching(arg);

	}

	public boolean isCachingGloballyEnabled()  throws java.lang.Exception{

		this.isCachingGloballyEnabled=stub.isCachingGloballyEnabled();
		return this.isCachingGloballyEnabled;

	}

	private boolean isCachingGloballyEnabled;

	public void  AssertisCachingGloballyEnabled(boolean expected) {	
		Assert.assertEquals(isCachingGloballyEnabled , expected );		
	}
	public void engageCachingForService(String arg0,CachingConfigData arg)  throws java.lang.Exception{

	stub.engageCachingForService(arg0,arg);

	}

	public boolean isCachingEnabledForService(String arg)  throws java.lang.Exception{

		this.isCachingEnabledForService=stub.isCachingEnabledForService(arg);
		return this.isCachingEnabledForService;

	}

	private boolean isCachingEnabledForService;

	public void  AssertisCachingEnabledForService(boolean expected) {	
		Assert.assertEquals(isCachingEnabledForService , expected );		
	}


	public static void main(String[] args) {
		//CachingAdminServiceLibrary l=new CachingAdminServiceLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initCachingAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "CachingAdminService";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new CachingAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}