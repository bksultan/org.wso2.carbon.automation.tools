//package robotlib;
package robot.lib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.theme.mgt.stub.registry.resource.stub.common.xsd.ResourceData;
import org.wso2.carbon.theme.mgt.stub.registry.resource.stub.beans.xsd.ContentBean;
import org.wso2.carbon.theme.mgt.stub.registry.resource.stub.beans.xsd.ContentDownloadBean;
import org.wso2.carbon.theme.mgt.stub.registry.resource.stub.beans.xsd.ResourceTreeEntryBean;
import org.wso2.carbon.theme.mgt.stub.ThemeMgtServiceStub;
import org.wso2.carbon.theme.mgt.stub.registry.resource.stub.beans.xsd.MetadataBean;
import javax.activation.DataHandler;
import org.wso2.carbon.theme.mgt.stub.registry.resource.stub.beans.xsd.CollectionContentBean;


public class ThemeMgtServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ThemeMgtServiceStub stub;


	//Constructor		
	public ThemeMgtServiceLibrary(){

	}		

	public String getTextContent(String arg)  throws java.lang.Exception{

		this.getTextContent=stub.getTextContent(arg);
		return this.getTextContent;

	}

	private String getTextContent;

	public void  AssertgetTextContent(String expected) {	
		Assert.assertEquals(getTextContent , expected );		
	}
	public void delete(String arg)  throws java.lang.Exception{

	stub.delete(arg);

	}

	public MetadataBean getMetadata(String arg)  throws java.lang.Exception{

		this.getMetadata=stub.getMetadata(arg);
		return this.getMetadata;

	}

	private MetadataBean getMetadata;

	public void  AssertgetMetadata(MetadataBean expected) {	
		Assert.assertEquals(getMetadata , expected );		
	}
	public void addTextResource(String arg0,String arg1,String arg2,String arg3,String arg)  throws java.lang.Exception{

	stub.addTextResource(arg0,arg1,arg2,arg3,arg);

	}

	public void importResource(String arg0,String arg1,String arg2,String arg3,String arg4,String arg5,String arg)  throws java.lang.Exception{

	stub.importResource(arg0,arg1,arg2,arg3,arg4,arg5,arg);

	}

	public void addResource(String arg0,String arg1,String arg2,DataHandler arg3,String arg4,String arg)  throws java.lang.Exception{

	stub.addResource(arg0,arg1,arg2,arg3,arg4,arg);

	}

	public ResourceTreeEntryBean getResourceTreeEntry(String arg)  throws java.lang.Exception{

		this.getResourceTreeEntry=stub.getResourceTreeEntry(arg);
		return this.getResourceTreeEntry;

	}

	private ResourceTreeEntryBean getResourceTreeEntry;

	public void  AssertgetResourceTreeEntry(ResourceTreeEntryBean expected) {	
		Assert.assertEquals(getResourceTreeEntry , expected );		
	}
	public void updateTextContent(String arg0,String arg)  throws java.lang.Exception{

	stub.updateTextContent(arg0,arg);

	}

	public String[] getAllThemes(String arg)  throws java.lang.Exception{

		this.getAllThemes=stub.getAllThemes(arg);
		return this.getAllThemes;

	}

	private String[] getAllThemes;

	public void  AssertgetAllThemes(String[] expected) {	
		Assert.assertEquals(getAllThemes , expected );		
	}
	public void applyTheme(String arg0,String arg)  throws java.lang.Exception{

	stub.applyTheme(arg0,arg);

	}

	public String[] getAllPaths()  throws java.lang.Exception{

		this.getAllPaths=stub.getAllPaths();
		return this.getAllPaths;

	}

	private String[] getAllPaths;

	public void  AssertgetAllPaths(String[] expected) {	
		Assert.assertEquals(getAllPaths , expected );		
	}
	public void renameResource(String arg0,String arg1,String arg)  throws java.lang.Exception{

	stub.renameResource(arg0,arg1,arg);

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
	public String addCollection(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

		this.addCollection=stub.addCollection(arg0,arg1,arg2,arg);
		return this.addCollection;

	}

	private String addCollection;

	public void  AssertaddCollection(String expected) {	
		Assert.assertEquals(addCollection , expected );		
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


	public static void main(String[] args) {
		//ThemeMgtServiceLibrary l=new ThemeMgtServiceLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initThemeMgtService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ThemeMgtService";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new ThemeMgtServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}