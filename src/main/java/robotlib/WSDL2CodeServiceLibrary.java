//package robotlib;
package robotlib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.wsdl2code.stub.types.carbon.CodegenDownloadData;
import org.wso2.carbon.wsdl2code.stub.WSDL2CodeServiceStub;


public class WSDL2CodeServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WSDL2CodeServiceStub stub;


	//Constructor		
	public WSDL2CodeServiceLibrary(){

	}		

	public CodegenDownloadData codegenForCXF(String[] arg)  throws java.lang.Exception{

		this.codegenForCXF=stub.codegenForCXF(arg);
		return this.codegenForCXF;

	}

	private CodegenDownloadData codegenForCXF;

	public void  AssertcodegenForCXF(CodegenDownloadData expected) {	
		Assert.assertEquals(codegenForCXF , expected );		
	}
	public CodegenDownloadData codegen(String[] arg)  throws java.lang.Exception{

		this.codegen=stub.codegen(arg);
		return this.codegen;

	}

	private CodegenDownloadData codegen;

	public void  Assertcodegen(CodegenDownloadData expected) {	
		Assert.assertEquals(codegen , expected );		
	}


	public static void main(String[] args) {
		//WSDL2CodeServiceLibrary l=new WSDL2CodeServiceLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initWSDL2CodeService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WSDL2CodeService";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
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