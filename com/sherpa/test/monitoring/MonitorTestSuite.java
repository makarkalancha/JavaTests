package com.sherpa.test.monitoring;

import com.sherpa.test.domain.Edition;
import com.sherpa.test.helpers.Conf;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class MonitorTestSuite
    extends TestSuite
{
    public static Test suite()
    {
        try
        {
            MonitorTestSuite suite = new MonitorTestSuite();
            String profile = "newprod1";
            Conf conf = new Conf ();
            conf.load(profile);
            Connection cnn = conf.openConnection("editions_master");
            try
            {
                List<Edition> editions = Edition.all(cnn); //Edition.allActive(cnn);
                List<Object[]> result = new ArrayList<Object[]>();
                Edition.NotEndedFilter filter = new Edition.NotEndedFilter();
                int count = 0;
                for (Edition edition : editions)
                {
                    if (filter.accept(edition, conf))
                    {
                        System.out.println("Accepting " + edition.name);
                        Connection cnn2 = conf.openConnection(edition.name);
                        edition.retrieveDetails(cnn2);
                        try
                        {
                            count++;
                            //suite.addTest(new LoginWorker(conf, edition));
                            suite.addTest(new JRevisionFetchWorker(conf, edition));
                            suite.addTest(new LegacyRegistrationTransferWorker(conf, edition));
                        }
                        finally
                        {
                            cnn2.close();
                        }
                    }
                    else
                    {
                        System.out.println("Rejecting " + edition.name);
                    }
                }
                System.out.println(count + " editions to monitor");
                return suite;
            }
            finally
            {
                cnn.close();
            }
        }
        catch(Exception e)
        {
            throw new IllegalStateException(e.getMessage());
        }
    }

}
