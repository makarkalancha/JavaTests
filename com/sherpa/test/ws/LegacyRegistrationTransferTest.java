package com.sherpa.test.ws;

import com.sherpa.test.enums.Environment;
import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.util.*;

public class LegacyRegistrationTransferTest extends AbstractWebServiceTestCase {

    public void testBea2013() throws Exception{
        test("bea2013", "BOOK13");
    }
    public void testVew2013() throws Exception{
        test("vew2013", "IVEW13");
    }
    public void testIssa2013() throws Exception{
        test("issa2013", "ISSA13");
    }
    public void testHpbe2014() throws Exception{
        test("hpbexpo2014", "HPBE14");
    }

    public void testRegistrationTransfer_syncTransferPush_WithCSIExtraFields()
            throws Exception
    {
        final Map<String, String> params = new HashMap<String, String>(){{
            //d = data, p = partner guid
            put("d", generateXmlTestData("d76aa2f675a33917982d8c78423e284a", "BOOK13", true));
            put("p", "d76aa2f675a33917982d8c78423e284a");
        }};

        final HttpResponse httpResponse = sendRequest("bea2013", params, Environment.STAGING);
        String xml = httpResponse.getContentAsText();
        assertEquals(200, httpResponse.getCode());

        System.out.println(xml);
        XStream xs = new XStream (new StaxDriver());
        xs.alias("response", Response.class);
        xs.alias("errors", Errors.class);
        xs.alias("error", Error.class);
        Response resp = (Response)xs.fromXML(xml);

        assertEquals("$.status", "Y", resp.status);
        assertEquals("$.registrationCount", 1, resp.registrationCount);
        assertTrue("$.batchNumber", resp.batchNumber > 0);
    }

    private String generateXmlTestData(String partnerGuid, String showCode, boolean withCSIExtraFields)
    {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                "<data>" +
                "  <registration>" +
                "    <partner>" + partnerGuid + "</partner>" +
                "    <eventid>" + showCode + "</eventid>" +
                "    <registrationid>" + UUID.randomUUID().toString() + "</registrationid>" +
                "    <registrationtype>PWR</registrationtype>" +
                "    <registrationtypedescription>Monitor everything.Test</registrationtypedescription>" +
                "    <historicalid></historicalid>" +
                "    <exhibitorid></exhibitorid>" +
                "    <prefix><![CDATA[]]></prefix>" +
                "    <firstname><![CDATA[TEST]]></firstname>" +
                "    <middlename><![CDATA[TEST]]></middlename>" +
                "    <lastname><![CDATA[TEST]]></lastname>" +
                "    <suffix><![CDATA[]]></suffix>" +
                "    <nickname><![CDATA[]]></nickname>" +
                "    <jobtitle><![CDATA[]]></jobtitle>" +
                "    <company><![CDATA[]]></company>" +
                "    <division><![CDATA[]]></division>" +
                "    <address1><![CDATA[25-90 35TH ST]]></address1>" +
                "    <address2><![CDATA[]]></address2>" +
                "    <city><![CDATA[ASTORIA]]></city>" +
                "    <stateprovcode><![CDATA[NY]]></stateprovcode>" +
                "    <zippost><![CDATA[11103]]></zippost>" +
                "    <countrycode><![CDATA[]]></countrycode>" +
                "    <phone><![CDATA[-]]></phone>" +
                "    <mobilephone><![CDATA[999-9999999]]></mobilephone>" +
                "    <mobilecarrier><![CDATA[]]></mobilecarrier>" +
                "    <fax><![CDATA[-]]></fax>" +
                "    <email><![CDATA[test@testington.com]]></email>" +
                "    <altemail><![CDATA[]]></altemail>" +
                "    <password><![CDATA[12-may-2013 22:45:06]]></password>" +
                "    <url><![CDATA[]]></url>" +
                "    <totalcost><![CDATA[97.0]]></totalcost>" +
                "    <totalpaid><![CDATA[97.0]]></totalpaid>" +
                "    <optout><![CDATA[Y]]></optout>" +
                "    <origin><![CDATA[]]></origin>" +
                "    <quickprint>true</quickprint>" +
                "    <badgemailed></badgemailed>" +
                "    <attendstatuscode><![CDATA[A]]></attendstatuscode>" +
                (
                        withCSIExtraFields ?
                                "   <csiqualified><![CDATA[y]]></csiqualified>" +
                                        "   <csiexhibitorresign><![CDATA[y]]></csiexhibitorresign>" +
                                        "   <csisubcategory><![CDATA[Sample Sub Category]]></csisubcategory>"
                                :
                                ""
                ) +
                "    <demographics>" +
                "        <demo>" +
                "            <demo_name><![CDATA[BOOKGENR]]> </demo_name>" +
                "            <demo_question><![CDATA[My favorite genre of book is:]]> </demo_question>" +
                "            <demo_answer><![CDATA[3]]> </demo_answer>" +
                "            <demo_ded_desc><![CDATA[Non-Fiction]]> </demo_ded_desc>" +
                "        </demo>" +
                "    </demographics>" +
                "    <sessions>" +
                "        <session>" +
                "            <sessionid><![CDATA[PWR]]> </sessionid>" +
                "        </session>" +
                "        <session>" +
                "            <sessionid><![CDATA[SPE5]]> </sessionid>" +
                "        </session>" +
                "    </sessions>" +
                "  </registration>" +
                "</data>";
    }

    private void test(final String showCode, final String registrarCode)
            throws Exception
    {
        final Map<String, String> params = new HashMap<String, String>(){{
            //d = data, p = partner guid
            put("d", generateXmlTestData(registrarCode));
            put("p", "d76aa2f675a33917982d8c78423e284a");
        }};

        final HttpResponse httpResponse = sendRequest(showCode, params, Environment.STAGING);
        String xml = httpResponse.getContentAsText();
        assertEquals(200, httpResponse.getCode());

        System.out.println(xml);
        XStream xs = new XStream (new StaxDriver());
        xs.alias("response", Response.class);
        xs.alias("errors", Errors.class);
        xs.alias("error", Error.class);
        Response resp = (Response)xs.fromXML(xml);

        assertEquals(showCode + " - $.status", "Y", resp.status);
        assertEquals(showCode + " - $.registrationCount", 1, resp.registrationCount);
        assertTrue(showCode + " - $.batchNumber", resp.batchNumber > 0);
    }

    private String generateXmlTestData(String registrarCode)
    {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                "<data>" +
                "  <registration>" +
                "    <partner>CSI</partner>" +
                "    <eventid>" + registrarCode + "</eventid>" +
                "    <registrationid>" + UUID.randomUUID().toString() + "</registrationid>" +
                "    <registrationtype>PWR</registrationtype>" +
                "<registrationtypedescription>Power Reader</registrationtypedescription>" +
                "    <historicalid></historicalid>" +
                "    <exhibitorid></exhibitorid>" +
                "    <prefix><![CDATA[]]></prefix>" +
                "    <firstname><![CDATA[TEST]]></firstname>" +
                "    <middlename><![CDATA[TEST]]></middlename>" +
                "    <lastname><![CDATA[TEST]]></lastname>" +
                "    <suffix><![CDATA[]]></suffix>" +
                "    <nickname><![CDATA[]]></nickname>" +
                "    <jobtitle><![CDATA[]]></jobtitle>" +
                "    <company><![CDATA[]]></company>" +
                "    <division><![CDATA[]]></division>" +
                "    <address1><![CDATA[25-90 35TH ST]]></address1>" +
                "    <address2><![CDATA[]]></address2>" +
                "    <city><![CDATA[ASTORIA]]></city>" +
                "    <stateprovcode><![CDATA[NY]]></stateprovcode>" +
                "    <zippost><![CDATA[11103]]></zippost>" +
                "    <countrycode><![CDATA[]]></countrycode>" +
                "    <phone><![CDATA[-]]></phone>" +
                "    <mobilephone><![CDATA[999-9999999]]></mobilephone>" +
                "    <mobilecarrier><![CDATA[]]></mobilecarrier>" +
                "    <fax><![CDATA[-]]></fax>" +
                "    <email><![CDATA[test@testington.com]]></email>" +
                "    <altemail><![CDATA[]]></altemail>" +
                "    <password><![CDATA[12-may-2013 22:45:06]]></password>" +
                "    <url><![CDATA[]]></url>" +
                "    <totalcost><![CDATA[97.0]]></totalcost>" +
                "    <totalpaid><![CDATA[97.0]]></totalpaid>" +
                "    <optout><![CDATA[Y]]></optout>" +
                "    <origin><![CDATA[]]></origin>" +
                "    <quickprint>true</quickprint>" +
                "    <badgemailed></badgemailed>" +
                "    <attendstatuscode><![CDATA[A]]></attendstatuscode>" +
                "    <demographics>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[BOOKGENR]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[My favorite genre of book is:]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[3]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Non-Fiction]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[CELLPRES]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[Cell Number Present]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[Y]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Yes]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[BUY_WHER]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[Where do you buy your books?]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[B]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Local bookstore]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[DEVICERD]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[My preferred reading device is:]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[1]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Printed]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[TEXT_OPT]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[Text Opt In]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[Y]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Receive Text Messages]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[READ_MON]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[How many books do you read each month?]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[A]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[3]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[HEAR_ABO]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[How did you hear about BEA's Power Readers?]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[B]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Friend]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[GENDERMF]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[I am:]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[F]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[Female]]> </demo_ded_desc>" +
                "</demo>" +
                "<demo>" +
                "<demo_name>" +
                "<![CDATA[BUY_MONT]]> </demo_name>" +
                "<demo_question>" +
                "<![CDATA[How many books do you buy each month?]]> </demo_question>" +
                "<demo_answer>" +
                "<![CDATA[A]]> </demo_answer>" +
                "<demo_ded_desc>" +
                "<![CDATA[3]]> </demo_ded_desc>" +
                "</demo>" +
                "</demographics>" +
                "<sessions>" +
                "<session>" +
                "<sessionid>" +
                "<![CDATA[PWR]]> </sessionid>" +
                "</session>" +
                "<session>" +
                "<sessionid>" +
                "<![CDATA[SPE5]]> </sessionid>" +
                "</session>" +
                "</sessions>" +
                "  </registration>" +
                "</data>";
    }

    private HttpResponse sendRequest(String showCode, final Map<String, String> params, final Environment environment) throws Exception {
        assertNotNull(environment);

        final String webServiceUrl = url(showCode, (environment.equals(Environment.STAGING) ? "staging" : "prod1") + ".sherpaserv.com", "/services/registration-transfer/synctransfer/");
        return HttpHelper.post(webServiceUrl, params);
    }


    //-- Inner classes
    public static class Response
    {
        public String status;
        public int registrationCount;
        public long batchNumber;
        public Errors errors = new Errors();
    }

    public static class Errors
    {
        public List<Error> errrors = new ArrayList<Error>();
    }
    public static class Error
    {
        public String code;
        public String registrationId;
        public String dParameterContent;
    }
}
