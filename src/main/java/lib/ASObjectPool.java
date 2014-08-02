package lib;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;

import org.wso2.carbon.aarservices.stub.types.carbon.AARServiceData;
import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;

public class ASObjectPool {

	public static AARServiceData[] createAARServiceData(String... fileD) {
		String ServiceHierarchy, file;
		file = fileD[0];
		if (fileD.length == 1) {
			ServiceHierarchy = "";
		} else if (fileD.length > 1) {
			ServiceHierarchy = fileD[1];
		} else {
			return null;
		}

		try {
			File f = new File(file);

			AARServiceData aarServiceData = new AARServiceData();
			aarServiceData.setFileName(f.getName());
			URL url = new URL("file://" + f.getAbsolutePath());
			DataHandler dh = new DataHandler(url);

			System.out.println(aarServiceData.getFileName());
			System.out.println(url);

			aarServiceData.setDataHandler(dh);
			aarServiceData.setServiceHierarchy(ServiceHierarchy);

			return new AARServiceData[] { aarServiceData };
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static UploadedFileItem[] createUploadedFileItems(String fileName) {
		File file=new File(fileName);
		URL url;
		try {
			url = new URL("file://" + file.getAbsolutePath());
		} catch (MalformedURLException e) {
			return null;
		}
        DataHandler dh = new DataHandler(url);
		UploadedFileItem[] carbonAppArray = new UploadedFileItem[1];
		UploadedFileItem carbonApp = new UploadedFileItem();
		carbonApp.setFileName(file.getName());
		carbonApp.setDataHandler(dh);
		carbonApp.setFileType("jar");
		carbonAppArray[0] = carbonApp;
		return carbonAppArray;
	}
}
