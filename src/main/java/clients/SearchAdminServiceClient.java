package clients;

import client.support.modules.AuthenticationLibrary;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.testng.Assert;
import client.configuration.AutomationConfigurationReader;
import org.wso2.carbon.registry.search.stub.beans.xsd.SearchResultsBean;
import org.wso2.carbon.registry.search.stub.beans.xsd.AdvancedSearchResultsBean;
import org.wso2.carbon.registry.search.stub.beans.xsd.CustomSearchParameterBean;
import org.wso2.carbon.registry.search.stub.beans.xsd.MediaTypeValueList;
import org.wso2.carbon.registry.search.stub.SearchAdminServiceStub;


/**
 * Auto generated SearchAdminService service Client
 *
 * Service name : SearchAdminService
 * Service WSDL : SearchAdminService.wsdl
 * Service stub class : SearchAdminServiceStub
 * Client Library : SearchAdminServiceLibrary
 *
 * @author rukshan
 * 
 */

public class SearchAdminServiceClient{
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	private SearchAdminServiceStub stub;


	//Constructor		
	public SearchAdminServiceClient(){

	}		

	public void deleteFilter(String arg)  throws java.lang.Exception{

	stub.deleteFilter(arg);

	}

	public MediaTypeValueList getMediaTypeSearch(String arg)  throws java.lang.Exception{

		this.getMediaTypeSearch=stub.getMediaTypeSearch(arg);
		return this.getMediaTypeSearch;

	}

	private MediaTypeValueList getMediaTypeSearch;

	public void  AssertgetMediaTypeSearch(MediaTypeValueList expected) {	
		Assert.assertEquals(getMediaTypeSearch , expected );		
	}
	public String[] getSavedFilters()  throws java.lang.Exception{

		this.getSavedFilters=stub.getSavedFilters();
		return this.getSavedFilters;

	}

	private String[] getSavedFilters;

	public void  AssertgetSavedFilters(String[] expected) {	
		Assert.assertEquals(getSavedFilters , expected );		
	}
	public void saveAdvancedSearchFilter(CustomSearchParameterBean arg0,String arg)  throws java.lang.Exception{

	stub.saveAdvancedSearchFilter(arg0,arg);

	}

	public SearchResultsBean getSearchResults(String arg0,String arg)  throws java.lang.Exception{

		this.getSearchResults=stub.getSearchResults(arg0,arg);
		return this.getSearchResults;

	}

	private SearchResultsBean getSearchResults;

	public void  AssertgetSearchResults(SearchResultsBean expected) {	
		Assert.assertEquals(getSearchResults , expected );		
	}
	public AdvancedSearchResultsBean getAdvancedSearchResults(CustomSearchParameterBean arg)  throws java.lang.Exception{

		this.getAdvancedSearchResults=stub.getAdvancedSearchResults(arg);
		return this.getAdvancedSearchResults;

	}

	private AdvancedSearchResultsBean getAdvancedSearchResults;

	public void  AssertgetAdvancedSearchResults(AdvancedSearchResultsBean expected) {	
		Assert.assertEquals(getAdvancedSearchResults , expected );		
	}
	public CustomSearchParameterBean getAdvancedSearchFilter(String arg)  throws java.lang.Exception{

		this.getAdvancedSearchFilter=stub.getAdvancedSearchFilter(arg);
		return this.getAdvancedSearchFilter;

	}

	private CustomSearchParameterBean getAdvancedSearchFilter;

	public void  AssertgetAdvancedSearchFilter(CustomSearchParameterBean expected) {	
		Assert.assertEquals(getAdvancedSearchFilter , expected );		
	}



	public void initSearchAdminService() throws AxisFault {
		String sessionCookie=AuthenticationLibrary.sessionString;
		String serviceName = "SearchAdminService";
		String endPoint;
		String host = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_HOST);
		String port = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_PORT);
		String backEndUrl = "https://" + host + ":" + port + "/services/";
		endPoint = backEndUrl + serviceName;//+ "/services/" 
		stub = new SearchAdminServiceStub(endPoint);
		// Authenticate Your stub from sessionCooke
		ServiceClient serviceClient;
		Options option;

		serviceClient = stub._getServiceClient();
		option = serviceClient.getOptions();
		option.setManageSession(true);
		option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,sessionCookie);
	}

}