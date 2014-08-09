package lib;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.Header;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import property.AutomationContext;

public class AxisServiceClientTest {

	@Test
	public void clearServiceHttpHeader() {
		try {
			AxisServiceClient a = new AxisServiceClient();
			Class<?> c = AxisServiceClient.class;
			ArrayList<Header> list = new ArrayList<Header>();
			list.add(new Header("head", "val"));

			Field httpHeaders = c.getDeclaredField("httpHeaders");
			httpHeaders.setAccessible(true);
			httpHeaders.set(a, list);
			a.clearServiceHttpHeader();

			httpHeaders = c.getDeclaredField("httpHeaders");
			httpHeaders.setAccessible(true);
			ArrayList<String> res = (ArrayList<String>) httpHeaders.get(a);
			Assert.assertEquals(res.size(), 0);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Assert.fail();
		}

	}

	@Test
	public void clearServiceParas() {
		try {
			AxisServiceClient a = new AxisServiceClient();
			Class<?> c = AxisServiceClient.class;

			ArrayList<Object[]> serviceParas = new ArrayList<Object[]>();
			serviceParas.add(new String[] { "symbol", "WSO2" });

			Field setServiceParas = c.getDeclaredField("setServiceParas");
			setServiceParas.setAccessible(true);
			setServiceParas.set(a, serviceParas);
			a.clearServiceParas();

			setServiceParas = c.getDeclaredField("setServiceParas");
			setServiceParas.setAccessible(true);
			ArrayList<Object[]> res = (ArrayList<Object[]>) setServiceParas
					.get(a);
			Assert.assertEquals(res.size(), 0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void createArrayFromOMElement() {
		String res = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<soapenv:Body>"
				+ "<ns:getQuoteResponse xmlns:ns=\"http://services.samples\">"
				+ "<ns:return xsi:type=\"ax21:GetQuoteResponse\" xmlns:ax21=\"http://services.samples/xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
				+ "<ax21:change>-2.69012272255981</ax21:change>"
				+ "<ax21:earnings>-8.76644270760483</ax21:earnings>"
				+ "<ax21:high>-154.90478964816816</ax21:high>"
				+ "<ax21:last>158.51252528991859</ax21:last>"
				+ "<ax21:lastTradeTimestamp>Sat Aug 09 11:34:25 IST 2014</ax21:lastTradeTimestamp>"
				+ "<ax21:low>-154.56437137766505</ax21:low>"
				+ "<ax21:marketCap>5482852.192094343</ax21:marketCap>"
				+ "<ax21:name>WSO2 Company</ax21:name>"
				+ "<ax21:open>164.50745834714596</ax21:open>"
				+ "<ax21:peRatio>25.006290947841407</ax21:peRatio>"
				+ "<ax21:percentageChange>-1.4877229172298796</ax21:percentageChange>"
				+ "<ax21:prevClose>180.82148842398576</ax21:prevClose>"
				+ "<ax21:symbol>WSO2</ax21:symbol>"
				+ "<ax21:volume>5666</ax21:volume>"
				+ "</ns:return>"
				+ "</ns:getQuoteResponse>"
				+ "</soapenv:Body>"
				+ "</soapenv:Envelope>";
		OMElement om;
		try {
			om = AXIOMUtil.stringToOM(res);
			AxisServiceClient s = new AxisServiceClient();
			Object[] obs = s.createArrayFromOMElement(om);
			System.out.println(obs.length);
			Assert.assertEquals(obs.length, 1);
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void createPayloadWithText() {

	}

	@Test
	public void getMethod() {
		AxisServiceClient a = new AxisServiceClient();
		OMElement o = a.getMethod("getQuote", "http://services.samples",
				"symbol", "WSO2");
		Assert.assertEquals(
				o.toString(),
				"<tns:getQuote xmlns:tns=\"http://services.samples\"><tns:symbol>WSO2</tns:symbol></tns:getQuote>");

		o = a.getMethod("getQuote", "http://services.samples", "symbol");
		Assert.assertNull(o);

		o = a.getMethod("getQuote", "http://services.samples", "symbol",
				new Object[] { "val1", "val2" });
		Assert.assertEquals(
				o.toString(),
				"<tns:getQuote xmlns:tns=\"http://services.samples\"><tns:symbol>val1</tns:symbol><tns:symbol>val2</tns:symbol></tns:getQuote>");

	}

	@Test
	public void getResponseAttributeValue() {
		try {
			AxisServiceClient a = new AxisServiceClient();
			Class<?> c = AxisServiceClient.class;
			String req = "<ns:getQuoteResponse xmlns:ns=\"http://services.samples\"><ns:return "
					+ "xmlns:ax21=\"http://services.samples/xsd\" "
					+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
					+ "xsi:type=\"ax21:GetQuoteResponse\">"
					+ "<ax21:change>-2.659866030178528</ax21:change>"
					+ "<ax21:earnings>-9.417219935402901</ax21:earnings>"
					+ "<ax21:high>-79.2801549327142</ax21:high>"
					+ "<ax21:last>79.89988710782919</ax21:last>"
					+ "<ax21:lastTradeTimestamp>Sat Aug 09 15:55:13 IST 2014</ax21:lastTradeTimestamp>"
					+ "<ax21:low>81.91334051493399</ax21:low>"
					+ "<ax21:marketCap>1.3063479573905904E7</ax21:marketCap>"
					+ "<ax21:name>WSO2 Company</ax21:name>"
					+ "<ax21:open>-78.63623151797715</ax21:open>"
					+ "<ax21:peRatio>25.817601430504652</ax21:peRatio>"
					+ "<ax21:percentageChange>-2.9565386057726912</ax21:percentageChange>"
					+ "<ax21:prevClose>89.96554365923365</ax21:prevClose>"
					+ "<ax21:symbol>WSO2</ax21:symbol>"
					+ "<ax21:volume>7508</ax21:volume>"
					+ "</ns:return></ns:getQuoteResponse>";
			OMElement om;
			om = AXIOMUtil.stringToOM(req);

			Field namespace = c.getDeclaredField("namespace");
			namespace.setAccessible(true);
			namespace.set(a, "http://services.samples");

			Field getOperationResponse = c
					.getDeclaredField("getOperationResponse");
			getOperationResponse.setAccessible(true);
			getOperationResponse.set(a, om);

			String val = a.getResponseAttributeValue("symbol");
			Assert.assertEquals(val, "WSO2");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void getTargetNamespace() {
		AxisServiceClient c = new AxisServiceClient();

		try {
			Class<?> cls = AutomationContext.class;
			Field xmlDocument = cls.getDeclaredField("xmlDocument");
			xmlDocument.setAccessible(true);

			InputStream is = ClassLoader
					.getSystemResourceAsStream("automation.xml");

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(is);
			xmlDocument.set(null, xmlDoc);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

		try {
			URL url = ClassLoader.getSystemResource("echo.wsdl");
			System.out.println("echo url: " + url.getFile());
			String ns = c.getTargetNamespace(url.getFile());
			Assert.assertEquals(ns, "http://echo.services.core.carbon.wso2.org");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

		try {
			String ns = c.getTargetNamespace("src/test/resources/noecho.wsdl");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "WSDL download exception");
		}
	}

	@Test
	public void getValue() {
		String req = "<ns:echoIntResponse xmlns:ns=\"http://echo.services.core.carbon.wso2.org\"><return>100</return></ns:echoIntResponse>";
		AxisServiceClient c = new AxisServiceClient();
		try {
			OMElement om = AXIOMUtil.stringToOM(req);
			String ou = c.getValue(om);
			Assert.assertEquals(ou, "100");
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		}
	}

}
