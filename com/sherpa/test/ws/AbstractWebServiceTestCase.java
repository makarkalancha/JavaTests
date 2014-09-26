package com.sherpa.test.ws;

import com.jayway.jsonpath.JsonPath;
import junit.framework.TestCase;

public abstract class AbstractWebServiceTestCase
    extends TestCase
{
    public AbstractWebServiceTestCase()
    {
    }
    public AbstractWebServiceTestCase(String name)
    {
        super(name);
    }

    public String url (String edition, String server, String path)
    {
        return url(edition, server, path, 80);
    }

    public String url (String edition, String server, String path, int port)
    {
        String xport = port != 80 ? ":" + port : "";
        return edition != null
                ? "http://" + edition + "." + server + xport + path
                : "http://" + server + xport + path;
    }

    public String url (String edition, String path)
    {
        return url(edition, "staging.sherpaserv.com", path);
    }

    public void assertJsonPathEquals(String json, String xpath, String expected)
    {
        assertJsonPathEquals("", json, xpath, expected);

    }
    public void assertJsonPathEquals(String message, String json, String xpath, String expected)
    {
        try
        {
            Object val = JsonPath.read (json, xpath);
            String str = val != null ? val.toString() : null;
            assertEquals(message + " " + xpath, expected, str);
        }
        catch (com.jayway.jsonpath.InvalidPathException e)
        {
            fail("[" + xpath + "] not found");
        }

    }

    public void assertJsonPathNull(String json, String xpath)
    {
        assertJsonPathNull("", json, xpath);
    }
    public void assertJsonPathNull(String message, String json, String xpath)
    {
        try
        {
            assertNull(message + " " + xpath, JsonPath.read (json, xpath));
        }
        catch (com.jayway.jsonpath.InvalidPathException e)
        {

        }
    }

    public void assertJsonPathNotNull(String json, String xpath)
    {
        assertJsonPathNotNull("", json, xpath);
    }
    public void assertJsonPathNotNull(String message, String json, String xpath)
    {
        try
        {
            assertNotNull(message + " " + xpath, JsonPath.read (json, xpath));
        }
        catch (com.jayway.jsonpath.InvalidPathException e)
        {
            fail("[" + xpath + "] not found");
        }
    }
}

