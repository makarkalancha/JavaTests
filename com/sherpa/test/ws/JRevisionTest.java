package com.sherpa.test.ws;

import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class JRevisionTest
    extends AbstractWebServiceTestCase
{
    public void testCheck ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("show_code", "jck2013");
        params.put("host", "67.212.69.233");
        params.put("action", "check");
        params.put("current_revision_id", "0");
        params.put("lang", "en_US");
        params.put("os", "ios");
        params.put("device", "iphone");
        params.put("operation", "test");

        String url = url("/content/revisions", 8080);
        HttpResponse resp = HttpHelper.get(url, params);
        String body = resp.getContentAsText();
        System.out.println(body);

        assertEquals("status code", 200, resp.getCode());
    }

    public void testFetch ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("show_code", "jck2013");
        params.put("host", "67.212.69.233");
        params.put("action", "fetch");
        params.put("current_revision_id", "0");
        params.put("lang", "en_US");
        params.put("os", "ios");
        params.put("device", "iphone");
        params.put("operation", "test");
        params.put("headers", "false");
        params.put("compress", "false");

        String url = url("/content/revisions", 8080);
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());

        String body = resp.getContentAsText();
        System.out.println(body);
        assertNotNull(body);
    }

    public String url (String path, int port)
    {
        return "http://67.212.69.233:" + port + path;
    }

}

