//package robotlib;
package robotlib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.registry.properties.stub.PropertiesAdminServiceStub;
import org.wso2.carbon.registry.properties.stub.beans.xsd.PropertiesBean;
import org.wso2.carbon.registry.properties.stub.beans.xsd.RetentionBean;


public class PropertiesAdminServiceLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private PropertiesAdminServiceStub stub;


	//Constructor		
	public PropertiesAdminServiceLibrary(){

	}		

	public void removeProperty(String arg0,String arg)  throws java.lang.Exception{

	stub.removeProperty(arg0,arg);

	}

	public RetentionBean getRetentionProperties(String arg)  throws java.lang.Exception{

		this.getRetentionProperties=stub.getRetentionProperties(arg);
		return this.getRetentionProperties;

	}

	private RetentionBean getRetentionProperties;

	public void  AssertgetRetentionProperties(RetentionBean expected) {	
		Assert.assertEquals(getRetentionProperties , expected );		
	}
	public void updateProperty(String arg0,String arg1,String arg2,String arg)  throws java.lang.Exception{

	stub.updateProperty(arg0,arg1,arg2,arg);

	}

	public boolean setRetentionProperties(String arg0,RetentionBean arg)  throws java.lang.Exception{

		this.setRetentionProperties=stub.setRetentionProperties(arg0,arg);
		return this.setRetentionProperties;

	}

	private boolean setRetentionProperties;

	public void  AssertsetRetentionProperties(boolean expected) {	
		Assert.assertEquals(setRetentionProperties , expected );		
	}
	public void setProperty(String arg0,String arg1,String arg)  throws java.lang.Exception{

	stub.setProperty(arg0,arg1,arg);

	}

	public PropertiesBean getProperties(String arg0,String arg)  throws java.lang.Exception{

		this.getProperties=stub.getProperties(arg0,arg);
		return this.getProperties;

	}

	private PropertiesBean getProperties;

	public void  AssertgetProperties(PropertiesBean expected) {	
		Assert.assertEquals(getProperties , expected );		
	}


	public static void main(String[] args) {
		//PropertiesAdminServiceLibrary l=new PropertiesAdminServiceLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initPropertiesAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "PropertiesAdminService";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new PropertiesAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}