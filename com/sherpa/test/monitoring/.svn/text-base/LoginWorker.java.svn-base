package com.sherpa.test.monitoring;

import com.sherpa.test.domain.Edition;
import com.sherpa.test.helpers.Conf;
import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class LoginWorker
        extends AbstractMonitorTestCase
{
    public LoginWorker(Conf conf, Edition edition)
    {
        super(conf, edition);
    }

    @Override
    protected void runTest () throws Throwable
    {
        Map params = new HashMap();
        params.put("confirmationNumber", "testya");
        params.put("zipCode", "33556");
        String url = url(_edition.name, _conf.wsHost, "/json-services/login-services");

        long time1 = System.currentTimeMillis();
        HttpResponse resp = HttpHelper.get(url, params);
        long time2 = System.currentTimeMillis();

        assertEquals(_edition.name + " - HTTP Status", 200, resp.getCode());
        assertTrue(_edition.name + " - duration longer than " + MAX_DURATION + " secs", (time2-time1)/1000 < MAX_DURATION);

        String json = resp.getContentAsText();
        assertJsonPathEquals(_edition.name, json, "$.authenticated", "true");
    }
}
