package robotlib;
import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;
import org.wso2.carbon.application.mgt.stub.upload.CarbonAppUploaderStub;


public class CarbonAppUploaderLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private CarbonAppUploaderStub stub;


	//Constructor		
	public CarbonAppUploaderLibrary(){

	}		

	public void uploadApp(UploadedFileItem[] arg)  throws java.lang.Exception{

	stub.uploadApp(arg);

	}



	public static void main(String[] args) {
		//CarbonAppUploaderLibrary l=new CarbonAppUploaderLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initCarbonAppUploader() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "CarbonAppUploader";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new CarbonAppUploaderStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}