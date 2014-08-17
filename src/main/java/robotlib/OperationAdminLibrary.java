//package robotlib;
package robotlib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.operation.mgt.stub.types.OperationMetaDataWrapper;
import org.wso2.carbon.operation.mgt.stub.types.OperationMetaData;
import org.wso2.carbon.operation.mgt.stub.OperationAdminStub;


public class OperationAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private OperationAdminStub stub;


	//Constructor		
	public OperationAdminLibrary(){

	}		

	public OperationMetaData getOperationStatistics(String arg0,String arg)  throws java.lang.Exception{

		this.getOperationStatistics=stub.getOperationStatistics(arg0,arg);
		return this.getOperationStatistics;

	}

	private OperationMetaData getOperationStatistics;

	public void  AssertgetOperationStatistics(OperationMetaData expected) {	
		Assert.assertEquals(getOperationStatistics , expected );		
	}
	public void configureMTOM(String arg0,String arg1,String arg)  throws java.lang.Exception{

	stub.configureMTOM(arg0,arg1,arg);

	}

	public String[] listOperationPhases(String arg0,String arg1,int arg)  throws java.lang.Exception{

		this.listOperationPhases=stub.listOperationPhases(arg0,arg1,arg);
		return this.listOperationPhases;

	}

	private String[] listOperationPhases;

	public void  AssertlistOperationPhases(String[] expected) {	
		Assert.assertEquals(listOperationPhases , expected );		
	}
	public String[] listOperationPhaseHandlers(String arg0,String arg1,int arg2,String arg)  throws java.lang.Exception{

		this.listOperationPhaseHandlers=stub.listOperationPhaseHandlers(arg0,arg1,arg2,arg);
		return this.listOperationPhaseHandlers;

	}

	private String[] listOperationPhaseHandlers;

	public void  AssertlistOperationPhaseHandlers(String[] expected) {	
		Assert.assertEquals(listOperationPhaseHandlers , expected );		
	}
	public OperationMetaData[] listControlOperations(String arg)  throws java.lang.Exception{

		this.listControlOperations=stub.listControlOperations(arg);
		return this.listControlOperations;

	}

	private OperationMetaData[] listControlOperations;

	public void  AssertlistControlOperations(OperationMetaData[] expected) {	
		Assert.assertEquals(listControlOperations , expected );		
	}
	public String[] getDeclaredOperationParameters(String arg0,String arg)  throws java.lang.Exception{

		this.getDeclaredOperationParameters=stub.getDeclaredOperationParameters(arg0,arg);
		return this.getDeclaredOperationParameters;

	}

	private String[] getDeclaredOperationParameters;

	public void  AssertgetDeclaredOperationParameters(String[] expected) {	
		Assert.assertEquals(getDeclaredOperationParameters , expected );		
	}
	public OperationMetaDataWrapper listAllOperations(String arg)  throws java.lang.Exception{

		this.listAllOperations=stub.listAllOperations(arg);
		return this.listAllOperations;

	}

	private OperationMetaDataWrapper listAllOperations;

	public void  AssertlistAllOperations(OperationMetaDataWrapper expected) {	
		Assert.assertEquals(listAllOperations , expected );		
	}
	public OperationMetaData getOperationMetaData(String arg0,String arg)  throws java.lang.Exception{

		this.getOperationMetaData=stub.getOperationMetaData(arg0,arg);
		return this.getOperationMetaData;

	}

	private OperationMetaData getOperationMetaData;

	public void  AssertgetOperationMetaData(OperationMetaData expected) {	
		Assert.assertEquals(getOperationMetaData , expected );		
	}
	public String[] getOperationParameters(String arg0,String arg)  throws java.lang.Exception{

		this.getOperationParameters=stub.getOperationParameters(arg0,arg);
		return this.getOperationParameters;

	}

	private String[] getOperationParameters;

	public void  AssertgetOperationParameters(String[] expected) {	
		Assert.assertEquals(getOperationParameters , expected );		
	}
	public void removeOperationParameter(String arg0,String arg1,String arg)  throws java.lang.Exception{

	stub.removeOperationParameter(arg0,arg1,arg);

	}

	public OperationMetaData[] listPublishedOperations(String arg)  throws java.lang.Exception{

		this.listPublishedOperations=stub.listPublishedOperations(arg);
		return this.listPublishedOperations;

	}

	private OperationMetaData[] listPublishedOperations;

	public void  AssertlistPublishedOperations(OperationMetaData[] expected) {	
		Assert.assertEquals(listPublishedOperations , expected );		
	}
	public void setOperationParameters(String arg0,String arg1,String[] arg)  throws java.lang.Exception{

	stub.setOperationParameters(arg0,arg1,arg);

	}



	public static void main(String[] args) {
		//OperationAdminLibrary l=new OperationAdminLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initOperationAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "OperationAdmin";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new OperationAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}