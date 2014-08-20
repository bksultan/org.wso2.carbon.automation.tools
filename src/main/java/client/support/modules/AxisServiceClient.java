package client.support.modules;

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

import client.configuration.AutomationConfigurationReader;

import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;

/**
 * Common Client to access and invoke the Axis2 services
 * @author rukshan
 *
 */
public class AxisServiceClient {
	private static final Log log = LogFactory.getLog(AxisServiceClient.class);

	/**
	 * send the request and get the response
	 * 
	 * @param payload, request payload as omelemet
	 * @param endPointReference, service url		
	 * @param operation, operation name
	 * @return	response as omelemet
	 * @throws AxisFault
	 */
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
			sender = new ServiceClient();		// create service client

			options = new Options();
			if (httpHeaders != null && !httpHeaders.isEmpty()) {					// if header declaration is not empty 
				// sender.addStringHeader(new QName(ns, localName), value); //
				// Set headers
				options.setProperty(HTTPConstants.HTTP_HEADERS, httpHeaders);		// set the header to option
			}
			options.setTo(new EndpointReference(endPointReference));				// set the endpoint url
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
					Boolean.FALSE);
			options.setTimeOutInMilliSeconds(45000);								// set the timeout
			options.setAction("urn:" + operation);
			sender.setOptions(options);												// set the option to sender
			response = sender.sendReceive(payload);									// send the payload
			if (log.isDebugEnabled()) {
				log.debug("Response Message : " + response);
			}
		} catch (AxisFault axisFault) {
			log.error(axisFault.getMessage());
			throw new AxisFault("AxisFault while getting response :"
					+ axisFault.getMessage(), axisFault);
		}
		Assert.assertNotNull(response);	
		return response;															// return the response
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

	/**
	 * create OMElement for method
	 * 
	 * @param method	operation name
	 * @param namespace	namespace of operation
	 * @param paras		parameter name and values 
	 * 
	 * {"paraname1","val1","paraname2","val2"}
	 * 
	 * @return	omelement
	 */
	public OMElement getMethod(String method, String namespace, Object... paras) {
		int l = paras.length;
		if (l % 2 != 0) {
			return null;	// if paras is odd, wrong parameters
		}

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(namespace, "tns");		// create namespace
		OMElement meth = fac.createOMElement(method, omNs);				// create element for operation

		// odd items are parameter variable name and even are parameter value 
		for (int i = 0; i < l; i += 2) {								// iterate over parameters
			if (paras[i + 1].getClass().getCanonicalName()				// parameter value is array
					.equals("java.lang.Object[]")) {
				Object[] s = (Object[]) paras[i + 1];
				for (int j = 0; j < s.length; j++) {					// iterate over array
					OMElement value = fac.createOMElement((String) paras[i],
							omNs);
					value.addChild(fac.createOMText(value, (String) s[j]));		// create each element for array
					meth.addChild(value);
				}
			} else {
				OMElement value = fac.createOMElement((String) paras[i], omNs);
				value.addChild(fac.createOMText(value, (String) paras[i + 1]));	// if value is not a array
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

		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);
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

	/**
	 * Assert the last request with expected result as array
	 * @param expected	expected array of values
	 */
	public void AssertInvokeOperation(Object... expected) {
		System.out.println(invokeOperation.length);
		System.out.println(expected.length);

		Assert.assertEquals(invokeOperation.length, expected.length);	// assert the length first

		// then assert the element of each considering order
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(invokeOperation[i], expected[i]);
		}
		// Assert.assertEquals(invokeOperation, expected);
	}

	/**
	 * get response as array of element
	 * @param result
	 * @return
	 */
	public Object[] createArrayFromOMElement(OMElement result) {
		ArrayList<Object> q = new ArrayList<Object>();
		Iterator<?> ite = result.getChildren();
		
		//iterate over child element
		for (Iterator<?> iterator = ite; iterator.hasNext();) {
			OMElement type = (OMElement) iterator.next();
			System.out.println(type.getText());
			q.add(type.getText());		// add child element to list
		}
		return q.toArray();		//return as array
	}

	/**
	 * get response as array of element
	 * @param result	response
	 * @return	array of response child element
	 */
	public Object[] getResponseValue(OMElement result) {
		return createArrayFromOMElement(result);
	}

	/**
	 * get the target namespace of service using wsdl
	 * @param wsdlUrl	wsdl url
	 * @return	namespace
	 * @throws Exception
	 */
	public String getTargetNamespace(String wsdlUrl) throws Exception{
		int num=Integer.parseInt(AutomationConfigurationReader.context(AutomationConfigurationReader.ATTEMPTS).trim());	// no of attempts
		int times=0;
		while (true) {
			times++;
			try {
				WSDLParser parser = new WSDLParser();
				Definitions defs = parser.parse(wsdlUrl);	// if wsdl available return the namespace 
				return defs.getTargetNamespace();			
			} catch (Exception e) {
				
				// if wsdl not available re-attempt
				System.out.println("INFO: WSDL download exception retrying......");				
				
				if(times>num){
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

		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);
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

	/**
	 * get the response of last request
	 * @return OMElement
	 */
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

	/**
	 * set the service name
	 * @param name	service name
	 */
	public void setServiceName(String name) {
		setServiceName = name;
	}

	/**
	 * set the operation should be use
	 * @param name operation name
	 */
	public void setServiceOperation(String name) {
		setServiceOperation = name;
	}

	/**
	 * set the parameters of  operation
	 * @param name	parameter variable name
	 * @param val	parameter value
	 */
	public void setServiceParas(String name, Object val) {
		setServiceParas.add(new Object[] { name, val });	// add name and value as array 
	}

	/**
	 * if request should have parent element set the element name
	 * @param name	element name
	 */
	public void setServiceParentChild(String name) {
		setServiceParentChild = name;
	}

	/**
	 * if request need http headers,
	 * @param name	header name
	 * @param value	header value
	 */
	public void setServiceHttpHeader(String name, String value) {
		httpHeaders.add(new Header(name, value));	// add as header
	}

	/**
	 * clear the http header details used in previous request
	 */
	public void clearServiceHttpHeader() {
		if (httpHeaders != null) {
			httpHeaders.clear();	// clear the list
		}

	}

	/**
	 * clear the opearion's parameter details used in previous request
	 */
	public void clearServiceParas() {
		if (setServiceParas != null) {
			setServiceParas.clear();
		}
	}

	/**
	 * invoke the web service
	 * @return	response as OMElement
	 * @throws Exception
	 */
	public OMElement InvokeOperation() throws Exception {
		String endPoint = setServiceName;										// get the service name
		String operationName = setServiceOperation;								// get the operation name
		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);
		endPoint = a + "/" + endPoint;											// set the service url
		// System.out.println(endPoint);
		namespace = getTargetNamespace(endPoint + "?wsdl");						// get the namespace from wsdl

		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(namespace, "tns");				// create element with namespace
		OMElement meth = fac.createOMElement(operationName, omNs);				// create element for opeartion

		OMElement parent = null;
		// for (String par : setServiceParentChild) {
		if (setServiceParentChild != null)										
			parent = fac.createOMElement(setServiceParentChild, omNs);			// if parent element is required, create element
		// }

		//iterate over list of parameter values 
		for (Object[] para : setServiceParas) {

			if (para[1].getClass().getCanonicalName()
					.equals("java.lang.Object[]")) {		// if parameter is object array
				
				Object[] s = (Object[]) para[1];
				for (int j = 0; j < s.length; j++) {
					OMElement value = fac.createOMElement((String) para[0],
							omNs);
					value.addChild(fac.createOMText(value, (String) s[j]));		// create one element for each objects in array

					if (parent == null) {
						meth.addChild(value);		// if parent element is present add as child element
					} else {
						parent.addChild(value);
					}

				}

			} else {		// if parameter is not array
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
			res = sendReceive(method, endPoint, operationName);			// request the operation
			// setServiceParas.clear();
			clearServiceHttpHeader();									// clear the header each time after invoke
			clearServiceParas();										// clear the parameters each time after invoke
			getOperationResponse = res;									// set the operation response
			try {
				invokeOperation = createArrayFromOMElement(res);		// set the response as array of element
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
		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);
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

	/**
	 * wait until service is deploy
	 * @param service service name
	 * @throws Exception
	 */
	public void waitDeployService(String service) throws Exception {
		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);	//get the axis service url
		service = a + "/" + service + "?wsdl";									// set the wsdl url
		int times = 0;
		while (true) {				// wait 
			times++;
			try {
				new URL(service);							// check service wsdl it available
				System.out.println("deploied " + times);
				return;										// if available return 
			} catch (Exception e) {
				// if not available
				System.out.println(e.getMessage());
				// check the no of attempts is exceeded
				if (times+"" == AutomationConfigurationReader.context(AutomationConfigurationReader.ATTEMPTS)) {
					throw new Exception("Service not Available");
				}
			}
			//sleep 1 sec
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
		String a = AutomationConfigurationReader.context(AutomationConfigurationReader.PRODUCT_AXIS2);
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
