package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.wsdl2code.stub.types.carbon.CodegenDownloadData;
import org.wso2.carbon.wsdl2code.stub.WSDL2CodeServiceStub;


/**
 * Auto generated WSDL2CodeService service Client
 *
 * Service name : WSDL2CodeService
 * Service WSDL : WSDL2CodeService.wsdl
 * Service stub class : WSDL2CodeServiceStub
 * Client Library : WSDL2CodeServiceLibrary
 *
 * @author rukshan
 * 
 */

public class WSDL2CodeServiceClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WSDL2CodeServiceStub stub;


	//Constructor		
	public WSDL2CodeServiceClient(){

	}		

	public CodegenDownloadData codegen(String[] arg)  throws java.lang.Exception{

		this.codegen=stub.codegen(arg);
		return this.codegen;

	}

	private CodegenDownloadData codegen;

	public void  Assertcodegen(CodegenDownloadData expected) {	
		Assert.assertEquals(codegen , expected );		
	}
	public CodegenDownloadData codegenForCXF(String[] arg)  throws java.lang.Exception{

		this.codegenForCXF=stub.codegenForCXF(arg);
		return this.codegenForCXF;

	}

	private CodegenDownloadData codegenForCXF;

	public void  AssertcodegenForCXF(CodegenDownloadData expected) {	
		Assert.assertEquals(codegenForCXF , expected );		
	}



	public void initWSDL2CodeService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WSDL2CodeService";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new WSDL2CodeServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}