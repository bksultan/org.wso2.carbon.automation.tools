//package robotlib;
package clients;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import org.wso2.carbon.bam.webapp.stat.publisher.stub.WebappStatPublisherAdminStub;
import org.wso2.carbon.bam.webapp.stat.publisher.stub.conf.ServiceEventingConfigData;

import client.configuration.AutomationConfigurationReader;
import client.support.modules.AuthenticationLibrary;


public class WebappStatPublisherAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WebappStatPublisherAdminStub stub;


	//Constructor		
	public WebappStatPublisherAdminLibrary(){

	}		

	public void configureEventing(ServiceEventingConfigData arg)  throws java.lang.Exception{

	stub.configureEventing(arg);

	}

	public boolean isCloudDeployment()  throws java.lang.Exception{

		this.isCloudDeployment=stub.isCloudDeployment();
		return this.isCloudDeployment;

	}

	private boolean isCloudDeployment;

	public void  AssertisCloudDeployment(boolean expected) {	
		Assert.assertEquals(isCloudDeployment , expected );		
	}
	public ServiceEventingConfigData getEventingConfigData()  throws java.lang.Exception{

		this.getEventingConfigData=stub.getEventingConfigData();
		return this.getEventingConfigData;

	}

	private ServiceEventingConfigData getEventingConfigData;

	public void  AssertgetEventingConfigData(ServiceEventingConfigData expected) {	
		Assert.assertEquals(getEventingConfigData , expected );		
	}
	public String getServerConfigBAMServerURL()  throws java.lang.Exception{

		this.getServerConfigBAMServerURL=stub.getServerConfigBAMServerURL();
		return this.getServerConfigBAMServerURL;

	}

	private String getServerConfigBAMServerURL;

	public void  AssertgetServerConfigBAMServerURL(String expected) {	
		Assert.assertEquals(getServerConfigBAMServerURL , expected );		
	}


	public static void main(String[] args) {
		//WebappStatPublisherAdminLibrary l=new WebappStatPublisherAdminLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initWebappStatPublisherAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WebappStatPublisherAdmin";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new WebappStatPublisherAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}