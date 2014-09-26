package com.sherpa.test.ws;

import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * everything.Test /services2/registration
 */
public class Registration2Test
    extends AbstractWebServiceTestCase
{
    //-- get-by-badge
    public void testGetByBadge_Attendee ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("user_id", "3");
        params.put("badge_number", "testjr");
        String url = url("test", "/services2/registration/get-by-badge");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());

        String json = resp.getContentAsText();
        System.out.println(json);
        assertJsonPathEquals(json, "$.firstName", "Jacques");
        assertJsonPathEquals(json, "$.lastName", "Racine");
        assertJsonPathEquals(json, "$.title", "CEO");
        assertJsonPathEquals(json, "$.email", "jr@sherpa-solutions.com");
        assertJsonPathEquals(json, "$.phone", "514-9990002");
        assertJsonPathEquals(json, "$.company", "Sherpa RTLS inc.");
        assertJsonPathEquals(json, "$.city", "Montreal");
        assertJsonPathEquals(json, "$.state", "QC");
        assertJsonPathEquals(json, "$.country", "CANADA");
    }

    public void testGetByBadge_Exibitor ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("user_id", "31");
        params.put("badge_number", "testjr");
        String url = url("test", "/services2/registration/get-by-badge");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());

        String json = resp.getContentAsText();
        System.out.println(json);
        assertJsonPathEquals(json, "$.firstName", "Jacques");
        assertJsonPathEquals(json, "$.lastName", "Racine");
        assertJsonPathNull(json, "$.title");
        assertJsonPathNull(json, "$.email");
        assertJsonPathNull(json, "$.phone");
        assertJsonPathEquals(json, "$.company", "Sherpa RTLS inc.");
        assertJsonPathNull(json, "$.city");
        assertJsonPathNull(json, "$.state");
        assertJsonPathNull(json, "$.country");
    }

    public void testGetByBadge_NoUserId ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("badge_number", "testjr");
        String url = url("test", "/services2/registration/get-by-badge");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 400, resp.getCode());
    }
    public void testGetByBadge_NoBadgeNumber ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("user_id", "3");
        String url = url("test", "/services2/registration/get-by-badge");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 400, resp.getCode());
    }
    public void testGetByBadge_InvalidBadgeNumber ()
            throws Exception
    {
        Map params = new HashMap();
        params.put("user_id", "3");
        params.put("badge_number", "????");
        String url = url("test", "/services2/registration/get-by-badge");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 404, resp.getCode());
    }
    public void testGetByBadge_UnauthorizedUnser()
            throws Exception
    {
        Map params = new HashMap();
        params.put("user_id", "44");    // Org staff
        params.put("badge_number", "testjr");
        String url = url("test", "/services2/registration/get-by-badge");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 403, resp.getCode());
    }
}
