package com.sherpa.test.ws;

import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class UserDataTest
    extends AbstractWebServiceTestCase
{
    public void testReset()
            throws Exception
    {
        Map params = new HashMap();
        params.put("confirmationNumber", "testya");
        params.put("zipCode", "33556");
        String url = url("test", "/services/user-data/reset-user/");
        HttpResponse resp = HttpHelper.post(url, params);

        assertEquals("status code", 200, resp.getCode());
    }

    public void testFullSync()
            throws Exception
    {
        Map params = new HashMap();
        params.put("confirmationNumber", "testya");
        params.put("zipCode", "33556");
        params.put("origin", "device-ios2");
        params.put("data", "{}");
        String url = url("test", "/services/user-data/full-sync/");
        HttpResponse resp = HttpHelper.post(url, params);
        String json = resp.getContentAsText();
        System.out.println(json);

        assertEquals("status code", 200, resp.getCode());

        assertJsonPathEquals(json, "$.randomNumber", "success");
        assertJsonPathNotNull(json, "$.transactions");
    }

}
