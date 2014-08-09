package lib;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.aarservices.stub.types.carbon.AARServiceData;
import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;
import org.wso2.carbon.proxyadmin.stub.types.carbon.ProxyData;

public class ObjectPoolTest {

	@Test
	public void createAARServiceData() {
		String file = "src/test/resources/artifacts/AS/aar/Axis2Service.aar";
		AARServiceData[] object = ObjectPool.createAARServiceData(file);
		Assert.assertNotNull(object);

		AARServiceData[] object2 = ObjectPool.createAARServiceData(file, "");
		Assert.assertNotNull(object2);

		try {
			AARServiceData[] object3 = ObjectPool.createAARServiceData();
			org.testng.Assert.fail();
		} catch (Exception e) {
		}

		AARServiceData[] object4 = ObjectPool
				.createAARServiceData(file, "", "");
		Assert.assertNotNull(object4);

		// AARServiceData[] object5 = ObjectPool
		// .createAARServiceData("nosuchfile.txt");
		// Assert.assertNull(object5);
	}

	@Test
	public void createProxyData() {
		ObjectPool p = new ObjectPool();
		ProxyData data = p.createProxyData("proxy",
				"https://localhost:8243/services/proxyadminservice.wsdl",
				"https://localhost:8243/services/proxyadminservice.wsdl");
		Assert.assertNotNull(data);
	}

	@Test
	public void createUploadedFileItems() {
		String file = "src/test/resources/artifacts/AS/aar/Axis2Service.aar";
		UploadedFileItem[] files = ObjectPool.createUploadedFileItems(file);
		Assert.assertNotNull(files);
		Assert.assertEquals(files[0].getFileName(), "Axis2Service.aar");
	}
}
