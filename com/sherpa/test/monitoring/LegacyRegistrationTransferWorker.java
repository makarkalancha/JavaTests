package com.sherpa.test.monitoring;

import com.sherpa.test.domain.Edition;
import com.sherpa.test.domain.Guid;
import com.sherpa.test.helpers.Conf;
import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.sql.Connection;
import java.util.*;

public class LegacyRegistrationTransferWorker
    extends AbstractMonitorTestCase
{
    public LegacyRegistrationTransferWorker(Conf conf, Edition edition)
    {
        super(conf, edition);
    }

    @Override
    protected void runTest () throws Throwable
    {
        if (_edition.registrarShowcode == null || _edition.registrarShowcode.length() == 0)
        {
            return;
        }

        /* fetch the edition GUID */
        Guid guid = null;
        Connection cnn = _conf.openConnection(_edition.name);
        try
        {
            List<Guid> guids = Guid.findByEdition(_edition.id, cnn);
            if (guids.isEmpty())
            {
                return;
            }
            guid = guids.get(0);

        }
        finally
        {
            cnn.close();
        }

        /* everything.Test */
        final Map<String, String> params = new HashMap<String, String>();
        params.put("d", generateXmlTestData(guid, true));
        params.put("p", guid.value);

        final HttpResponse httpResponse = sendRequest(params);
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


    private String generateXmlTestData(Guid guid, boolean withCSIExtraFields)
    {
        return "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                "<data>" +
                "  <registration>" +
                "    <partner>" + guid.partner + "</partner>" +
                "    <eventid>" + _edition.registrarShowcode + "</eventid>" +
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

    private HttpResponse sendRequest(final Map<String, String> params) throws Exception {

        final String webServiceUrl = url(_edition.name, _conf.wsHost, "/services/registration-transfer/synctransfer/");
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
        public String registrationid;
        public String description;
        public String dParameterContent;
    }
}
