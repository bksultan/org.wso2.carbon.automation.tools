//package lib;
//
//import javax.xml.namespace.QName;
//
//import org.apache.axiom.om.OMElement;
//import org.apache.axis2.AxisFault;
//import org.apache.axis2.client.Options;
//import org.apache.axis2.client.ServiceClient;
//import org.wso2.carbon.admin.mgt.stub.AdminManagementServiceStub;
//import org.wso2.carbon.application.mgt.stub.upload.types.carbon.UploadedFileItem;
//import org.wso2.carbon.discovery.admin.stub.types.mgt.ServiceDiscoveryConfig;
//import org.wso2.carbon.registry.info.stub.InfoAdminServiceStub;
//import org.wso2.carbon.service.mgt.stub.ServiceAdminStub;
//import org.wso2.carbon.statistics.stub.StatisticsAdminStub;
//import org.wso2.carbon.statistics.stub.types.carbon.SystemStatistics;
//import org.wso2.carbon.user.mgt.stub.UserAdminStub;
//import org.wso2.carbon.user.mgt.stub.types.carbon.UserRealmInfo;
//
//import property.AutomationContext;
//import robotlib.ApplicationAdminLibrary;
//import robotlib.CarbonAppUploaderLibrary;
//import robotlib.ServiceUploaderLibrary;
//
//public class Test {
//
//	static String sessionCookie;
//
//	public static void main1(String[] args) {
//		// TODO Auto-generated method stub
//
//		AuthenticationLibrary al = new AuthenticationLibrary();
//		sessionCookie = al.LoginAs("admin", "admin", "localhost");
//
//		// PropertyInfo.set("host","localhost");
//		// PropertyInfo.set("port","9443");
//		// PropertyInfo i=new PropertyInfo();
//		// System.out.println(PropertyInfo.read("host"));
//		// System.out.println(PropertyInfo.read("port"));
//		// Class<?> c;
//		// try {
//		// c = Class
//		// .forName("org.wso2.carbon.service.mgt.stub.ServiceAdminStub");
//		// InputStream input = c.getResourceAsStream("/ServiceAdmin.wsdl");
//		// WSDLParser parser = new WSDLParser();
//		// Definitions defs = parser.parse(input);
//		// for (PortType pt : defs.getPortTypes()) {
//		// for (Operation op : pt.getOperations()) {
//		// System.out.println(op.getName());
//		// }
//		// }
//		// } catch (Exception e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//		// StringTemplate query = new StringTemplate("hello " +
//		// "$if(paramEquals)$" +
//		// " it works! " +
//		// "$endif$ " +
//		// "world");
//		// query.setAttribute("paramEquals", param.equals("val1"));
//		// System.out.println("result: "+query.toString());
//
//		// ServiceAdmin();
//		// discoveryAdmin();
//		// InputStream input = c.getResourceAsStream(wsdl);
//		// try {
//		// WSDLParser parser = new WSDLParser();
//		// String wsdl="http://ubuntu:8280/services/echo?wsdl";
//		// Definitions defs = parser.parse(wsdl);
//		// System.out.println(defs.getTargetNamespace());
//		// } catch (Exception e) {
//		// System.out.println(e.getMessage());
//		// }
//
//		// ServiceAdminLibrary l = new ServiceAdminLibrary();
//		// try {
//		// l.initServiceAdmin();
//		// System.out.println(l.getNumberOfActiveServices());
//		// System.out.println(l.getServiceData("echo").getServiceType());
//		// ServiceMetaData m = new ServiceMetaData();
//		// m.setActive(true);
//		// m.setServiceType("proxy");
//		// // OMElement o=new
//		//
//		// } catch (Exception e) {
//		// System.out.println(e.getMessage());
//		// }
//
//	}
//
//	public static void objectLog(ServiceDiscoveryConfig object) {
//		System.out.println(object.isEnabledSpecified());
//	}
//
//	public static void discoveryAdmin() {
//		// DiscoveryAdminLibrary l = new DiscoveryAdminLibrary();
//
//		// try {
//		// l.initDiscoveryAdmin();
//		// System.out.println(l.getServiceDiscoveryConfig()
//		// .isProxyURLSpecified());
//		// } catch (Exception e) {
//		// System.out.println(e.getMessage());
//		// }
//	}
//
//	public static void ServiceAdmin() {
//		try {
//			String serviceName = "ServiceAdmin";
//			ServiceAdminStub stub;
//			String backEndUrl = "https://localhost:9443/services";
//			String endPoint = backEndUrl + "/services/" + serviceName;
//			stub = new ServiceAdminStub(endPoint);
//			// Authenticate Your stub from sessionCooke
//			ServiceClient serviceClient;
//			Options option;
//
//			serviceClient = stub._getServiceClient();
//			option = serviceClient.getOptions();
//			option.setManageSession(true);
//			option.setProperty(
//					org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
//					sessionCookie);
//
//			System.out.println(stub.getNumberOfActiveServices());
//			// System.out.println(stub.isUserValid("admin", "user"));
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		// ServiceAdminLibrary li = new ServiceAdminLibrary();
//		// try {
//		// li.initServiceAdmin();
//		// System.out.println(li.getNumberOfActiveServices());
//		// li.AssertgetNumberOfActiveServices(4);
//		// } catch (Exception e) {
//		// System.out.println(e.getMessage());
//		// }
//
//	}
//
//	public static void AdminManagementService() {
//		try {
//			String serviceName = "AdminManagementService";
//			AdminManagementServiceStub stub;
//			String backEndUrl = "https://localhost:9443";
//			String endPoint = backEndUrl + "/services/" + serviceName;
//			stub = new AdminManagementServiceStub(endPoint);
//			// Authenticate Your stub from sessionCooke
//			ServiceClient serviceClient;
//			Options option;
//
//			serviceClient = stub._getServiceClient();
//			option = serviceClient.getOptions();
//			option.setManageSession(true);
//			option.setProperty(
//					org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
//					sessionCookie);
//
//			System.out.println(stub.generateRandomCaptcha());
//			// System.out.println(stub.isUserValid("admin", "user"));
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public static void InfoAdminService() {
//		try {
//			String serviceName = "InfoAdminService";
//			InfoAdminServiceStub stub;
//			String backEndUrl = "https://localhost:9443";
//			String endPoint = backEndUrl + "/services/" + serviceName;
//			stub = new InfoAdminServiceStub(endPoint);
//			// Authenticate Your stub from sessionCooke
//			ServiceClient serviceClient;
//			Options option;
//
//			serviceClient = stub._getServiceClient();
//			option = serviceClient.getOptions();
//			option.setManageSession(true);
//			option.setProperty(
//					org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
//					sessionCookie);
//
//			System.out.println(stub.isProfileExisting("admin", "admin"));
//			System.out.println(stub.isUserValid("admin", "user"));
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public static void StatisticsAdmin() {
//		try {
//			String serviceName = "StatisticsAdmin";
//			StatisticsAdminStub statisticsAdminStub;
//			String backEndUrl = "https://localhost:9443/services/";
//			String endPoint = backEndUrl + "/services/" + serviceName;
//			statisticsAdminStub = new StatisticsAdminStub(endPoint);
//			// Authenticate Your stub from sessionCooke
//			ServiceClient serviceClient;
//			Options option;
//
//			serviceClient = statisticsAdminStub._getServiceClient();
//			option = serviceClient.getOptions();
//			option.setManageSession(true);
//			option.setProperty(
//					org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
//					sessionCookie);
//
//			SystemStatistics stat = statisticsAdminStub.getSystemStatistics();
//			System.out.println("Host :" + stat.getServerName());
//			System.out.println("Server Start Time :"
//					+ stat.getServerStartTime());
//			System.out.println("System Up Time :" + stat.getSystemUpTime());
//			System.out.print(stat.getUsedMemory().getValue()
//					+ stat.getUsedMemory().getUnit() + " of ");
//			System.out.println(stat.getTotalMemory().getValue()
//					+ stat.getTotalMemory().getUnit() + " memory used");
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public static void UserAdmin() {
//		try {
//			String serviceName = "UserAdmin";
//			UserAdminStub statisticsAdminStub;
//			String backEndUrl = "https://localhost:9443/services/";
//			String endPoint = backEndUrl + "/services/" + serviceName;
//			statisticsAdminStub = new UserAdminStub(endPoint);
//			// Authenticate Your stub from sessionCooke
//			ServiceClient serviceClient;
//			Options option;
//
//			serviceClient = statisticsAdminStub._getServiceClient();
//			option = serviceClient.getOptions();
//			option.setManageSession(true);
//			option.setProperty(
//					org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
//					sessionCookie);
//
//			UserRealmInfo stat = statisticsAdminStub.getUserRealmInfo();
//			System.out.println(stat.getAdminRole());
//			System.out.println(stat.getAdminUser());
//			System.out.println(stat.getEveryOneRole());
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public static void main2(String[] args) {
//		AxisServiceClient c = new AxisServiceClient();
//
//		String endPOint = "StockQuote";
//		String operationName = "getSimpleQuote";
//		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
//		endPOint = a + "/" + endPOint;
//
//		String namespace = c.getTargetNamespace(endPOint + "?wsdl");
//		OMElement method = c.getMethod(operationName, namespace, "", "WSO2");
//		OMElement res = null;
//		try {
//			res = c.sendReceive(method, endPOint, operationName);
//			String aa = res
//					.getFirstElement()
//					.getFirstChildWithName(
//							new QName("http://services.samples/xsd", "last"))
//					.getText();
//
//			System.out.println(aa);
//			System.out.println("finished");
//		} catch (AxisFault e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getFaultAction());
//		}
//
//	}
//
//	public static void mainE(String[] args) {
//		AuthenticationLibrary al = new AuthenticationLibrary();
//		sessionCookie = al.LoginAs("admin", "admin", "localhost");
//
//		ProxyServiceAdminLibrary l = new ProxyServiceAdminLibrary();
//		try {
//			l.initProxyServiceAdmin();
//			// System.out.println(l.addProxy("quote",
//			// "http://192.168.0.1:8080/axis2/services/SimpleStockQuoteService?wsdl"));
//			// System.out.println(l.addProxy("secquote",
//			// "http://localhost:8080/axis2/services/SecureStockQuoteService?wsdl"));
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		AxisServiceClient c = new AxisServiceClient();
//		Standard s = new Standard();
//
//		c.setServiceName("quote");
//		c.setServiceOperation("getQuote");
//		c.setServiceParentChild("request");
//		c.setServiceParas("symbol", "wso2");
//
//		c.setServiceHttpHeader("foo", "bar");
//		Object o = c.InvokeOperation();
//		System.out.println(s.containString(o, "GetQuoteResponse"));
//		System.out.println(s.containString(o, "WSO2 Company"));
//
//		c.clearServiceHttpHeader();
//		c.setServiceHttpHeader("my_custom_header1", "bar");
//		c.setServiceHttpHeader("my_custom_header2", "foo");
//		o = c.InvokeOperation();
//		System.out.println(o);
//		System.out.println(s.containString(o, "GetQuoteResponse"));
//		System.out.println(s.containString(o, "WSO2 Company"));
//
//	}
//
//	public static void main3(String[] args) {
////		AuthenticationLibrary al = new AuthenticationLibrary();
////		sessionCookie = al.LoginAs("admin", "admin", "localhost");
////
//////		AxisServiceClient c=new AxisServiceClient();
////		JarServiceCreatorAdminLibrary l=new JarServiceCreatorAdminLibrary();
////		
////		try {
////			l.initJarServiceCreatorAdmin();
////			
////			URL u=new URL("file://" +new File("src/test/resources/artifacts/AS/jar/artifact1/JarService.jar").getAbsolutePath());
////			DataHandler dh = new DataHandler(u);
////			List<DataHandler> jarList = new ArrayList();
////			l.createAndDeployService(arg0, arg1, arg2, arg);
////			l.upload("", jarList, dh);
//////			c.setServiceName("CommodityQuote");
//////			c.setServiceOperation("getQuoteRequest");
//////			c.setServiceParas("symbol", "mn");
//////			OMElement o=c.InvokeOperation();
//////			System.out.println(o);
////		} catch (Exception e) {
////			e.printStackTrace();
////			System.out.println(e.getMessage());
////		}	
//		 
//		
//	}
//
//	public static void main4(String[] args) {
//		CarbonAppUploaderLibrary c=new CarbonAppUploaderLibrary();
//		AuthenticationLibrary al = new AuthenticationLibrary();
//		sessionCookie = al.LoginAs("admin", "admin", "localhost");
//		ApplicationAdminLibrary a=new ApplicationAdminLibrary();
//		AxisServiceClient ac=new AxisServiceClient();
////		ServiceAdminLibrary s=new ServiceAdminLibrary();
//		
//		try {
//			c.initCarbonAppUploader();
//			UploadedFileItem[] o=ASObjectPool.createUploadedFileItems("src/test/resources/artifacts/AS/car/AxisCApp-1.0.0.car");
//			c.uploadApp(o);
//			ac.waitDeployService("Calculator");
//			
//			a.initApplicationAdmin();
//			System.out.println(a.getAppData("AxisCApp_1.0.0"));
//			System.out.println(a.listAllApplications().length);
////			s.deleteServiceGroups(new String[]{"CommodityQuote"});
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		
//		
//	}
//	
//	public static void main5(String[] args) {
//		AuthenticationLibrary al = new AuthenticationLibrary();
//		sessionCookie = al.LoginAs("admin", "admin", "localhost");
//		
//		AxisServiceClient c=new AxisServiceClient();
//		
//		Standard s=new Standard();
//		
//		ServiceUploaderLibrary sl=new ServiceUploaderLibrary();
//		try {
//			sl.initServiceUploader();
//			String res=sl.uploadService(ASObjectPool.createAARServiceData("src/test/resources/artifacts/AS/aar/MTOMService.aar"));
//			System.out.println(res);
//		} catch (AxisFault e) {
//			System.out.println("e "+e.getMessage());
//		} catch (Exception e) {
//			System.out.println("e "+e.getMessage());
//		}
//		
//		c.setServiceName("MTOMSample");
//		c.setServiceOperation("AttachmentRequest");
//		c.setServiceParas("fileName","MTOM Image.jpeg");
//		
////		FileDataSource fileDataSource = new FileDataSource(new File("src/test/resources/artifacts/AS/images/wso2.jpeg"));
////        DataHandler dataHandler = new DataHandler(fileDataSource); 
////        OMFactory factory = OMAbstractFactory.getOMFactory();
////        OMText textData = factory.createOMText(dataHandler, true); 
//        
//		c.setServiceParas("binaryData","");
//		OMElement res=c.InvokeOperation();
//		System.out.println(s.containString(res, "File MTOM Image.jpeg has been successfully saved"));
////		System.out.println(textData.getText());
//	}
//
//	public static void main6(String[] args) {
//		AuthenticationLibrary al = new AuthenticationLibrary();
//		sessionCookie = al.LoginAs("admin", "admin", "localhost");
//		
//		AxisServiceClient c=new AxisServiceClient();
//		
////		Standard s=new Standard();
//		
//		ServiceUploaderLibrary sl=new ServiceUploaderLibrary();
//		try {
//			sl.initServiceUploader();
//			String res=sl.uploadService(ASObjectPool.createAARServiceData("src/test/resources/artifacts/AS/aar/CommodityQuoteService.aar"));
//			System.out.println(res);
//		} catch (AxisFault e) {
//			System.out.println("e "+e.getMessage());
//		} catch (Exception e) {
//			System.out.println("e "+e.getMessage());
//		}
//		
//		c.setServiceName("CommodityQuote");
//		c.setServiceOperation("getQuote");
//		c.setServiceParas("symbol","mn");
//		OMElement res=c.createPayloadWithText("");
//        
////		OMElement res=c.InvokeOperation();
//		System.out.println(c.getResponseAttributeValue("name"));
////		System.out.println(c.getResponseAttributeValue("symbol"));
//		System.out.println(res);
////		System.out.println(textData.getText());
//	}
//
//	public static void main(String[] args) {
//		AuthenticationLibrary a=new AuthenticationLibrary();
//		System.out.println(a.LoginAs("admin","admin", "pass"));
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
