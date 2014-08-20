package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.repomanager.axis2.stub.Axis2RepoManagerStub;
import org.wso2.carbon.repomanager.axis2.stub.types.Axis2ArtifactUploadData;
import org.wso2.carbon.repomanager.axis2.stub.types.DirectoryStructureMetaData;
import javax.activation.DataHandler;


/**
 * Auto generated Axis2RepoManager service Client
 *
 * Service name : Axis2RepoManager
 * Service WSDL : Axis2RepoManager.wsdl
 * Service stub class : Axis2RepoManagerStub
 * Client Library : Axis2RepoManagerLibrary
 *
 * @author rukshan
 * 
 */

public class Axis2RepoManagerLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private Axis2RepoManagerStub stub;


	//Constructor		
	public Axis2RepoManagerLibrary(){

	}		

	public boolean uploadArtifact(Axis2ArtifactUploadData[] arg0,String arg)  throws java.lang.Exception{

		this.uploadArtifact=stub.uploadArtifact(arg0,arg);
		return this.uploadArtifact;

	}

	private boolean uploadArtifact;

	public void  AssertuploadArtifact(boolean expected) {	
		Assert.assertEquals(uploadArtifact , expected );		
	}
	public boolean deleteLib(String arg)  throws java.lang.Exception{

		this.deleteLib=stub.deleteLib(arg);
		return this.deleteLib;

	}

	private boolean deleteLib;

	public void  AssertdeleteLib(boolean expected) {	
		Assert.assertEquals(deleteLib , expected );		
	}
	public DirectoryStructureMetaData getDirectoryStructure()  throws java.lang.Exception{

		this.getDirectoryStructure=stub.getDirectoryStructure();
		return this.getDirectoryStructure;

	}

	private DirectoryStructureMetaData getDirectoryStructure;

	public void  AssertgetDirectoryStructure(DirectoryStructureMetaData expected) {	
		Assert.assertEquals(getDirectoryStructure , expected );		
	}
	public boolean restartAxis2Server()  throws java.lang.Exception{

		this.restartAxis2Server=stub.restartAxis2Server();
		return this.restartAxis2Server;

	}

	private boolean restartAxis2Server;

	public void  AssertrestartAxis2Server(boolean expected) {	
		Assert.assertEquals(restartAxis2Server , expected );		
	}
	public DataHandler downloadArtifact(String arg)  throws java.lang.Exception{

		this.downloadArtifact=stub.downloadArtifact(arg);
		return this.downloadArtifact;

	}

	private DataHandler downloadArtifact;

	public void  AssertdownloadArtifact(DataHandler expected) {	
		Assert.assertEquals(downloadArtifact , expected );		
	}



	public void initAxis2RepoManager() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "Axis2RepoManager";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new Axis2RepoManagerStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}