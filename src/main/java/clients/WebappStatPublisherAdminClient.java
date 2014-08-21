package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.bam.webapp.stat.publisher.stub.WebappStatPublisherAdminStub;
import org.wso2.carbon.bam.webapp.stat.publisher.stub.conf.ServiceEventingConfigData;


/**
 * Auto generated WebappStatPublisherAdmin service Client
 *
 * Service name : WebappStatPublisherAdmin
 * Service WSDL : WebappStatPublisherAdmin.wsdl
 * Service stub class : WebappStatPublisherAdminStub
 * Client Library : WebappStatPublisherAdminLibrary
 *
 * @author rukshan
 * 
 */

public class WebappStatPublisherAdminClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WebappStatPublisherAdminStub stub;


	//Constructor		
	public WebappStatPublisherAdminClient(){

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



	public void initWebappStatPublisherAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WebappStatPublisherAdmin";
		String endPoint;
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