package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.identity.user.store.configuration.stub.dto.UserStoreDTO;
import org.wso2.carbon.identity.user.store.configuration.stub.api.Properties;
import org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceStub;


/**
 * Auto generated UserStoreConfigAdminService service Client
 *
 * Service name : UserStoreConfigAdminService
 * Service WSDL : UserStoreConfigAdminService.wsdl
 * Service stub class : UserStoreConfigAdminServiceStub
 * Client Library : UserStoreConfigAdminServiceLibrary
 *
 * @author rukshan
 * 
 */

public class UserStoreConfigAdminServiceClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private UserStoreConfigAdminServiceStub stub;


	//Constructor		
	public UserStoreConfigAdminServiceClient(){

	}		

	public Properties getUserStoreManagerProperties(String arg)  throws java.lang.Exception{

		this.getUserStoreManagerProperties=stub.getUserStoreManagerProperties(arg);
		return this.getUserStoreManagerProperties;

	}

	private Properties getUserStoreManagerProperties;

	public void  AssertgetUserStoreManagerProperties(Properties expected) {	
		Assert.assertEquals(getUserStoreManagerProperties , expected );		
	}
	public void addUserStore(UserStoreDTO arg)  throws java.lang.Exception{

	stub.addUserStore(arg);

	}

	public UserStoreDTO[] getSecondaryRealmConfigurations()  throws java.lang.Exception{

		this.getSecondaryRealmConfigurations=stub.getSecondaryRealmConfigurations();
		return this.getSecondaryRealmConfigurations;

	}

	private UserStoreDTO[] getSecondaryRealmConfigurations;

	public void  AssertgetSecondaryRealmConfigurations(UserStoreDTO[] expected) {	
		Assert.assertEquals(getSecondaryRealmConfigurations , expected );		
	}
	public String[] getAvailableUserStoreClasses()  throws java.lang.Exception{

		this.getAvailableUserStoreClasses=stub.getAvailableUserStoreClasses();
		return this.getAvailableUserStoreClasses;

	}

	private String[] getAvailableUserStoreClasses;

	public void  AssertgetAvailableUserStoreClasses(String[] expected) {	
		Assert.assertEquals(getAvailableUserStoreClasses , expected );		
	}
	public void editUserStore(UserStoreDTO arg)  throws java.lang.Exception{

	stub.editUserStore(arg);

	}

	public void deleteUserStore(String arg)  throws java.lang.Exception{

	stub.deleteUserStore(arg);

	}

	public void editUserStoreWithDomainName(String arg0,UserStoreDTO arg)  throws java.lang.Exception{

	stub.editUserStoreWithDomainName(arg0,arg);

	}

	public void deleteUserStoresSet(String[] arg)  throws java.lang.Exception{

	stub.deleteUserStoresSet(arg);

	}

	public void changeUserStoreState(String arg0,boolean arg)  throws java.lang.Exception{

	stub.changeUserStoreState(arg0,arg);

	}




	public void initUserStoreConfigAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "UserStoreConfigAdminService";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new UserStoreConfigAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}