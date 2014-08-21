package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.sample.installer.stub.SampleDeployerStub;
import org.wso2.carbon.sample.installer.stub.SampleInformation;


/**
 * Auto generated SampleDeployer service Client
 *
 * Service name : SampleDeployer
 * Service WSDL : SampleDeployer.wsdl
 * Service stub class : SampleDeployerStub
 * Client Library : SampleDeployerLibrary
 *
 * @author rukshan
 * 
 */

public class SampleDeployerClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private SampleDeployerStub stub;


	//Constructor		
	public SampleDeployerClient(){

	}		

	public SampleInformation[] getSampleInformation(String arg)  throws java.lang.Exception{

		this.getSampleInformation=stub.getSampleInformation(arg);
		return this.getSampleInformation;

	}

	private SampleInformation[] getSampleInformation;

	public void  AssertgetSampleInformation(SampleInformation[] expected) {	
		Assert.assertEquals(getSampleInformation , expected );		
	}
	public boolean uploadSample(String arg0,String arg)  throws java.lang.Exception{

		this.uploadSample=stub.uploadSample(arg0,arg);
		return this.uploadSample;

	}

	private boolean uploadSample;

	public void  AssertuploadSample(boolean expected) {	
		Assert.assertEquals(uploadSample , expected );		
	}
	public void setPolicyPermission()  throws java.lang.Exception{

	stub.setPolicyPermission();

	}

	public boolean deploySample(String arg0,String arg)  throws java.lang.Exception{

		this.deploySample=stub.deploySample(arg0,arg);
		return this.deploySample;

	}

	private boolean deploySample;

	public void  AssertdeploySample(boolean expected) {	
		Assert.assertEquals(deploySample , expected );		
	}



	public void initSampleDeployer() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "SampleDeployer";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new SampleDeployerStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}