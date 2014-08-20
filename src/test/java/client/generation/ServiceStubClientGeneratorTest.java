package client.generation;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import client.genration.ServiceStubClientGenerator;

public class ServiceStubClientGeneratorTest {

	@Test
	public void testSave() {

		// System.setProperty("user.dir","src/test/resources/testng");
		File target = new File("testout/src/main/java");
		ServiceStubClientGenerator g=new ServiceStubClientGenerator();
		g.setPackageName("robotlib");
		if (!target.exists()) {
			target.mkdirs();
		}

		try {
			String loc = "/testout/src/main/java";

			File f = new File(
					"testout/src/main/java/robotlib/TestngtestingclassLibrary.java");
			// f=new File(url.toURI());
			System.out.println(f.exists());
			if (f.exists()) {
				f.delete();
			}

			Class<?> c = ServiceStubClientGenerator.class;
			Object client = g;

			Field path = c.getDeclaredField("path");
			path.setAccessible(true);
			path.set(client, loc);

			Class<?>[] argTypes = new Class[] { String.class, String.class };
			Method main = c.getDeclaredMethod("save", argTypes);
			main.setAccessible(true);
			main.invoke(client, "Testngtestingclass",
					"package robotlib;public class TestngtestingclassLibrary{}");

			Assert.assertTrue(f.exists());
			if (f.exists()) {
				f.delete();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void testIsMethodNameValid() {
		try {

			Class<?> c = ServiceStubClientGenerator.class;
			Class<?>[] argTypes = new Class[] { String.class };
			Method main = c.getDeclaredMethod("isMethodNameValid", argTypes);
			main.setAccessible(true);
			Object client = c.newInstance();

			String[] type = { "getint", "getboolean", "getString", "setint",
					"setboolean", "setString" };
			ArrayList<String> list = new ArrayList<String>();

			for (String s : type) {
				list.add(s);
			}

			Field f = c.getDeclaredField("operations");
			f.setAccessible(true);
			f.set(client, list);

			for (String s : type) {
				Object re = main.invoke(client, s);
				Assert.assertTrue((Boolean) re);
			}

			String[] type2 = { "setBool", "getInnn", "set", "#$@%$", "32424" };

			for (String s : type2) {
				Object re = main.invoke(client, s);
				Assert.assertFalse((Boolean) re);
			}

		} catch (NoSuchMethodException e) {
			Assert.assertTrue(false);
		} catch (SecurityException e) {
			Assert.assertTrue(false);
		} catch (IllegalAccessException e) {
			Assert.assertTrue(false);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(false);
		} catch (InvocationTargetException e) {
			Assert.assertTrue(false);
		} catch (NoSuchFieldException e) {
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
		}
	}

	@Test
	public void testIsNameValid() {
		// fail("Not yet implemented");
		try {

			Class<?> c = ServiceStubClientGenerator.class;
			Class<?>[] argTypes = new Class[] { String.class };
			Method main = c.getDeclaredMethod("isNameValid", argTypes);
			main.setAccessible(true);

			String[] type = { "int", "boolean", "String", "Class", "Object",
					"void", "java.lang.String", "double", "long" };

			for (String s : type) {
				Object re = main.invoke(null, s);
				Assert.assertFalse((Boolean) re);
			}

			String[] type2 = { "intt", "123", "@#$@$#", "ClientGenerator" };

			for (String s : type2) {
				Object re = main.invoke(null, s);
				Assert.assertTrue((Boolean) re);
			}

		} catch (NoSuchMethodException e) {
			Assert.assertTrue(false);
		} catch (SecurityException e) {
			Assert.assertTrue(false);
		} catch (IllegalAccessException e) {
			Assert.assertTrue(false);
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(false);
		} catch (InvocationTargetException e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testGetOperations() {
		try {

			Class<?> c = ServiceStubClientGenerator.class;
			Class<?>[] argTypes = new Class[] { Class.class, String.class };
			Method main = c.getDeclaredMethod("getOperations", argTypes);
			main.setAccessible(true);

			Class<?> cl = Class
					.forName("org.wso2.carbon.statistics.stub.StatisticsAdminStub");
			Object re = main.invoke(c.newInstance(), cl,
					"/StatisticsAdmin.wsdl");
			ArrayList<?> op = (ArrayList<?>) re;

			//Assert.assertEquals(op.size(), 22);
			Assert.assertTrue(op.size()>0);

			Class<?> cl2 = Class
					.forName("org.wso2.carbon.statistics.stub.StatisticsAdminStub");
			Object re2 = main.invoke(c.newInstance(), cl2,
					"/noSuchStatisticsAdmin.wsdl");
			ArrayList<?> op2 = (ArrayList<?>) re2;

			Assert.assertEquals(op2.size(), 0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGetServiceName() {
		try {

			Class<?> c = ServiceStubClientGenerator.class;
			Class<?>[] argTypes = new Class[] { Class.class, String.class };
			Method main = c.getDeclaredMethod("getServiceName", argTypes);
			main.setAccessible(true);

			Class<?> cl = Class
					.forName("org.wso2.carbon.statistics.stub.StatisticsAdminStub");
			Object re = main.invoke(c.newInstance(), cl,
					"/StatisticsAdmin.wsdl");
			String op = (String) re;
			Assert.assertEquals(op, "StatisticsAdmin");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGenerateClient() {
		ServiceStubClientGenerator g = new ServiceStubClientGenerator();
		g.setPackageName("robot.lib");
		try {

			URL url = null;
			try {
				url = ClassLoader.getSystemResource("templateR.stg");
			} catch (Exception e) {
				System.out.println("here" + e.getMessage());
			}
			STGroup group = new STGroupFile(url, "UTF-8", '<', '>');

			Class<?> c = ServiceStubClientGenerator.class;
			Field fgroup = c.getDeclaredField("group");
			fgroup.setAccessible(true);
			fgroup.set(g, group);

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		File target = new File("testout/src/main/java");
		if (!target.exists()) {
			target.mkdirs();
		}

		try {
			String loc = "/testout/src/main/java";

			File f = new File(
					"testout/src/main/java/robot/lib/StatisticsAdminLibrary.java");
			if (f.exists()) {
				f.delete();
			}

			Class<?> c = ServiceStubClientGenerator.class;
			Field path = c.getDeclaredField("path");
			path.setAccessible(true);
			path.set(g, loc);

			new ServiceStubClientGenerator().generateClient(new String[] {
					"org.wso2.carbon.statistics.stub.StatisticsAdminStub",
					"StatisticsAdmin" });
			Assert.assertTrue(f.exists());
			if (f.exists()) {
				f.delete();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void testGenerateLibraries() {
		System.out.println("----------testGenerateLibraries------------");
		File target = new File("testout/src/main/java");
		if (!target.exists()) {
			target.mkdirs();
		}

		ServiceStubClientGenerator g = new ServiceStubClientGenerator();

		g.setPackageName("robotlib");
		try {

			URL url = null;
			try {
				url = ClassLoader.getSystemResource("templateR.stg");
			} catch (Exception e) {
				System.out.println("here" + e.getMessage());
			}
			STGroup group = new STGroupFile(url, "UTF-8", '<', '>');

			Class<?> c = ServiceStubClientGenerator.class;
			Field fgroup = c.getDeclaredField("group");
			fgroup.setAccessible(true);
			fgroup.set(g, group);

			Field docf = c.getDeclaredField("doc");
			docf.setAccessible(true);
			
			InputStream s = ClassLoader
					.getSystemResourceAsStream("service.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = dBuilder.parse(s);
			docf.set(g, doc);

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

		try {
			String loc = "/testout/src/main/java";

			String[] files = {
					"AdminManagementServiceLibrary.java",
					"ApplicationAdminLibrary.java",
					"CarbonAppUploaderLibrary.java",
					"DiscoveryAdminLibrary.java",
					"JarServiceCreatorAdminLibrary.java",
					"ProxyServiceAdminLibrary.java",
					"ServiceAdminLibrary.java",
					"ServiceUploaderLibrary.java",
					"StatisticsAdminLibrary.java",
					"UserAdminLibrary.java"
					};
			for (String fi : files) {
				File f = new File("testout/src/main/java/robot/lib/" + fi);
				if (f.exists()) {
					f.delete();
				}
			}

			Class<?> c = ServiceStubClientGenerator.class;
			Field path = c.getDeclaredField("path");
			path.setAccessible(true);
			path.set(g, loc);

			new ServiceStubClientGenerator().GenerateLibraries("robot.lib");

			for (String fi : files) {
				File f = new File("testout/src/main/java/robot/lib/" + fi);
				System.out.println(fi);
				Assert.assertTrue(f.exists(),fi);

				if (f.exists()) {
					f.delete();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		if (target.exists()) {
			target.delete();
		}
	}

	
}
