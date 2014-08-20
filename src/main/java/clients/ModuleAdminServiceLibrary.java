package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.module.mgt.stub.types.ModuleMetaData;
import org.wso2.carbon.module.mgt.stub.ModuleAdminServiceStub;
import org.wso2.carbon.module.mgt.stub.types.ModuleUploadData;


/**
 * Auto generated ModuleAdminService service Client
 *
 * Service name : ModuleAdminService
 * Service WSDL : ModuleAdminService.wsdl
 * Service stub class : ModuleAdminServiceStub
 * Client Library : ModuleAdminServiceLibrary
 *
 * @author rukshan
 * 
 */

public class ModuleAdminServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ModuleAdminServiceStub stub;


	//Constructor		
	public ModuleAdminServiceLibrary(){

	}		

	public String[] getModuleParameters(String arg0,String arg)  throws java.lang.Exception{

		this.getModuleParameters=stub.getModuleParameters(arg0,arg);
		return this.getModuleParameters;

	}

	private String[] getModuleParameters;

	public void  AssertgetModuleParameters(String[] expected) {	
		Assert.assertEquals(getModuleParameters , expected );		
	}
	public boolean engageModuleForOperation(String arg0,String arg1,String arg)  throws java.lang.Exception{

		this.engageModuleForOperation=stub.engageModuleForOperation(arg0,arg1,arg);
		return this.engageModuleForOperation;

	}

	private boolean engageModuleForOperation;

	public void  AssertengageModuleForOperation(boolean expected) {	
		Assert.assertEquals(engageModuleForOperation , expected );		
	}
	public ModuleMetaData[] listGloballyEngagedModules()  throws java.lang.Exception{

		this.listGloballyEngagedModules=stub.listGloballyEngagedModules();
		return this.listGloballyEngagedModules;

	}

	private ModuleMetaData[] listGloballyEngagedModules;

	public void  AssertlistGloballyEngagedModules(ModuleMetaData[] expected) {	
		Assert.assertEquals(listGloballyEngagedModules , expected );		
	}
	public boolean disengageModuleFromSystem(String arg)  throws java.lang.Exception{

		this.disengageModuleFromSystem=stub.disengageModuleFromSystem(arg);
		return this.disengageModuleFromSystem;

	}

	private boolean disengageModuleFromSystem;

	public void  AssertdisengageModuleFromSystem(boolean expected) {	
		Assert.assertEquals(disengageModuleFromSystem , expected );		
	}
	public boolean globallyEngageModule(String arg)  throws java.lang.Exception{

		this.globallyEngageModule=stub.globallyEngageModule(arg);
		return this.globallyEngageModule;

	}

	private boolean globallyEngageModule;

	public void  AssertgloballyEngageModule(boolean expected) {	
		Assert.assertEquals(globallyEngageModule , expected );		
	}
	public boolean engageModuleForServiceGroup(String arg0,String arg)  throws java.lang.Exception{

		this.engageModuleForServiceGroup=stub.engageModuleForServiceGroup(arg0,arg);
		return this.engageModuleForServiceGroup;

	}

	private boolean engageModuleForServiceGroup;

	public void  AssertengageModuleForServiceGroup(boolean expected) {	
		Assert.assertEquals(engageModuleForServiceGroup , expected );		
	}
	public String uploadModule(ModuleUploadData[] arg)  throws java.lang.Exception{

		this.uploadModule=stub.uploadModule(arg);
		return this.uploadModule;

	}

	private String uploadModule;

	public void  AssertuploadModule(String expected) {	
		Assert.assertEquals(uploadModule , expected );		
	}
	public ModuleMetaData[] listModulesForOperation(String arg0,String arg)  throws java.lang.Exception{

		this.listModulesForOperation=stub.listModulesForOperation(arg0,arg);
		return this.listModulesForOperation;

	}

	private ModuleMetaData[] listModulesForOperation;

	public void  AssertlistModulesForOperation(ModuleMetaData[] expected) {	
		Assert.assertEquals(listModulesForOperation , expected );		
	}
	public ModuleMetaData[] listModulesForService(String arg)  throws java.lang.Exception{

		this.listModulesForService=stub.listModulesForService(arg);
		return this.listModulesForService;

	}

	private ModuleMetaData[] listModulesForService;

	public void  AssertlistModulesForService(ModuleMetaData[] expected) {	
		Assert.assertEquals(listModulesForService , expected );		
	}
	public boolean disengageModuleForServiceGroup(String arg0,String arg)  throws java.lang.Exception{

		this.disengageModuleForServiceGroup=stub.disengageModuleForServiceGroup(arg0,arg);
		return this.disengageModuleForServiceGroup;

	}

	private boolean disengageModuleForServiceGroup;

	public void  AssertdisengageModuleForServiceGroup(boolean expected) {	
		Assert.assertEquals(disengageModuleForServiceGroup , expected );		
	}
	public boolean globallyDisengageModule(String arg)  throws java.lang.Exception{

		this.globallyDisengageModule=stub.globallyDisengageModule(arg);
		return this.globallyDisengageModule;

	}

	private boolean globallyDisengageModule;

	public void  AssertgloballyDisengageModule(boolean expected) {	
		Assert.assertEquals(globallyDisengageModule , expected );		
	}
	public ModuleMetaData[] listModules()  throws java.lang.Exception{

		this.listModules=stub.listModules();
		return this.listModules;

	}

	private ModuleMetaData[] listModules;

	public void  AssertlistModules(ModuleMetaData[] expected) {	
		Assert.assertEquals(listModules , expected );		
	}
	public boolean engageModuleForService(String arg0,String arg)  throws java.lang.Exception{

		this.engageModuleForService=stub.engageModuleForService(arg0,arg);
		return this.engageModuleForService;

	}

	private boolean engageModuleForService;

	public void  AssertengageModuleForService(boolean expected) {	
		Assert.assertEquals(engageModuleForService , expected );		
	}
	public boolean disengageModuleForService(String arg0,String arg)  throws java.lang.Exception{

		this.disengageModuleForService=stub.disengageModuleForService(arg0,arg);
		return this.disengageModuleForService;

	}

	private boolean disengageModuleForService;

	public void  AssertdisengageModuleForService(boolean expected) {	
		Assert.assertEquals(disengageModuleForService , expected );		
	}
	public void setModuleParameters(String arg0,String arg1,String[] arg)  throws java.lang.Exception{

	stub.setModuleParameters(arg0,arg1,arg);

	}

	public String removeModuleParameter(String arg0,String arg1,String arg)  throws java.lang.Exception{

		this.removeModuleParameter=stub.removeModuleParameter(arg0,arg1,arg);
		return this.removeModuleParameter;

	}

	private String removeModuleParameter;

	public void  AssertremoveModuleParameter(String expected) {	
		Assert.assertEquals(removeModuleParameter , expected );		
	}
	public ModuleMetaData[] listModulesForServiceGroup(String arg)  throws java.lang.Exception{

		this.listModulesForServiceGroup=stub.listModulesForServiceGroup(arg);
		return this.listModulesForServiceGroup;

	}

	private ModuleMetaData[] listModulesForServiceGroup;

	public void  AssertlistModulesForServiceGroup(ModuleMetaData[] expected) {	
		Assert.assertEquals(listModulesForServiceGroup , expected );		
	}
	public boolean disengageModuleForOperation(String arg0,String arg1,String arg)  throws java.lang.Exception{

		this.disengageModuleForOperation=stub.disengageModuleForOperation(arg0,arg1,arg);
		return this.disengageModuleForOperation;

	}

	private boolean disengageModuleForOperation;

	public void  AssertdisengageModuleForOperation(boolean expected) {	
		Assert.assertEquals(disengageModuleForOperation , expected );		
	}
	public ModuleMetaData getModuleInfo(String arg0,String arg)  throws java.lang.Exception{

		this.getModuleInfo=stub.getModuleInfo(arg0,arg);
		return this.getModuleInfo;

	}

	private ModuleMetaData getModuleInfo;

	public void  AssertgetModuleInfo(ModuleMetaData expected) {	
		Assert.assertEquals(getModuleInfo , expected );		
	}
	public String removeModule(String arg)  throws java.lang.Exception{

		this.removeModule=stub.removeModule(arg);
		return this.removeModule;

	}

	private String removeModule;

	public void  AssertremoveModule(String expected) {	
		Assert.assertEquals(removeModule , expected );		
	}



	public void initModuleAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ModuleAdminService";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new ModuleAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}