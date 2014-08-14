package lib;

import java.rmi.RemoteException;

import javax.xml.xpath.XPathExpressionException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Stub;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.authenticator.stub.AuthenticationAdminStub;
import org.wso2.carbon.authenticator.stub.LoginAuthenticationExceptionException;
import org.wso2.carbon.authenticator.stub.LogoutAuthenticationExceptionException;

import property.AutomationContext;

/**
 * 
 * @author rukshan
 * 
 *         Auto generated class of AuthenticationAdminStub have override some
 *         methods
 *
 */
public class AuthenticationLibrary {

	public String name() {
		System.out.println(this.getClass().toString());
		return this.getClass().toString();
	}

	private static AuthenticationLibrary c;
	private static final Log log = LogFactory
			.getLog(AuthenticationLibrary.class);
	private AuthenticationAdminStub authenticationAdminStub; // stub instance
	public static String sessionString; // hold the session cookie

	/**
	 * 
	 * @param backendUrl
	 *            service url
	 * @throws AxisFault
	 */
	public AuthenticationLibrary(String backendUrl) throws AxisFault {
		String serviceName = "AuthenticationAdmin"; // set the service name
		String endPoint = backendUrl + serviceName; // set the service url with
													// service name
		if (log.isDebugEnabled()) {
			log.debug("EndPoint" + endPoint);
		}
		try {
			authenticationAdminStub = new AuthenticationAdminStub(endPoint); // create
																				// stub
																				// instance
		} catch (AxisFault axisFault) {
			log.info("authenticationAdminStub initialization fails");
			throw new AxisFault("authenticationAdminStub initialization fails");
		}
	}

	/**
	 * 
	 * @return service stub
	 */
	public Stub getServiceStub() {
		return this.authenticationAdminStub;
	}

	/**
	 * lower layer method to login to the product.
	 * 
	 * @param userName
	 *            user name
	 * @param password
	 *            password
	 * @param host
	 *            host
	 * @return return successfull or not
	 * @throws LoginAuthenticationExceptionException
	 * @throws RemoteException
	 */
	public String login(String userName, String password, String host)
			throws LoginAuthenticationExceptionException, RemoteException {
		Boolean loginStatus; // keep the login status
		ServiceContext serviceContext;
		String sessionCookie; // keep the session cookie
		loginStatus = authenticationAdminStub.login(userName, password, host); // try
																				// to
																				// login
		if (!loginStatus) {
			throw new LoginAuthenticationExceptionException(
					"Login Unsuccessful. Return false as a login status by Server");
		}
		log.info("Login Successful");
		// extract the session cookie
		serviceContext = authenticationAdminStub._getServiceClient()
				.getLastOperationContext().getServiceContext();
		sessionCookie = (String) serviceContext
				.getProperty(HTTPConstants.COOKIE_STRING);
		if (log.isDebugEnabled()) {
			log.debug("SessionCookie :" + sessionCookie);
		}
		return sessionCookie;
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @param backEndURL
	 * @return
	 * @throws LoginAuthenticationExceptionException
	 * @throws RemoteException
	 */
	public Boolean unsuccessfulLogin(String userName, String password,
			String backEndURL) throws LoginAuthenticationExceptionException,
			RemoteException {
		return authenticationAdminStub.login(userName, password, backEndURL);
	}

	/**
	 * logout from product
	 * 
	 * @throws LogoutAuthenticationExceptionException
	 * @throws RemoteException
	 */
	public void logOut() throws LogoutAuthenticationExceptionException,
			RemoteException {
		authenticationAdminStub.logout();
		log.info("log out");
	}

	/**
	 * 
	 * @return authentication Admin Stub
	 */
	public Stub getAuthenticationAdminStub() {
		return authenticationAdminStub;
	}

	/**
	 * used create object with default configuration
	 */
	public AuthenticationLibrary() {
		// get the jks file
		String jks = AutomationContext
				.context(AutomationContext.PRODUCT_LOCATION)
				+ "/repository/resources/security/client-truststore.jks";
		// String jks =
		// "/media/rukshan/Stuff/ubunto back/wso2esb-4.8.1"+"/repository/resources/security/client-truststore.jks";
		String pass = "wso2carbon";// wso2Carbon

		// set the security configuration
		System.setProperty("javax.net.ssl.trustStore", jks);
		System.setProperty("javax.net.ssl.trustStorePassword", pass);

		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST); // get
																					// the
																					// host
																					// name
																					// from
																					// automation.xml
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT); // get
																					// the
																					// port
																					// name
																					// from
																					// the
																					// automation.xml
		String backEndUrl = "https://" + host + ":" + port + "/services/"; // set
																			// the
																			// service
																			// url
		// String u = "https://localhost:9443/services/";
		try {
			c = new AuthenticationLibrary(backEndUrl); // create the new object

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Login to the product.
	 * 
	 * @param userName
	 *            user name
	 * @param password
	 *            password
	 * @param host
	 *            host name
	 * @return return whether login is success. success if successfull
	 * @throws Exception
	 */
	public String LoginAs(String userName, String password, String host)
			throws Exception {
		try {
			String log = c.login(userName, password, host); // login using stub
			System.out.println(log);
			sessionString = log; // get the session cookie
			return log;
		} catch (AxisFault e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "error";
	}

	/**
	 * Login to the product
	 * 
	 * @param user
	 * @param host
	 *            Host ip/name/domain
	 * @return
	 * @throws Exception
	 */
	public String LoginAs(String user) throws Exception {

		String tenet, name;
		String[] u = user.split("-");
		if (u.length != 2) {
			// only tenet-user format is valid
			throw new Exception("Invalid Login Format!-use format");
		}
		tenet = u[0]; // get the tenet
		name = u[1]; // get the user

		String username;
		String password;
		String host;
		try {
			username = AutomationContext.getUserName(tenet, name); // get the
																	// user name
			password = AutomationContext.getPassword(tenet, name); // get the
																	// pass word
			host = AutomationContext.getHostName(); // get the default host name
		} catch (XPathExpressionException e) {
			// if the xpath error occur
			System.out.println(e.getMessage());
			throw new Exception("non-exsiting User");
		}

		// log in to the system
		return LoginAs(username, password, host);
	}
}
