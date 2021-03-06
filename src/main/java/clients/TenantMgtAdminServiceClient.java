package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.TenantInfoBean;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceStub;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.PaginatedTenantInfoBean;


/**
 * Auto generated TenantMgtAdminService service Client
 *
 * Service name : TenantMgtAdminService
 * Service WSDL : TenantMgtAdminService.wsdl
 * Service stub class : TenantMgtAdminServiceStub
 * Client Library : TenantMgtAdminServiceLibrary
 *
 * @author rukshan
 * 
 */

public class TenantMgtAdminServiceClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private TenantMgtAdminServiceStub stub;


	//Constructor		
	public TenantMgtAdminServiceClient(){

	}		

	public String addSkeletonTenant(TenantInfoBean arg)  throws java.lang.Exception{

		this.addSkeletonTenant=stub.addSkeletonTenant(arg);
		return this.addSkeletonTenant;

	}

	private String addSkeletonTenant;

	public void  AssertaddSkeletonTenant(String expected) {	
		Assert.assertEquals(addSkeletonTenant , expected );		
	}
	public String addTenant(TenantInfoBean arg)  throws java.lang.Exception{

		this.addTenant=stub.addTenant(arg);
		return this.addTenant;

	}

	private String addTenant;

	public void  AssertaddTenant(String expected) {	
		Assert.assertEquals(addTenant , expected );		
	}
	public void activateTenant(String arg)  throws java.lang.Exception{

	stub.activateTenant(arg);

	}

	public TenantInfoBean[] retrieveTenants()  throws java.lang.Exception{

		this.retrieveTenants=stub.retrieveTenants();
		return this.retrieveTenants;

	}

	private TenantInfoBean[] retrieveTenants;

	public void  AssertretrieveTenants(TenantInfoBean[] expected) {	
		Assert.assertEquals(retrieveTenants , expected );		
	}
	public void deleteTenant(String arg)  throws java.lang.Exception{

	stub.deleteTenant(arg);

	}

	public TenantInfoBean getTenant(String arg)  throws java.lang.Exception{

		this.getTenant=stub.getTenant(arg);
		return this.getTenant;

	}

	private TenantInfoBean getTenant;

	public void  AssertgetTenant(TenantInfoBean expected) {	
		Assert.assertEquals(getTenant , expected );		
	}
	public PaginatedTenantInfoBean retrievePaginatedPartialSearchTenants(String arg0,int arg)  throws java.lang.Exception{

		this.retrievePaginatedPartialSearchTenants=stub.retrievePaginatedPartialSearchTenants(arg0,arg);
		return this.retrievePaginatedPartialSearchTenants;

	}

	private PaginatedTenantInfoBean retrievePaginatedPartialSearchTenants;

	public void  AssertretrievePaginatedPartialSearchTenants(PaginatedTenantInfoBean expected) {	
		Assert.assertEquals(retrievePaginatedPartialSearchTenants , expected );		
	}
	public PaginatedTenantInfoBean retrievePaginatedTenants(int arg)  throws java.lang.Exception{

		this.retrievePaginatedTenants=stub.retrievePaginatedTenants(arg);
		return this.retrievePaginatedTenants;

	}

	private PaginatedTenantInfoBean retrievePaginatedTenants;

	public void  AssertretrievePaginatedTenants(PaginatedTenantInfoBean expected) {	
		Assert.assertEquals(retrievePaginatedTenants , expected );		
	}
	public void updateTenant(TenantInfoBean arg)  throws java.lang.Exception{

	stub.updateTenant(arg);

	}

	public TenantInfoBean[] retrievePartialSearchTenants(String arg)  throws java.lang.Exception{

		this.retrievePartialSearchTenants=stub.retrievePartialSearchTenants(arg);
		return this.retrievePartialSearchTenants;

	}

	private TenantInfoBean[] retrievePartialSearchTenants;

	public void  AssertretrievePartialSearchTenants(TenantInfoBean[] expected) {	
		Assert.assertEquals(retrievePartialSearchTenants , expected );		
	}
	public void deactivateTenant(String arg)  throws java.lang.Exception{

	stub.deactivateTenant(arg);

	}




	public void initTenantMgtAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "TenantMgtAdminService";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new TenantMgtAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}