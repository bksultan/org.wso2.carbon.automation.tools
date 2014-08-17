//package robotlib;
package robotlib;

import lib.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import property.AutomationContext;
import org.wso2.carbon.transport.mgt.stub.types.carbon.TransportSummary;
import org.wso2.carbon.transport.mgt.stub.TransportAdminStub;
import org.wso2.carbon.transport.mgt.stub.types.carbon.TransportData;
import org.wso2.carbon.transport.mgt.stub.types.carbon.TransportDetails;
import org.wso2.carbon.transport.mgt.stub.types.carbon.TransportParameter;


public class TransportAdminLibrary{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private TransportAdminStub stub;


	//Constructor		
	public TransportAdminLibrary(){

	}		

	public TransportParameter[] getGloballyDefinedOutParameters(String arg)  throws java.lang.Exception{

		this.getGloballyDefinedOutParameters=stub.getGloballyDefinedOutParameters(arg);
		return this.getGloballyDefinedOutParameters;

	}

	private TransportParameter[] getGloballyDefinedOutParameters;

	public void  AssertgetGloballyDefinedOutParameters(TransportParameter[] expected) {	
		Assert.assertEquals(getGloballyDefinedOutParameters , expected );		
	}
	public void updateServiceSpecificOutParameters(String arg0,String arg1,TransportParameter[] arg)  throws java.lang.Exception{

	stub.updateServiceSpecificOutParameters(arg0,arg1,arg);

	}

	public TransportParameter[] getServiceSpecificOutParameters(String arg0,String arg)  throws java.lang.Exception{

		this.getServiceSpecificOutParameters=stub.getServiceSpecificOutParameters(arg0,arg);
		return this.getServiceSpecificOutParameters;

	}

	private TransportParameter[] getServiceSpecificOutParameters;

	public void  AssertgetServiceSpecificOutParameters(TransportParameter[] expected) {	
		Assert.assertEquals(getServiceSpecificOutParameters , expected );		
	}
	public TransportParameter[] getGloballyDefinedInParameters(String arg)  throws java.lang.Exception{

		this.getGloballyDefinedInParameters=stub.getGloballyDefinedInParameters(arg);
		return this.getGloballyDefinedInParameters;

	}

	private TransportParameter[] getGloballyDefinedInParameters;

	public void  AssertgetGloballyDefinedInParameters(TransportParameter[] expected) {	
		Assert.assertEquals(getGloballyDefinedInParameters , expected );		
	}
	public TransportParameter[] getServiceSpecificInParameters(String arg0,String arg)  throws java.lang.Exception{

		this.getServiceSpecificInParameters=stub.getServiceSpecificInParameters(arg0,arg);
		return this.getServiceSpecificInParameters;

	}

	private TransportParameter[] getServiceSpecificInParameters;

	public void  AssertgetServiceSpecificInParameters(TransportParameter[] expected) {	
		Assert.assertEquals(getServiceSpecificInParameters , expected );		
	}
	public void updateGloballyDefinedInParameters(String arg0,TransportParameter[] arg)  throws java.lang.Exception{

	stub.updateGloballyDefinedInParameters(arg0,arg);

	}

	public void updateServiceSpecificInParameters(String arg0,String arg1,TransportParameter[] arg)  throws java.lang.Exception{

	stub.updateServiceSpecificInParameters(arg0,arg1,arg);

	}

	public void updateGloballyDefinedOutParameters(String arg0,TransportParameter[] arg)  throws java.lang.Exception{

	stub.updateGloballyDefinedOutParameters(arg0,arg);

	}

	public TransportData[] getAllTransportData()  throws java.lang.Exception{

		this.getAllTransportData=stub.getAllTransportData();
		return this.getAllTransportData;

	}

	private TransportData[] getAllTransportData;

	public void  AssertgetAllTransportData(TransportData[] expected) {	
		Assert.assertEquals(getAllTransportData , expected );		
	}
	public void addExposedTransports(String arg0,String arg)  throws java.lang.Exception{

	stub.addExposedTransports(arg0,arg);

	}

	public TransportSummary[] listTransports()  throws java.lang.Exception{

		this.listTransports=stub.listTransports();
		return this.listTransports;

	}

	private TransportSummary[] listTransports;

	public void  AssertlistTransports(TransportSummary[] expected) {	
		Assert.assertEquals(listTransports , expected );		
	}
	public TransportSummary[] listTransportsForService(String arg)  throws java.lang.Exception{

		this.listTransportsForService=stub.listTransportsForService(arg);
		return this.listTransportsForService;

	}

	private TransportSummary[] listTransportsForService;

	public void  AssertlistTransportsForService(TransportSummary[] expected) {	
		Assert.assertEquals(listTransportsForService , expected );		
	}
	public void removeExposedTransports(String arg0,String arg)  throws java.lang.Exception{

	stub.removeExposedTransports(arg0,arg);

	}

	public void disableSender(String arg)  throws java.lang.Exception{

	stub.disableSender(arg);

	}

	public void disableListener(String arg)  throws java.lang.Exception{

	stub.disableListener(arg);

	}

	public TransportSummary[] listExposedTransports(String arg)  throws java.lang.Exception{

		this.listExposedTransports=stub.listExposedTransports(arg);
		return this.listExposedTransports;

	}

	private TransportSummary[] listExposedTransports;

	public void  AssertlistExposedTransports(TransportSummary[] expected) {	
		Assert.assertEquals(listExposedTransports , expected );		
	}
	public TransportDetails getTransportDetails(String arg)  throws java.lang.Exception{

		this.getTransportDetails=stub.getTransportDetails(arg);
		return this.getTransportDetails;

	}

	private TransportDetails getTransportDetails;

	public void  AssertgetTransportDetails(TransportDetails expected) {	
		Assert.assertEquals(getTransportDetails , expected );		
	}
	public boolean dependenciesAvailable(String arg0,TransportParameter[] arg)  throws java.lang.Exception{

		this.dependenciesAvailable=stub.dependenciesAvailable(arg0,arg);
		return this.dependenciesAvailable;

	}

	private boolean dependenciesAvailable;

	public void  AssertdependenciesAvailable(boolean expected) {	
		Assert.assertEquals(dependenciesAvailable , expected );		
	}


	public static void main(String[] args) {
		//TransportAdminLibrary l=new TransportAdminLibrary();
		//l.setX(10);
		//l.setY(25);
		//System.out.println(l.getSum());
	}

	public void initTransportAdmin() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "TransportAdmin";
		String endPoint;
		//String host = PropertyInfo.read("host");
		//String port = PropertyInfo.read("port");
		String host = AutomationContext.context(AutomationContext.PRODUCT_HOST);
		String port = AutomationContext.context(AutomationContext.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new TransportAdminStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}