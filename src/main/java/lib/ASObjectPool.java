package lib;

import java.io.File;
import java.net.URL;

import javax.activation.DataHandler;

import org.wso2.carbon.aarservices.stub.types.carbon.AARServiceData;

public class ASObjectPool {
	public static AARServiceData[] createAARServiceData(String... fileD) {
		String ServiceHierarchy,file;
		file=fileD[0];
		if(fileD.length==1){
			ServiceHierarchy="";
		}else if(fileD.length>1){
			ServiceHierarchy=fileD[1];
		}else{
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
}
