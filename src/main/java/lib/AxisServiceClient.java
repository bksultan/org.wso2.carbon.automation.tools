package lib;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.Header;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;

import property.AutomationContext;

import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;

public class AxisServiceClient {
	private static final Log log = LogFactory.getLog(AxisServiceClient.class);

	public OMElement sendReceive(OMElement payload, String endPointReference,
			String operation) throws AxisFault {
		ServiceClient sender;
		Options options;
		OMElement response = null;
		if (log.isDebugEnabled()) {
			log.debug("Service Endpoint : " + endPointReference);
			log.debug("Service Operation : " + operation);
			log.debug("Payload : " + payload);
		}
		try {
			sender = new ServiceClient();

			options = new Options();
			if (httpHeaders != null && !httpHeaders.isEmpty()) {
				// sender.addStringHeader(new QName(ns, localName), value); //
				// Set headers
				options.setProperty(HTTPConstants.HTTP_HEADERS, httpHeaders);
			}
			options.setTo(new EndpointReference(endPointReference));
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
					Boolean.FALSE);
			options.setTimeOutInMilliSeconds(45000);
			options.setAction("urn:" + operation);
			sender.setOptions(options);
			response = sender.sendReceive(payload);
			if (log.isDebugEnabled()) {
				log.debug("Response Message : " + response);
			}
		} catch (AxisFault axisFault) {
			log.error(axisFault.getMessage());
			throw new AxisFault("AxisFault while getting response :"
					+ axisFault.getMessage(), axisFault);
		}
		Assert.assertNotNull(response);
		return response;
	}

	// axis2 client with header setting
	public OMElement sendReceive(OMElement payload, String endPointReference,
			String operation, String localName, String ns, String value)
			throws AxisFault {
		ServiceClient sender;
		Options options;
		OMElement response = null;
		if (log.isDebugEnabled()) {
			log.debug("Service Endpoint : " + endPointReference);
			log.debug("Service Operation : " + operation);
			log.debug("Payload : " + payload);
		}
		try {
			sender = new ServiceClient();
			sender.addStringHeader(new QName(ns, localName), value); // Set
																		// headers
			options = new Options();
			options.setTo(new EndpointReference(endPointReference));
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
					Boolean.FALSE);
			options.setAction("urn:" + operation);
			sender.setOptions(options);
			response = sender.sendReceive(payload);
			if (log.isDebugEnabled()) {
				log.debug("Response Message : " + response);
			}
		} catch (AxisFault axisFault) {
			log.error(axisFault.getMessage());
			throw new AxisFault("AxisFault while getting response :"
					+ axisFault.getMessage(), axisFault);
		}
		Assert.assertNotNull(response);
		return response;
	}

	public OMElement sendReceive(OMElement payload, String endPointReference,
			String operation, String contentType) throws AxisFault {
		ServiceClient sender;
		Options options;
		OMElement response = null;
		if (log.isDebugEnabled()) {
			log.debug("Service Endpoint : " + endPointReference);
			log.debug("Service Operation : " + operation);
			log.debug("Payload : " + payload);
		}
		try {
			sender = new ServiceClient();
			options = new Options();
			options.setTo(new EndpointReference(endPointReference));
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
					Boolean.FALSE);
			options.setTimeOutInMilliSeconds(45000);
			options.setAction("urn:" + operation);
			options.setProperty(Constants.Configuration.MESSAGE_TYPE,
					contentType);
			sender.setOptions(options);
			response = sender.sendReceive(payload);
			if (log.isDebugEnabled()) {
				log.debug("Response Message : " + response);
			}
		} catch (AxisFault axisFault) {
			log.error(axisFault.getMessage());
			throw new AxisFault("AxisFault while getting response :"
					+ axisFault.getMessage(), axisFault);
		}
		Assert.assertNotNull(response);
		return response;
	}

	// one way communication
	public void sendRobust(OMElement payload, String endPointReference,
			String operation) throws AxisFault {
		ServiceClient sender;
		Options options;
		if (log.isDebugEnabled()) {
			log.info("Service Endpoint : " + endPointReference);
			log.info("Service Operation : " + operation);
			log.debug("Payload : " + payload);
		}
		try {
			sender = new ServiceClient();
			options = new Options();
			options.setTo(new EndpointReference(endPointReference));
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
					Boolean.FALSE);
			options.setAction("urn:" + operation);
			sender.setOptions(options);
			sender.sendRobust(payload);
		} catch (AxisFault axisFault) {
			log.error(axisFault.getMessage());
			throw new AxisFault("AxisFault while getting response :"
					+ axisFault.getMessage(), axisFault);
		}
	}

	// one way communication
	public void fireAndForget(OMElement payload, String endPointReference,
			String operation) throws AxisFault {
		ServiceClient sender;
		Options options;
		if (log.isDebugEnabled()) {
			log.info("Service Endpoint : " + endPointReference);
			log.info("Service Operation : " + operation);
			log.debug("Payload : " + payload);
		}
		try {
			sender = new ServiceClient();
			options = new Options();
			options.setTo(new EndpointReference(endPointReference));
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
					Boolean.FALSE);
			options.setAction("urn:" + operation);
			sender.setOptions(options);
			sender.fireAndForget(payload);
		} catch (AxisFault axisFault) {
			log.error(axisFault.getMessage());
			throw new AxisFault("AxisFault while getting response :"
					+ axisFault.getMessage(), axisFault);
		}
	}

	// create OMElement for method
	public OMElement getMethod(String method, String namespace, Object... paras) {
		int l = paras.length;
		if (l % 2 != 0) {
			return null;
		}

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(namespace, "tns");
		OMElement meth = fac.createOMElement(method, omNs);

		for (int i = 0; i < l; i += 2) {
			if (paras[i + 1].getClass().getCanonicalName()
					.equals("java.lang.Object[]")) {
				Object[] s = (Object[]) paras[i + 1];
				for (int j = 0; j < s.length; j++) {
					OMElement value = fac.createOMElement((String) paras[i],
							omNs);
					value.addChild(fac.createOMText(value, (String) s[j]));
					meth.addChild(value);
				}
			} else {
				OMElement value = fac.createOMElement((String) paras[i], omNs);
				value.addChild(fac.createOMText(value, (String) paras[i + 1]));
				meth.addChild(value);
			}
		}

		return meth;
	}

	public String getValue(OMElement om) {
		return om.getFirstElement().getText();
	}

	public Object invokeOperationIn(String endPOint, String operationName,
			Object... paras) throws Exception {
		// endPOint=PropertyInfo.read("axis2")+"/"+endPOint;

		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
		endPOint = a + "/" + endPOint;

		String namespace = getTargetNamespace(endPOint + "?wsdl");
		OMElement method = getMethod(operationName, namespace, paras);

		System.out.println(method);
		OMElement res = null;
		try {
			res = sendReceive(method, endPOint, operationName);
			Object[] val = createArrayFromOMElement(res);
			invokeOperation = val;
			getOperationResponse = res;
			return val;
		} catch (AxisFault e) {
			System.out.println("error: " + e.getFaultAction());
			return null;
		}

	}

	private Object[] invokeOperation = null;
	private OMElement getOperationResponse = null;

	public void AssertInvokeOperation(Object... expected) {
		System.out.println(invokeOperation.length);
		System.out.println(expected.length);

		Assert.assertEquals(invokeOperation.length, expected.length);

		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(invokeOperation[i], expected[i]);
		}
		// Assert.assertEquals(invokeOperation, expected);
	}

	public void test1(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public Object[] createArrayFromOMElement(OMElement result) {
		ArrayList<Object> q = new ArrayList<Object>();
		Iterator<?> ite = result.getChildren();
		for (Iterator<?> iterator = ite; iterator.hasNext();) {
			OMElement type = (OMElement) iterator.next();
			System.out.println(type.getText());
			q.add(type.getText());
		}
		return q.toArray();
	}

	public Object[] getResponseValue(OMElement result) {
		return createArrayFromOMElement(result);
	}

	public String getTargetNamespace(String wsdlUrl) throws Exception{
		int times=0;
		while (true) {
			times++;
			try {
				WSDLParser parser = new WSDLParser();
				Definitions defs = parser.parse(wsdlUrl);
				return defs.getTargetNamespace();
			} catch (Exception e) {
				if(times+"" == AutomationContext.context(AutomationContext.ATTEMPTS)){
					throw new Exception("WSDL download exception");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}

	}

	public String getAttibuteValueOfOperationIn(String endPOint,
			String operationName, String type, Object... paras) throws Exception {

		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
		endPOint = a + "/" + endPOint;

		String namespace = getTargetNamespace(endPOint + "?wsdl");
		OMElement method = getMethod(operationName, namespace, paras);
		OMElement res = null;
		try {
			res = sendReceive(method, endPOint, operationName);
		} catch (AxisFault e) {
			System.out.println(e.getFaultAction());
			return null;
		}

		String re = res
				.getFirstElement()
				.getFirstChildWithName(
						new QName("http://services.samples/xsd", type))
				.getText();
		return re;
	}

	public OMElement getOperationResponse() {
		return getOperationResponse;
	}

	public void AssertGetAttibuteValueOfOperationIn(String expected) {
		Assert.assertEquals(getOperationResponse, expected);
	}

	private String setServiceName, setServiceOperation;
	private ArrayList<Object[]> setServiceParas = new ArrayList<Object[]>();
	private String setServiceParentChild, namespace;
	private List<Header> httpHeaders = new ArrayList<Header>();

	public void setServiceName(String name) {
		setServiceName = name;
	}

	public void setServiceOperation(String name) {
		setServiceOperation = name;
	}

	public void setServiceParas(String name, Object val) {
		setServiceParas.add(new Object[] { name, val });
	}

	public void setServiceParentChild(String name) {
		setServiceParentChild = name;
	}

	public void setServiceHttpHeader(String name, String value) {
		httpHeaders.add(new Header(name, value));
	}

	public void clearServiceHttpHeader() {
		if (httpHeaders != null) {
			httpHeaders.clear();
		}

	}

	public void clearServiceParas() {
		if (setServiceParas != null) {
			setServiceParas.clear();
		}
	}

	public OMElement InvokeOperation() throws Exception {
		String endPoint = setServiceName;
		String operationName = setServiceOperation;
		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
		endPoint = a + "/" + endPoint;
		// System.out.println(endPoint);
		namespace = getTargetNamespace(endPoint + "?wsdl");

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(namespace, "tns");
		OMElement meth = fac.createOMElement(operationName, omNs);

		OMElement parent = null;
		// for (String par : setServiceParentChild) {
		if (setServiceParentChild != null)
			parent = fac.createOMElement(setServiceParentChild, omNs);
		// }

		for (Object[] para : setServiceParas) {

			if (para[1].getClass().getCanonicalName()
					.equals("java.lang.Object[]")) {

				Object[] s = (Object[]) para[1];
				for (int j = 0; j < s.length; j++) {
					OMElement value = fac.createOMElement((String) para[0],
							omNs);
					value.addChild(fac.createOMText(value, (String) s[j]));

					if (parent == null) {
						meth.addChild(value);
					} else {
						parent.addChild(value);
					}

				}

			} else {
				OMElement value = fac.createOMElement((String) para[0], omNs);
				value.addChild(fac.createOMText(value, (String) para[1]));

				if (parent == null) {
					meth.addChild(value);
				} else {
					parent.addChild(value);
				}
			}

		}

		if (parent != null) {
			meth.addChild(parent);
		}

		OMElement method = meth;

		// System.out.println(method);
		OMElement res = null;
		try {
			res = sendReceive(method, endPoint, operationName);
			// setServiceParas.clear();
			clearServiceHttpHeader();
			clearServiceParas();
			getOperationResponse = res;
			try {
				invokeOperation = createArrayFromOMElement(res);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return res;
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public String getResponseAttributeValue(String attribut) {

		String ns = namespace + "/xsd";
		String re = getOperationResponse.getFirstElement()
				.getFirstChildWithName(new QName(ns, attribut)).getText();
		return re;
		// return null;
	}

	public OMElement InvokeOperationSec(String localName, String ns,
			String value1) throws Exception {
		String endPoint = setServiceName;
		String operationName = setServiceOperation;
		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
		endPoint = a + "/" + endPoint;
		// System.out.println(endPoint);
		namespace = getTargetNamespace(endPoint + "?wsdl");

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(namespace, "tns");
		OMElement meth = fac.createOMElement(operationName, omNs);

		OMElement parent = null;
		// for (String par : setServiceParentChild) {
		if (setServiceParentChild != null)
			parent = fac.createOMElement(setServiceParentChild, omNs);
		// }

		for (Object[] para : setServiceParas) {

			if (para[1].getClass().getCanonicalName()
					.equals("java.lang.Object[]")) {

				Object[] s = (Object[]) para[1];
				for (int j = 0; j < s.length; j++) {
					OMElement value = fac.createOMElement((String) para[0],
							omNs);
					value.addChild(fac.createOMText(value, (String) s[j]));

					if (parent == null) {
						meth.addChild(value);
					} else {
						parent.addChild(value);
					}

				}

			} else {
				OMElement value = fac.createOMElement((String) para[0], omNs);
				value.addChild(fac.createOMText(value, (String) para[1]));

				if (parent == null) {
					meth.addChild(value);
				} else {
					parent.addChild(value);
				}
			}

		}

		if (parent != null) {
			meth.addChild(parent);
		}

		OMElement method = meth;

		// System.out.println(method);
		OMElement res = null;
		try {
			res = sendReceive(method, endPoint, operationName, localName, ns,
					value1);
			setServiceParas.clear();
			getOperationResponse = res;
			invokeOperation = createArrayFromOMElement(res);
			return res;
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			return null;
		}

	}

	public void waitDeployService(String service) throws Exception {
		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
		service = a + "/" + service + "?wsdl";
		int times = 0;
		while (true) {
			times++;
			try {
				new URL(service);
				System.out.println("deploied " + times);
				return;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (times+"" == AutomationContext.context(AutomationContext.ATTEMPTS)) {
					throw new Exception("Service not Available");
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public OMElement createPayloadWithText(String s) throws Exception {
		OMElement res = null;

		// String request =
		// "<ns1:getQuoteRequest xmlns:ns1=\"http://www.wso2.org/types\">" +
		// "<symbol>mn</symbol></ns1:getQuoteRequest>";

		String request = s;
		try {
			res = new StAXOMBuilder(
					new ByteArrayInputStream(request.getBytes()))
					.getDocumentElement();
		} catch (XMLStreamException e) {
			System.out.println(e.getMessage());
			return null;
		}

		String endPoint = setServiceName;
		String operationName = setServiceOperation;
		String a = AutomationContext.context(AutomationContext.PRODUCT_AXIS2);
		endPoint = a + "/" + endPoint;
		namespace = getTargetNamespace(endPoint + "?wsdl");

		try {
			res = sendReceive(res, endPoint, operationName);
			clearServiceHttpHeader();
			clearServiceParas();
			getOperationResponse = res;
			try {
				invokeOperation = createArrayFromOMElement(res);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return res;
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
