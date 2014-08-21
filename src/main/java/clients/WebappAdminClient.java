package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.webapp.mgt.stub.types.carbon.WebappUploadData;
import org.wso2.carbon.webapp.mgt.stub.types.carbon.WebappsWrapper;
import org.wso2.carbon.webapp.mgt.stub.types.carbon.SessionsWrapper;
import org.wso2.carbon.webapp.mgt.stub.WebappAdminStub;
import org.wso2.carbon.webapp.mgt.stub.types.carbon.WebappMetadata;
import javax.activation.DataHandler;


/**
 * Auto generated WebappAdmin service Client
 *
 * Service name : WebappAdmin
 * Service WSDL : WebappAdmin.wsdl
 * Service stub class : WebappAdminStub
 * Client Library : WebappAdminLibrary
 *
 * @author rukshan
 * 
 */

public class WebappAdminClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private WebappAdminStub stub;


	//Constructor		
	public WebappAdminClient(){

	}		

	public void deleteAllWebApps(String[] arg)  throws java.lang.Exception{

	stub.deleteAllWebApps(arg);

	}

	public void deleteStartedWebapps(String[] arg)  throws java.lang.Exception{

	stub.deleteStartedWebapps(arg);

	}

	public WebappsWrapper getPagedWebappsSummary(String arg0,String arg1,String arg2,int arg)  throws java.lang.Exception{

		this.getPagedWebappsSummary=stub.getPagedWebappsSummary(arg0,arg1,arg2,arg);
		return this.getPagedWebappsSummary;

	}

	private WebappsWrapper getPagedWebappsSummary;

	public void  AssertgetPagedWebappsSummary(WebappsWrapper expected) {	
		Assert.assertEquals(getPagedWebappsSummary , expected );		
	}
	public void expireSessionsInWebapps(String[] arg)  throws java.lang.Exception{

	stub.expireSessionsInWebapps(arg);

	}

	public void startWebapps(String[] arg)  throws java.lang.Exception{

	stub.startWebapps(arg);

	}

	public void expireSessionsInAllWebapps()  throws java.lang.Exception{

	stub.expireSessionsInAllWebapps();

	}

	public void reloadAllWebapps()  throws java.lang.Exception{

	stub.reloadAllWebapps();

	}

	public void deleteAllFaultyWebapps()  throws java.lang.Exception{

	stub.deleteAllFaultyWebapps();

	}

	public void stopWebapps(String[] arg)  throws java.lang.Exception{

	stub.stopWebapps(arg);

	}

	public void deleteWebapp(String arg)  throws java.lang.Exception{

	stub.deleteWebapp(arg);

	}

	public WebappMetadata getStoppedWebapp(String arg)  throws java.lang.Exception{

		this.getStoppedWebapp=stub.getStoppedWebapp(arg);
		return this.getStoppedWebapp;

	}

	private WebappMetadata getStoppedWebapp;

	public void  AssertgetStoppedWebapp(WebappMetadata expected) {	
		Assert.assertEquals(getStoppedWebapp , expected );		
	}
	public void expireSessions(String arg0,String[] arg)  throws java.lang.Exception{

	stub.expireSessions(arg0,arg);

	}

	public boolean isUnpackWARs()  throws java.lang.Exception{

		this.isUnpackWARs=stub.isUnpackWARs();
		return this.isUnpackWARs;

	}

	private boolean isUnpackWARs;

	public void  AssertisUnpackWARs(boolean expected) {	
		Assert.assertEquals(isUnpackWARs , expected );		
	}
	public void deleteAllStartedWebapps()  throws java.lang.Exception{

	stub.deleteAllStartedWebapps();

	}

	public void changeDefaultAppVersion(String arg0,String arg)  throws java.lang.Exception{

	stub.changeDefaultAppVersion(arg0,arg);

	}

	public void reloadWebapps(String[] arg)  throws java.lang.Exception{

	stub.reloadWebapps(arg);

	}

	public boolean uploadWebapp(WebappUploadData[] arg)  throws java.lang.Exception{

		this.uploadWebapp=stub.uploadWebapp(arg);
		return this.uploadWebapp;

	}

	private boolean uploadWebapp;

	public void  AssertuploadWebapp(boolean expected) {	
		Assert.assertEquals(uploadWebapp , expected );		
	}
	public void expireAllSessions(String arg)  throws java.lang.Exception{

	stub.expireAllSessions(arg);

	}

	public WebappMetadata getStartedWebapp(String arg)  throws java.lang.Exception{

		this.getStartedWebapp=stub.getStartedWebapp(arg);
		return this.getStartedWebapp;

	}

	private WebappMetadata getStartedWebapp;

	public void  AssertgetStartedWebapp(WebappMetadata expected) {	
		Assert.assertEquals(getStartedWebapp , expected );		
	}
	public DataHandler downloadWarFileHandler(String arg0,String arg)  throws java.lang.Exception{

		this.downloadWarFileHandler=stub.downloadWarFileHandler(arg0,arg);
		return this.downloadWarFileHandler;

	}

	private DataHandler downloadWarFileHandler;

	public void  AssertdownloadWarFileHandler(DataHandler expected) {	
		Assert.assertEquals(downloadWarFileHandler , expected );		
	}
	public void startAllWebapps()  throws java.lang.Exception{

	stub.startAllWebapps();

	}

	public void deleteFaultyWebapps(String[] arg)  throws java.lang.Exception{

	stub.deleteFaultyWebapps(arg);

	}

	public String getBamConfiguration(String arg)  throws java.lang.Exception{

		this.getBamConfiguration=stub.getBamConfiguration(arg);
		return this.getBamConfiguration;

	}

	private String getBamConfiguration;

	public void  AssertgetBamConfiguration(String expected) {	
		Assert.assertEquals(getBamConfiguration , expected );		
	}
	public void setBamConfiguration(String arg0,String arg)  throws java.lang.Exception{

	stub.setBamConfiguration(arg0,arg);

	}

	public void expireSessionsInWebapp(String arg0,long arg)  throws java.lang.Exception{

	stub.expireSessionsInWebapp(arg0,arg);

	}

	public WebappsWrapper getPagedFaultyWebappsSummary(String arg0,String arg1,int arg)  throws java.lang.Exception{

		this.getPagedFaultyWebappsSummary=stub.getPagedFaultyWebappsSummary(arg0,arg1,arg);
		return this.getPagedFaultyWebappsSummary;

	}

	private WebappsWrapper getPagedFaultyWebappsSummary;

	public void  AssertgetPagedFaultyWebappsSummary(WebappsWrapper expected) {	
		Assert.assertEquals(getPagedFaultyWebappsSummary , expected );		
	}
	public void stopAllWebapps()  throws java.lang.Exception{

	stub.stopAllWebapps();

	}

	public void deleteStoppedWebapps(String[] arg)  throws java.lang.Exception{

	stub.deleteStoppedWebapps(arg);

	}

	public void deleteAllStoppedWebapps()  throws java.lang.Exception{

	stub.deleteAllStoppedWebapps();

	}

	public SessionsWrapper getActiveSessions(String arg0,int arg)  throws java.lang.Exception{

		this.getActiveSessions=stub.getActiveSessions(arg0,arg);
		return this.getActiveSessions;

	}

	private SessionsWrapper getActiveSessions;

	public void  AssertgetActiveSessions(SessionsWrapper expected) {	
		Assert.assertEquals(getActiveSessions , expected );		
	}
	public boolean isDefaultVersionManagementEnabled()  throws java.lang.Exception{

		this.isDefaultVersionManagementEnabled=stub.isDefaultVersionManagementEnabled();
		return this.isDefaultVersionManagementEnabled;

	}

	private boolean isDefaultVersionManagementEnabled;

	public void  AssertisDefaultVersionManagementEnabled(boolean expected) {	
		Assert.assertEquals(isDefaultVersionManagementEnabled , expected );		
	}



	public void initWebappAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "WebappAdmin";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new WebappAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}