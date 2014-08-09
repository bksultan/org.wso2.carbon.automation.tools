//package robotlib;
package robotlib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.application.mgt.stub.ApplicationAdminStub;
import org.wso2.carbon.application.mgt.stub.types.carbon.ApplicationMetadata;
import javax.activation.DataHandler;


public class ApplicationAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private ApplicationAdminStub stub;


	//Constructor		
	public ApplicationAdminLibrary(){

	}		

	public void deleteFaultyApplication(String[] arg)  throws java.lang.Exception{

	stub.deleteFaultyApplication(arg);

	}

	public String[] listAllFaultyApplications()  throws java.lang.Exception{

		this.listAllFaultyApplications=stub.listAllFaultyApplications();
		return this.listAllFaultyApplications;

	}

	private String[] listAllFaultyApplications;

	public void  AssertlistAllFaultyApplications(String[] expected) {	
		Assert.assertEquals(listAllFaultyApplications , expected );		
	}
	public ApplicationMetadata getAppData(String arg)  throws java.lang.Exception{

		this.getAppData=stub.getAppData(arg);
		return this.getAppData;

	}

	private ApplicationMetadata getAppData;

	public void  AssertgetAppData(ApplicationMetadata expected) {	
		Assert.assertEquals(getAppData , expected );		
	}
	public String[] listAllApplications()  throws java.lang.Exception{

		this.listAllApplications=stub.listAllApplications();
		return this.listAllApplications;

	}

	private String[] listAllApplications;

	public void  AssertlistAllApplications(String[] expected) {	
		Assert.assertEquals(listAllApplications , expected );		
	}
	public void deleteApplication(String arg)  throws java.lang.Exception{

	stub.deleteApplication(arg);

	}

	public DataHandler downloadCappArchive(String arg)  throws java.lang.Exception{

		this.downloadCappArchive=stub.downloadCappArchive(arg);
		return this.downloadCappArchive;

	}

	private DataHandler downloadCappArchive;

	public void  AssertdownloadCappArchive(DataHandler expected) {	
		Assert.assertEquals(downloadCappArchive , expected );		
	}
	public String getFaultException(String arg)  throws java.lang.Exception{

		this.getFaultException=stub.getFaultException(arg);
		return this.getFaultException;

	}

	private String getFaultException;

	public void  AssertgetFaultException(String expected) {	
		Assert.assertEquals(getFaultException , expected );		
	}
	public void deleteAllFaultyAppliations()  throws java.lang.Exception{

	stub.deleteAllFaultyAppliations();

	}



	public static void main(String[] args) {
		//ApplicationAdminLibrary l=new ApplicationAdminLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initApplicationAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "ApplicationAdmin";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new ApplicationAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}