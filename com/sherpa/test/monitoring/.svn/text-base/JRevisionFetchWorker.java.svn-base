package com.sherpa.test.monitoring;

import com.sherpa.test.domain.Edition;
import com.sherpa.test.helpers.Conf;
import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JRevisionFetchWorker
    extends AbstractMonitorTestCase
{
    public JRevisionFetchWorker(Conf conf, Edition edition)
    {
        super(conf, edition);
    }

    @Override
    protected void runTest () throws Throwable
    {
        Connection cnn = _conf.openConnection(_edition.name);
        try
        {
            String locale = Edition.locale(cnn);
            Map params = new HashMap();
            params.put("show_code", _edition.name);
            params.put("host", _conf.host);
            params.put("action", "fetch");
            params.put("current_revision_id", "0");
            params.put("lang", locale);
            params.put("os", "ios");
            params.put("device", "iphone");
            params.put("operation", "test");
            params.put("headers", "false");
            params.put("compress", "false");

            String url = url(null, _conf.jrevisionHost, "/content/revisions", 8080);
            HttpResponse resp = HttpHelper.get(url, params, 180);
            assertEquals(_edition.name + " - status code", 200, resp.getCode());

            String body = resp.getContentAsText();
            exec(body, _conf);
        }
        finally
        {
            cnn.close();
        }
    }


    //-- Private
    private void exec(String body, Conf conf)
            throws SQLException
    {
        Connection cnn = _conf.openSQLLiteConnection(_edition.name);
        try
        {
            execAll(body, cnn);
        }
        finally
        {
            cnn.close();
        }
    }

    private void execAll(String body, Connection cnn)
    {
        StringBuilder sb = new StringBuilder();
        int line = 0;
        String sql = null;
        try
        {
            for (int i=0, len=body.length() ; i<len ; i++)
            {
                int ch = body.charAt(i);
                if (ch<9)   // End of query
                {
                    if (sb.length() > 2)
                    {
                        sql = sb.substring(2);
                        sql = adjust(sql);
                        sql = sql.replace('\n', ' ').replace('\t', ' ');

                        /* exec */
                        ++line;
                        //System.out.println(line + " - Executing: " + sql);
                        execOne(sql, cnn);
                    }
                    sb.setLength(0);
                }
                sb.append((char)ch);
            }
        }
        catch (SQLException e)
        {
            fail(line + ". " + sql + "\n" + e.getMessage());
        }
    }

    private void execOne(String sql, Connection cnn)
            throws SQLException
    {
        PreparedStatement stmt = cnn.prepareStatement(sql);
        try
        {
            if (sql.startsWith("SELECT "))
            {
                ResultSet rs = stmt.executeQuery();
                rs.close();
            }
            else
            {
                stmt.executeUpdate();
            }
        }
        finally
        {
            stmt.close();
        }
    }

    private String adjust(String sql)
    {
        String[] prefixes = new String[] {
                "CREATE ",
                "ALTER ",
                "INSERT ",
                "UPDATE ",
                "DELETE ",
                "SELECT "
        };
        for (String prefix : prefixes)
        {
            if (sql.startsWith(prefix.substring(1)))
            {
                return prefix.substring(0, 1) + sql;
            }
        }
        return sql;
    }
}
