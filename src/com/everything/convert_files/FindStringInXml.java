package com.everything.convert_files;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by mcalancea
 * Date: 17 Dec 2018
 * Time: 13:05
 */
public class FindStringInXml {
    public static void main(String[] args) throws Exception{
        String xml1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Header>\n" +
                "    <ResponseHeader xmlns:ns2=\"https://adwords.google.com/api/adwords/cm/v201809\" xmlns=\"https://adwords.google.com/api/adwords/mcm/v201809\">\n" +
                "      <ns2:requestId>00057d3b49b2fe380a813608010c97c6</ns2:requestId>\n" +
                "      <ns2:serviceName>ManagedCustomerService</ns2:serviceName>\n" +
                "      <ns2:methodName>mutate</ns2:methodName>\n" +
                "      <ns2:operations>1</ns2:operations>\n" +
                "      <ns2:responseTime>128</ns2:responseTime>\n" +
                "    </ResponseHeader>\n" +
                "  </soap:Header>\n" +
                "  <soap:Body>\n" +
                "    <soap:Fault>\n" +
                "      <faultcode>soap:Server</faultcode>\n" +
                "      <faultstring>[ManagedCustomerServiceError.TEST_ACCOUNT_LINK_ERROR @ operations[0]; trigger:'TEST_ACCOUNT_LINK_ERROR']</faultstring>\n" +
                "      <detail>\n" +
                "        <ApiExceptionFault xmlns=\"https://adwords.google.com/api/adwords/mcm/v201809\" xmlns:ns2=\"https://adwords.google.com/api/adwords/cm/v201809\">\n" +
                "          <ns2:message>[ManagedCustomerServiceError.TEST_ACCOUNT_LINK_ERROR @ operations[0]; trigger:'TEST_ACCOUNT_LINK_ERROR']</ns2:message>\n" +
                "          <ns2:ApplicationException.Type>ApiException</ns2:ApplicationException.Type>\n" +
                "          <ns2:errors xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ManagedCustomerServiceError\">\n" +
                "            <ns2:fieldPath>operations[0]</ns2:fieldPath>\n" +
                "            <ns2:fieldPathElements>\n" +
                "              <ns2:field>operations</ns2:field>\n" +
                "              <ns2:index>0</ns2:index>\n" +
                "            </ns2:fieldPathElements>\n" +
                "            <ns2:trigger>TEST_ACCOUNT_LINK_ERROR</ns2:trigger>\n" +
                "            <ns2:errorString>ManagedCustomerServiceError.TEST_ACCOUNT_LINK_ERROR</ns2:errorString>\n" +
                "            <ns2:ApiError.Type>ManagedCustomerServiceError</ns2:ApiError.Type>\n" +
                "            <reason>TEST_ACCOUNT_LINK_ERROR</reason>\n" +
                "          </ns2:errors>\n" +
                "        </ApiExceptionFault>\n" +
                "      </detail>\n" +
                "    </soap:Fault>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>\n";
        String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Header><ResponseHeader xmlns:ns2=\"https://adwords.google.com/api/adwords/cm/v201809\" xmlns=\"https://adwords.google.com/api/adwords/mcm/v201809\"><ns2:requestId>00057d3b49b2fe380a813608010c97c6</ns2:requestId><ns2:serviceName>ManagedCustomerService</ns2:serviceName><ns2:methodName>mutate</ns2:methodName><ns2:operations>1</ns2:operations><ns2:responseTime>128</ns2:responseTime></ResponseHeader></soap:Header><soap:Body><soap:Fault><faultcode>soap:Server</faultcode><faultstring>[ManagedCustomerServiceError.TEST_ACCOUNT_LINK_ERROR @ operations[0]; trigger:'TEST_ACCOUNT_LINK_ERROR']</faultstring><detail><ApiExceptionFault xmlns=\"https://adwords.google.com/api/adwords/mcm/v201809\" xmlns:ns2=\"https://adwords.google.com/api/adwords/cm/v201809\"><ns2:message>[ManagedCustomerServiceError.TEST_ACCOUNT_LINK_ERROR @ operations[0]; trigger:'TEST_ACCOUNT_LINK_ERROR']</ns2:message><ns2:ApplicationException.Type>ApiException</ns2:ApplicationException.Type><ns2:errors xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ManagedCustomerServiceError\"><ns2:fieldPath>operations[0]</ns2:fieldPath><ns2:fieldPathElements><ns2:field>operations</ns2:field><ns2:index>0</ns2:index></ns2:fieldPathElements><ns2:trigger>TEST_ACCOUNT_LINK_ERROR</ns2:trigger><ns2:errorString>ManagedCustomerServiceError.TEST_ACCOUNT_LINK_ERROR</ns2:errorString><ns2:ApiError.Type>ManagedCustomerServiceError</ns2:ApiError.Type><reason>TEST_ACCOUNT_LINK_ERROR</reason></ns2:errors></ApiExceptionFault></detail></soap:Fault></soap:Body></soap:Envelope>";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
                "<soapenv:Body>"+
                "<theRequest>"+
                "<username>user</username>"+
                "<password>password</password>"+
                "<someMsg>sooomeMessage</someMsg>"+
                "</theRequest>"+
                "</soapenv:Body>"+
                "</soapenv:Envelope>";

//        XStream xStream = new XStream();
//        Fault1_2Impl o = (Fault1_2Impl) xStream.fromXML(xml);
//        System.out.println(o);
        MessageFactory messageFactory = MessageFactory.newInstance();

        MimeHeaders header = new MimeHeaders();
        header.addHeader("Content-Type", "text/xml");

        SOAPMessage soapMessage = messageFactory.createMessage(null, new ByteArrayInputStream(xml1.getBytes(StandardCharsets.UTF_8)));
        SOAPBody soapBody = soapMessage.getSOAPBody();
        NodeList nodes = soapBody.getElementsByTagName("ns2:trigger");
//        NodeList nodes = soapBody.getElementsByTagName("trigger");
//        NodeList nodes = soapBody.getElementsByTagName("someMsg");
        for (int i = 0; i < nodes.getLength(); i++) {
            String content = null;
            Node node = nodes.item(i);
            content = node != null ? node.getTextContent() : "";

            System.out.println(content);
        }
//        // get the body
//        SOAPBody soapBody = soapMessage.getSOAPBody();
//        // find your node based on tag name
////        NodeList nodes = soapBody.getElementsByTagName("someMsg");
////        NodeList nodes = soapBody.getElementsByTagName("ns2:trigger");
////        NodeList nodes = soapBody.getElementsByTagName("reason");
//        NodeList nodes = soapBody.getElementsByTagName("ns2:errorString");
//        System.out.println(nodes.getClass().getName());
//        // check if the node exists and get the value
//        String someMsgContent = null;
//        Node node = nodes.item(0);
//        someMsgContent = node != null ? node.getTextContent() : "";
//
//        System.out.println(someMsgContent);
    }
}
