package com.sherpa.test.monitoring;

import com.sherpa.test.domain.Edition;
import com.sherpa.test.helpers.Conf;
import com.sherpa.test.ws.AbstractWebServiceTestCase;

public class AbstractMonitorTestCase
    extends AbstractWebServiceTestCase
{
    public static final int MAX_DURATION = 30;
    protected Edition _edition;
    protected Conf _conf;

    public AbstractMonitorTestCase(Conf conf, Edition edition)
    {
        this._conf = conf;
        this._edition = edition;
    }

    @Override
    public String getName ()
    {
        return getClass().getSimpleName() + "." +_edition.name;
    }

}
