package generator;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientGeneratorTest {

	@Test
	public void testSave() {

		// System.setProperty("user.dir","src/test/resources/testng");
		File target=new File("testout/src/main/java");
		if(!target.exists()){
				target.mkdirs();
		}
		
		try {
			String loc = "/testout/src/main/java";

			File f = new File(
					"testout/src/main/java/robotlib/TestngtestingclassLibrary.java");
			//f=new File(url.toURI());
			System.out.println(f.exists());
			if (f.exists()) {
				f.delete();
			}

			Class<?> c = ClientGenerator.class;
			Object client = c.newInstance();

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

			Class<?> c = ClientGenerator.class;
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

			Class<?> c = ClientGenerator.class;
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

			Class<?> c = ClientGenerator.class;
			Class<?>[] argTypes = new Class[] { Class.class, String.class };
			Method main = c.getDeclaredMethod("getOperations", argTypes);
			main.setAccessible(true);

			Class<?> cl = Class
					.forName("org.wso2.carbon.statistics.stub.StatisticsAdminStub");
			Object re = main.invoke(c.newInstance(), cl,
					"/StatisticsAdmin.wsdl");
			ArrayList<?> op = (ArrayList<?>) re;

			Assert.assertEquals(op.size(), 22);

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

			Class<?> c = ClientGenerator.class;
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
		File target=new File("testout/src/main/java");
		if(!target.exists()){
				target.mkdirs();
		}
		ClientGenerator g = new ClientGenerator();

		try {
			String loc = "/testout/src/main/java";

			File f = new File(
					"testout/src/main/java/robotlib/StatisticsAdminLibrary.java");
			if (f.exists()) {
				f.delete();
			}

			Class<?> c = ClientGenerator.class;
			Field path = c.getDeclaredField("path");
			path.setAccessible(true);
			path.set(g, loc);

			new ClientGenerator().generateClient(new String[] {
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
		File target=new File("testout/src/main/java");
		if(!target.exists()){
				target.mkdirs();
		}
		
		ClientGenerator g = new ClientGenerator();

		try {
			String loc = "/testout/src/main/java";

			String[] files = { "AdminManagementServiceLibrary.java",
					"ApplicationAdminLibrary.java",
					"CarbonAppUploaderLibrary.java",
					"DiscoveryAdminLibrary.java",
					"JarServiceCreatorAdminLibrary.java",
					"ProxyServiceAdminLibrary.java",
					"ServiceAdminLibrary.java", "ServiceUploaderLibrary.java",
					"StatisticsAdminLibrary.java", "UserAdminLibrary.java" };
			for (String fi : files) {
				File f = new File(
						"testout/src/main/java/robotlib/"
								+ fi);
				if (f.exists()) {
					f.delete();
				}
			}

			Class<?> c = ClientGenerator.class;
			Field path = c.getDeclaredField("path");
			path.setAccessible(true);
			path.set(g, loc);

			new ClientGenerator().GenerateLibraries();

			for (String fi : files) {
				File f = new File(
						"testout/src/main/java/robotlib/"
								+ fi);
				Assert.assertTrue(f.exists());

				if (f.exists()) {
					f.delete();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
