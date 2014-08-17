package property;

import java.io.File;
import java.net.URL;

import javax.xml.xpath.XPathExpressionException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationContextTest {

	@BeforeClass
	public void setXML() {
		URL url = null;
		try {
			url = ClassLoader.getSystemResource("automation.xml");
			File f=new File(url.getFile());
			f=f.getParentFile().getParentFile().getParentFile();
			System.setProperty("framework.resource.location",f.getAbsolutePath()+"/src/main/resources/");
			System.out.println(url.getFile());
			System.out.println("context p: "+f.getAbsolutePath());
		} catch (Exception e) {
			System.out.println("here" + e.getMessage());
		}
		
		
	}

	@Test
	public void context() {
		Assert.assertEquals(
				AutomationContext.context(AutomationContext.PRODUCT_HOST),
				"localhost");
		Assert.assertEquals(
				AutomationContext
						.context("//userManagement/tenants/tenant[@key='wso2']/admin/user[@key='admin']/userName"),
				"admin");

		Assert.assertEquals(AutomationContext.context("//no/nosuh/re"), "");
	}

	@Test
	public void getPassword() {
		try {
			Assert.assertEquals(
					AutomationContext.getPassword("admin", "admin"), "admin");
		} catch (XPathExpressionException e) {
			 Assert.fail();
		}
		
		try {
			Assert.assertEquals(
					AutomationContext.getPassword("admin", "admin1"), "");
			Assert.assertEquals(
					AutomationContext.getPassword("admin1", "admin"), "");
		} catch (XPathExpressionException e) {
		}
	}

	@Test
	public void getUserName() {
		try {
			Assert.assertEquals(
					AutomationContext.getUserName("admin", "admin"), "admin");
		} catch (XPathExpressionException e) {
			 Assert.fail();
		}
		
		try {
			Assert.assertEquals(
					AutomationContext.getUserName("admin", "admin1"), "");
			Assert.assertEquals(
					AutomationContext.getUserName("admin1", "admin"), "");
		} catch (XPathExpressionException e) {
		}
	}
	
	@Test
	public void getHostName() {
		try {
			Assert.assertEquals(AutomationContext.getHostName(), "localhost");
		} catch (XPathExpressionException e) {
			 Assert.fail();
		}
		
	}
	
	@Test
	public void getDelayTime() {
		try {
			Assert.assertEquals(AutomationContext.getDeploymentDelay(), 60000);
		} catch (XPathExpressionException e) {
			 Assert.fail();
		}
		
	}
}
