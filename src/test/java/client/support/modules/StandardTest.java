package client.support.modules;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import client.support.modules.Standard;

public class StandardTest {

	@Test
	public void CreateArray() {
		Standard s = new Standard();
		Object[] ar;

		ar = s.CreateArray("1", "2", "3");
		Assert.assertEquals(ar.length, 3);

		ar = s.CreateArray(1, 2, 3, 4, 5);
		Assert.assertEquals(ar.length, 5);
		Assert.assertEquals(ar[4], 5);

		ar = s.CreateArray(new Object(), new Object(), new Object(),
				new Object());
		Assert.assertEquals(ar.length, 4);
	}

	@Test
	public void containString() {
		String req = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.samples\" xmlns:xsd=\"http://services.samples/xsd\">"
				+ "<soapenv:Header/>"
				+ "<soapenv:Body>"
				+ "<ser:getQuote>"
				+ "<ser:request>"
				+ "<xsd:symbol>WSO2</xsd:symbol>"
				+ "</ser:request>"
				+ "</ser:getQuote>"
				+ "</soapenv:Body>"
				+ "</soapenv:Envelope>";

		Standard s = new Standard();
		Assert.assertTrue(s.containString(req, "WSO2"));
		Assert.assertTrue(s.containString(req, "wso2"));
	}

	@Test
	public void createArrayFromOME() {
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
			Standard s = new Standard();
			Object[] obs = s.createArrayFromOME(om);
			System.out.println(obs.length);
			Assert.assertEquals(obs.length, 1);
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
		}

	}
}
