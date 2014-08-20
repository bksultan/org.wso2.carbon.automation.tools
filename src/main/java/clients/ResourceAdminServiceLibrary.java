//package robotlib;
package clients;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import org.wso2.carbon.registry.extensions.stub.beans.xsd.VersionsBean;
import org.wso2.carbon.registry.extensions.stub.beans.xsd.ResourceTreeEntryBean;
import org.wso2.carbon.registry.extensions.stub.beans.xsd.ContentBean;
import org.wso2.carbon.registry.extensions.stub.common.xsd.ResourceData;
import org.wso2.carbon.registry.extensions.stub.beans.xsd.MetadataBean;
import org.wso2.carbon.registry.extensions.stub.ResourceAdminServiceStub;
import org.wso2.carbon.registry.extensions.stub.beans.xsd.CollectionContentBean;
import org.wso2.carbon.registry.extensions.stub.beans.xsd.ContentDownloadBean;

import javax.activation.DataHandler;

import org.wso2.carbon.registry.extensions.stub.beans.xsd.PermissionBean;

import client.configuration.AutomationConfigurationReader;
import client.support.modules.AuthenticationLibrary;


public class ResourceAdminServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ResourceAdminServiceStub stub;


	//Constructor		
	public ResourceAdminServiceLibrary(){

	}		

	public boolean moveResource(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

		this.moveResource=stub.moveResource(arg0,arg1,arg2,arg);
		return this.moveResource;

	}

	private boolean moveResource;

	public void  AssertmoveResource(boolean expected) {	
		Assert.assertEquals(moveResource , expected );		
	}
	public boolean addTextResource(String arg0,String arg1,String arg2,String arg3,String arg)  throws java.lang.Exception{

		this.addTextResource=stub.addTextResource(arg0,arg1,arg2,arg3,arg);
		return this.addTextResource;

	}

	private boolean addTextResource;

	public void  AssertaddTextResource(boolean expected) {	
		Assert.assertEquals(addTextResource , expected );		
	}
	public void setSessionResourcePath(String arg)  throws java.lang.Exception{

	stub.setSessionResourcePath(arg);

	}

	public void addSymbolicLink(String arg0,String arg1,String arg)  throws java.lang.Exception{

	stub.addSymbolicLink(arg0,arg1,arg);

	}

	public String getMediatypeDefinitions()  throws java.lang.Exception{

		this.getMediatypeDefinitions=stub.getMediatypeDefinitions();
		return this.getMediatypeDefinitions;

	}

	private String getMediatypeDefinitions;

	public void  AssertgetMediatypeDefinitions(String expected) {	
		Assert.assertEquals(getMediatypeDefinitions , expected );		
	}
	public boolean importResource(String arg0,String arg1,String arg2,String arg3,String arg4,String arg)  throws java.lang.Exception{

		this.importResource=stub.importResource(arg0,arg1,arg2,arg3,arg4,arg);
		return this.importResource;

	}

	private boolean importResource;

	public void  AssertimportResource(boolean expected) {	
		Assert.assertEquals(importResource , expected );		
	}
	public boolean copyResource(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

		this.copyResource=stub.copyResource(arg0,arg1,arg2,arg);
		return this.copyResource;

	}

	private boolean copyResource;

	public void  AssertcopyResource(boolean expected) {	
		Assert.assertEquals(copyResource , expected );		
	}
	public String[] listExtensions()  throws java.lang.Exception{

		this.listExtensions=stub.listExtensions();
		return this.listExtensions;

	}

	private String[] listExtensions;

	public void  AssertlistExtensions(String[] expected) {	
		Assert.assertEquals(listExtensions , expected );		
	}
	public ResourceTreeEntryBean getResourceTreeEntry(String arg)  throws java.lang.Exception{

		this.getResourceTreeEntry=stub.getResourceTreeEntry(arg);
		return this.getResourceTreeEntry;

	}

	private ResourceTreeEntryBean getResourceTreeEntry;

	public void  AssertgetResourceTreeEntry(ResourceTreeEntryBean expected) {	
		Assert.assertEquals(getResourceTreeEntry , expected );		
	}
	public String getCustomUIMediatypeDefinitions()  throws java.lang.Exception{

		this.getCustomUIMediatypeDefinitions=stub.getCustomUIMediatypeDefinitions();
		return this.getCustomUIMediatypeDefinitions;

	}

	private String getCustomUIMediatypeDefinitions;

	public void  AssertgetCustomUIMediatypeDefinitions(String expected) {	
		Assert.assertEquals(getCustomUIMediatypeDefinitions , expected );		
	}
	public boolean createVersion(String arg)  throws java.lang.Exception{

		this.createVersion=stub.createVersion(arg);
		return this.createVersion;

	}

	private boolean createVersion;

	public void  AssertcreateVersion(boolean expected) {	
		Assert.assertEquals(createVersion , expected );		
	}
	public boolean updateTextContent(String arg0,String arg)  throws java.lang.Exception{

		this.updateTextContent=stub.updateTextContent(arg0,arg);
		return this.updateTextContent;

	}

	private boolean updateTextContent;

	public void  AssertupdateTextContent(boolean expected) {	
		Assert.assertEquals(updateTextContent , expected );		
	}
	public void addRemoteLink(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

	stub.addRemoteLink(arg0,arg1,arg2,arg);

	}

	public boolean changeUserPermissions(String arg0,String arg)  throws java.lang.Exception{

		this.changeUserPermissions=stub.changeUserPermissions(arg0,arg);
		return this.changeUserPermissions;

	}

	private boolean changeUserPermissions;

	public void  AssertchangeUserPermissions(boolean expected) {	
		Assert.assertEquals(changeUserPermissions , expected );		
	}
	public boolean restoreVersion(String arg)  throws java.lang.Exception{

		this.restoreVersion=stub.restoreVersion(arg);
		return this.restoreVersion;

	}

	private boolean restoreVersion;

	public void  AssertrestoreVersion(boolean expected) {	
		Assert.assertEquals(restoreVersion , expected );		
	}
	public VersionsBean getVersionsBean(String arg)  throws java.lang.Exception{

		this.getVersionsBean=stub.getVersionsBean(arg);
		return this.getVersionsBean;

	}

	private VersionsBean getVersionsBean;

	public void  AssertgetVersionsBean(VersionsBean expected) {	
		Assert.assertEquals(getVersionsBean , expected );		
	}
	public boolean renameResource(String arg0,String arg1,String arg)  throws java.lang.Exception{

		this.renameResource=stub.renameResource(arg0,arg1,arg);
		return this.renameResource;

	}

	private boolean renameResource;

	public void  AssertrenameResource(boolean expected) {	
		Assert.assertEquals(renameResource , expected );		
	}
	public ResourceData[] getResourceData(String[] arg)  throws java.lang.Exception{

		this.getResourceData=stub.getResourceData(arg);
		return this.getResourceData;

	}

	private ResourceData[] getResourceData;

	public void  AssertgetResourceData(ResourceData[] expected) {	
		Assert.assertEquals(getResourceData , expected );		
	}
	public String getSessionResourcePath()  throws java.lang.Exception{

		this.getSessionResourcePath=stub.getSessionResourcePath();
		return this.getSessionResourcePath;

	}

	private String getSessionResourcePath;

	public void  AssertgetSessionResourcePath(String expected) {	
		Assert.assertEquals(getSessionResourcePath , expected );		
	}
	public ContentDownloadBean getContentDownloadBean(String arg)  throws java.lang.Exception{

		this.getContentDownloadBean=stub.getContentDownloadBean(arg);
		return this.getContentDownloadBean;

	}

	private ContentDownloadBean getContentDownloadBean;

	public void  AssertgetContentDownloadBean(ContentDownloadBean expected) {	
		Assert.assertEquals(getContentDownloadBean , expected );		
	}
	public boolean addUserPermission(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

		this.addUserPermission=stub.addUserPermission(arg0,arg1,arg2,arg);
		return this.addUserPermission;

	}

	private boolean addUserPermission;

	public void  AssertaddUserPermission(boolean expected) {	
		Assert.assertEquals(addUserPermission , expected );		
	}
	public String addCollection(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

		this.addCollection=stub.addCollection(arg0,arg1,arg2,arg);
		return this.addCollection;

	}

	private String addCollection;

	public void  AssertaddCollection(String expected) {	
		Assert.assertEquals(addCollection , expected );		
	}
	public String getCollectionMediatypeDefinitions()  throws java.lang.Exception{

		this.getCollectionMediatypeDefinitions=stub.getCollectionMediatypeDefinitions();
		return this.getCollectionMediatypeDefinitions;

	}

	private String getCollectionMediatypeDefinitions;

	public void  AssertgetCollectionMediatypeDefinitions(String expected) {	
		Assert.assertEquals(getCollectionMediatypeDefinitions , expected );		
	}
	public boolean changeRolePermissions(String arg0,String arg)  throws java.lang.Exception{

		this.changeRolePermissions=stub.changeRolePermissions(arg0,arg);
		return this.changeRolePermissions;

	}

	private boolean changeRolePermissions;

	public void  AssertchangeRolePermissions(boolean expected) {	
		Assert.assertEquals(changeRolePermissions , expected );		
	}
	public ContentBean getContentBean(String arg)  throws java.lang.Exception{

		this.getContentBean=stub.getContentBean(arg);
		return this.getContentBean;

	}

	private ContentBean getContentBean;

	public void  AssertgetContentBean(ContentBean expected) {	
		Assert.assertEquals(getContentBean , expected );		
	}
	public CollectionContentBean getCollectionContent(String arg)  throws java.lang.Exception{

		this.getCollectionContent=stub.getCollectionContent(arg);
		return this.getCollectionContent;

	}

	private CollectionContentBean getCollectionContent;

	public void  AssertgetCollectionContent(CollectionContentBean expected) {	
		Assert.assertEquals(getCollectionContent , expected );		
	}
	public boolean addRolePermission(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

		this.addRolePermission=stub.addRolePermission(arg0,arg1,arg2,arg);
		return this.addRolePermission;

	}

	private boolean addRolePermission;

	public void  AssertaddRolePermission(boolean expected) {	
		Assert.assertEquals(addRolePermission , expected );		
	}
	public String getTextContent(String arg)  throws java.lang.Exception{

		this.getTextContent=stub.getTextContent(arg);
		return this.getTextContent;

	}

	private String getTextContent;

	public void  AssertgetTextContent(String expected) {	
		Assert.assertEquals(getTextContent , expected );		
	}
	public void setDescription(String arg0,String arg)  throws java.lang.Exception{

	stub.setDescription(arg0,arg);

	}

	public boolean addResource(String arg0,String arg1,String arg2,DataHandler arg3,String arg)  throws java.lang.Exception{

		this.addResource=stub.addResource(arg0,arg1,arg2,arg3,arg);
		return this.addResource;

	}

	private boolean addResource;

	public void  AssertaddResource(boolean expected) {	
		Assert.assertEquals(addResource , expected );		
	}
	public boolean removeExtension(String arg)  throws java.lang.Exception{

		this.removeExtension=stub.removeExtension(arg);
		return this.removeExtension;

	}

	private boolean removeExtension;

	public void  AssertremoveExtension(boolean expected) {	
		Assert.assertEquals(removeExtension , expected );		
	}
	public boolean addExtension(String arg0,DataHandler arg)  throws java.lang.Exception{

		this.addExtension=stub.addExtension(arg0,arg);
		return this.addExtension;

	}

	private boolean addExtension;

	public void  AssertaddExtension(boolean expected) {	
		Assert.assertEquals(addExtension , expected );		
	}
	public MetadataBean getMetadata(String arg)  throws java.lang.Exception{

		this.getMetadata=stub.getMetadata(arg);
		return this.getMetadata;

	}

	private MetadataBean getMetadata;

	public void  AssertgetMetadata(MetadataBean expected) {	
		Assert.assertEquals(getMetadata , expected );		
	}
	public String getProperty(String arg0,String arg)  throws java.lang.Exception{

		this.getProperty=stub.getProperty(arg0,arg);
		return this.getProperty;

	}

	private String getProperty;

	public void  AssertgetProperty(String expected) {	
		Assert.assertEquals(getProperty , expected );		
	}
	public PermissionBean getPermissions(String arg)  throws java.lang.Exception{

		this.getPermissions=stub.getPermissions(arg);
		return this.getPermissions;

	}

	private PermissionBean getPermissions;

	public void  AssertgetPermissions(PermissionBean expected) {	
		Assert.assertEquals(getPermissions , expected );		
	}
	public boolean delete(String arg)  throws java.lang.Exception{

		this.delete=stub.delete(arg);
		return this.delete;

	}

	private boolean delete;

	public void  Assertdelete(boolean expected) {	
		Assert.assertEquals(delete , expected );		
	}


	public static void main(String[] args) {
		//ResourceAdminServiceLibrary l=new ResourceAdminServiceLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initResourceAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ResourceAdminService";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new ResourceAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}