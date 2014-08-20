package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.viewflows.stub.types.AxisConfigData;
import org.wso2.carbon.viewflows.stub.FlowsAdminServiceStub;


/**
 * Auto generated FlowsAdminService service Client
 *
 * Service name : FlowsAdminService
 * Service WSDL : FlowsAdminService.wsdl
 * Service stub class : FlowsAdminServiceStub
 * Client Library : FlowsAdminServiceLibrary
 *
 * @author rukshan
 * 
 */

public class FlowsAdminServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private FlowsAdminServiceStub stub;


	//Constructor		
	public FlowsAdminServiceLibrary(){

	}		

	public AxisConfigData getOperationAxisConfigData(String arg0,String arg)  throws java.lang.Exception{

		this.getOperationAxisConfigData=stub.getOperationAxisConfigData(arg0,arg);
		return this.getOperationAxisConfigData;

	}

	private AxisConfigData getOperationAxisConfigData;

	public void  AssertgetOperationAxisConfigData(AxisConfigData expected) {	
		Assert.assertEquals(getOperationAxisConfigData , expected );		
	}
	public Object getHandlerNamesForPhase(String arg0,String arg)  throws java.lang.Exception{

		this.getHandlerNamesForPhase=stub.getHandlerNamesForPhase(arg0,arg);
		return this.getHandlerNamesForPhase;

	}

	private Object getHandlerNamesForPhase;

	public void  AssertgetHandlerNamesForPhase(Object expected) {	
		Assert.assertEquals(getHandlerNamesForPhase , expected );		
	}
	public AxisConfigData getAxisConfigData()  throws java.lang.Exception{

		this.getAxisConfigData=stub.getAxisConfigData();
		return this.getAxisConfigData;

	}

	private AxisConfigData getAxisConfigData;

	public void  AssertgetAxisConfigData(AxisConfigData expected) {	
		Assert.assertEquals(getAxisConfigData , expected );		
	}



	public void initFlowsAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "FlowsAdminService";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new FlowsAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}