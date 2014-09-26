package com.sherpa.test.ws;

import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * everything.Test the login web service: /json-services/login-services
 */
public class LoginTest
    extends AbstractWebServiceTestCase
{
    public void testLogin ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("confirmationNumber", "testya");
        params.put("zipCode", "33556");
        String url = url("test", "/json-services/login-services");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());

        String json = resp.getContentAsText();
        assertJsonPathEquals(json, "$.authenticated", "true");
        assertJsonPathEquals(json, "$.user.login", "testya");
        assertJsonPathEquals(json, "$.user.backingType", "attendee");
    }

    public void testBadUsername ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("confirmationNumber", "xxx");
        params.put("zipCode", "33556");
        String url = url("test", "/json-services/login-services");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());

        String json = resp.getContentAsText();
        assertJsonPathEquals(json, "$.authenticated", "false");
    }

    public void testBadPassword ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("confirmationNumber", "testya");
        params.put("zipCode", "?????");
        String url = url("test", "/json-services/login-services");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());

        String json = resp.getContentAsText();
        assertJsonPathEquals(json, "$.authenticated", "false");
    }
}
