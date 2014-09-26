package com.sherpa.test.ws;

import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: herve
 * Date: 2013-04-18
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class SmsTest
    extends AbstractWebServiceTestCase
{
    public void testEnqueue()
            throws Exception
    {
        String url = url("test", "/services2/sms/enqueue/");
        HttpResponse resp = HttpHelper.post(url, new HashMap());

        assertEquals("status code", 200, resp.getCode());

        /* test broadcast #1 - custom message/approved */
        url = url("test", "/services2/sms/get_broadcast");
        resp = HttpHelper.get(url, Collections.singletonMap("id", "1"));
        String json = resp.getContentAsText();
        System.out.println("broadcast#1=" + json);
        assertJsonPathNull("broadcast#1", json, "$.sent_start_time");

        /* test broadcast #2 - show message/approved*/
        url = url("test", "/services2/sms/get_broadcast");
        resp = HttpHelper.get(url, Collections.singletonMap("id", "2"));
        json = resp.getContentAsText();
        System.out.println("broadcast#2=" + json);
        assertJsonPathNotNull("broadcast#2", json, "$.sent_start_time");
        assertJsonPathNotNull("broadcast#2", json, "$.target_cell_number_count");
        assertJsonPathNotNull("broadcast#2", json, "$.target_cell_numbers");

        /* test broadcast #3 - show message/unapproved */
        url = url("test", "/services2/sms/get_broadcast");
        resp = HttpHelper.get(url, Collections.singletonMap("id", "3"));
        json = resp.getContentAsText();
        System.out.println("broadcast#3=" + json);
        assertJsonPathNull("broadcast#3", json, "$.sent_start_time");
    }

    public void testUpdateSentCount()
            throws Exception
    {
        /* enqueue to make sure that SMS get sent */
        String url = url("test", "/services2/sms/enqueue");
        HttpHelper.post(url, new HashMap());

        /* update */
        url = url("test", "/services2/sms/update_sent_count");
        Map params = new HashMap();
        params.put("id", "2");
        params.put("count", "5");
        HttpResponse resp = HttpHelper.get(url, params);

        assertEquals("status code", 200, resp.getCode());
        String json = resp.getContentAsText();
        System.out.println("broadcast#2=" + json);
        assertJsonPathEquals(json, "$.sent_cell_number_count", "5");
    }
}
