package lib;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;

import org.wso2.carbon.aarservices.stub.types.carbon.AARServiceData;
import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;
import org.wso2.carbon.proxyadmin.stub.types.carbon.ProxyData;

/**
 * use to create important object
 * 
 * @author rukshan
 *
 */
public class ObjectPool {

	/**
	 * used create array of AARServiceData[] object. 
	 * 
	 * @param fileD path to the aar file.
	 * createAARServiceData(new String[]{"path","hierarchy"});
	 * or
	 * createAARServiceData(new String[]{"path"}); 
	 * 
	 * @return AARServiceData[]
	 */
	public static AARServiceData[] createAARServiceData(String... fileD) {
		String ServiceHierarchy, file;
		file = fileD[0];
		if (fileD.length == 1) {			// if one argument assume it is file path
			ServiceHierarchy = "";
		} else if (fileD.length > 1) {
			ServiceHierarchy = fileD[1];	// if two argument, set second as hierarchy
		} else {
			return null;
		}

		try {
			File f = new File(file);

			AARServiceData aarServiceData = new AARServiceData();	// create AARServiceData object
			aarServiceData.setFileName(f.getName());				// set the file name
			URL url = new URL("file://" + f.getAbsolutePath());		// create file as URL
			DataHandler dh = new DataHandler(url);			

			System.out.println(aarServiceData.getFileName());
			System.out.println(url);

			aarServiceData.setDataHandler(dh);						//set the data handler
			aarServiceData.setServiceHierarchy(ServiceHierarchy);	//set the Service Hierarchy

			return new AARServiceData[] { aarServiceData };			// return AARServiceData object as array
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * used to create array of UploadedFileItem objects
	 * 
	 * @param fileName file path
	 * @return	return UploadedFileItem[]
	 */
	public static UploadedFileItem[] createUploadedFileItems(String fileName) {
		File file=new File(fileName);
		URL url;
		try {
			url = new URL("file://" + file.getAbsolutePath());	// create file URL
		} catch (MalformedURLException e) {
			return null;
		}
        DataHandler dh = new DataHandler(url);								//create data handler
		UploadedFileItem[] carbonAppArray = new UploadedFileItem[1];
		UploadedFileItem carbonApp = new UploadedFileItem();				//create object
		carbonApp.setFileName(file.getName());								//set file name
		carbonApp.setDataHandler(dh);										//set data handler
		carbonApp.setFileType("jar");										//set the file type 
		carbonAppArray[0] = carbonApp;										//set the first element of array
		return carbonAppArray;
	}

	/**
	 * 
	 * used to create proxy data.
	 * 
	 * @param name		name of the service
	 * @param wsdlURI	url of the wsdl
	 * @return ProxyData
	 */
	public ProxyData createProxyData(String name, String wsdlURI) {
		String serviceEndPoint=wsdlURI;
		String[] transport = { "http", "https" };		// set the transport protocols
		ProxyData data = new ProxyData();
		data.setName(name);								//set the service name
		data.setWsdlURI(wsdlURI);						// set the URL
		data.setTransports(transport);					// set the transport 
		data.setStartOnLoad(true);	
		// String serviceEndPoint = "https://localhost:8243/services";
		
		// set the endpoint synapse
		data.setEndpointXML("<endpoint xmlns=\"http://ws.apache.org/ns/synapse\"><address uri=\""
				+ serviceEndPoint + "\" /></endpoint>");
		data.setEnableSecurity(true);
		return data;
	}
}
