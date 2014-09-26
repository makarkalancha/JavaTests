package com.sherpa.test.ws;

import com.jayway.jsonpath.JsonPath;
import com.sherpa.test.domain.Exhibitor;
import com.sherpa.test.domain.Session;
import com.sherpa.test.dto.UserDataDTO;
import com.sherpa.test.helpers.Conf;
import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;
import com.sherpa.test.serialization.Serializer;
import com.sherpa.test.serialization.json.CommonObjectMapper;
import com.sherpa.test.serialization.json.JsonSerializer;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShortlistTransferTest extends AbstractWebServiceTestCase {
    public static final String SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH = "/services2/shortlist-transfer/add/";
    public static final String SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH = "/services2/shortlist-transfer/delete/";
    public static final String SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH = "/services2/shortlist-transfer/get/";

    public static final String SHERPA_WEB_SERVICE_GUID = "4c06de77eadea226282e13d0f7ffc871";

    public static final String REGISTRATION_ID = "testya";
    public static final String EXHIBITOR_ID = "EXH0";
    public static final String SESSION_ID = "SE1";

    public static final String DEFAULT_REGISTRATION_FIRST_NAME = "RegFirstName";
    public static final String DEFAULT_REGISTRATION_LAST_NAME = "RegLastName";

    private static final Serializer dtoSerializer = new JsonSerializer(new CommonObjectMapper());

    private Conf conf = null;

    @Override
    public void setUp() throws Exception {
        conf = new Conf();
        conf.load("test");
    }

    // HAPPY TESTS

    //--- everything.Test
    public void testAddToShortlist_Exhibitor_NewReg_NewExhibitor()
            throws Exception
    {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String exhibitorName = RandomStringUtils.randomAlphanumeric(50);

        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, "exhibitor", exhibitorName);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/exhibitor/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final String getResponseJson = getResponse.getContentAsText();

        //We expect one user data record.

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, "$[0].groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, "$[0].extKey", eid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, "$[0].targetType", "exhibitor");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);
        assertJsonPathEquals("Registration.firstName", getRegistrationResponseJson, "$.firstname", "RegFirstName");
        assertJsonPathEquals("Registration.lastName", getRegistrationResponseJson, "$.lastname", "RegLastName");

        // everything.Test exhibitor

        final Connection connection = conf.openConnection("test");
        Exhibitor exhibitor = Exhibitor.findUniqueExhibitorByForeignId(connection, eid);

        assertEquals("Exhibitor.foreignId", exhibitor.foreignId, eid);
        assertEquals("Exhibitor.name", exhibitor.name, exhibitorName);
    }

    public void testAddToShortlist_Exhibitor_NewReg_OldExhibitor()
            throws Exception
    {
        String rid = UUID.randomUUID().toString();
        String eid = EXHIBITOR_ID;
        String registrationFirstName = DEFAULT_REGISTRATION_FIRST_NAME;
        String registrationLastName = DEFAULT_REGISTRATION_LAST_NAME;
        final String unexpectedExhibitorName = RandomStringUtils.randomAlphanumeric(50);

        createShortList(rid, registrationFirstName, registrationLastName, eid, "exhibitor", unexpectedExhibitorName);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/exhibitor/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));

        final String getResponseJson = getResponse.getContentAsText();

        //We expect one user data record as this is a new reg.

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, "$[0].groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, "$[0].extKey", eid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, "$[0].targetType", "exhibitor");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);
        assertJsonPathEquals("Registration.firstName", getRegistrationResponseJson, "$.firstname", registrationFirstName);
        assertJsonPathEquals("Registration.lastName", getRegistrationResponseJson, "$.lastname", registrationLastName);

        // everything.Test exhibitor

        final Connection connection = conf.openConnection("test");
        Exhibitor exhibitor = Exhibitor.findUniqueExhibitorByForeignId(connection, eid);

        assertEquals("Exhibitor.foreignId", exhibitor.foreignId, eid);
        assertTrue("Exhibitor.name remains unchanged from the original value " + exhibitor.name, !exhibitor.name.equals(unexpectedExhibitorName));
    }

    public void testAddToShortlist_Exhibitor_OldReg_OldExhibitor()
            throws Exception
    {
        //Add a shortlist item to a registration and exhibitor that already exists.
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;

        String registrationFirstName = DEFAULT_REGISTRATION_FIRST_NAME;
        String registrationLastName = DEFAULT_REGISTRATION_LAST_NAME;
        String unexpectedExhibitorName = RandomStringUtils.randomAlphanumeric(50);

        final String createShortlistJsonResponse = createShortList(rid, registrationFirstName, registrationLastName, eid, "exhibitor", unexpectedExhibitorName);
        final String createdShortlistEntityId = JsonPath.read(createShortlistJsonResponse, "$.shortlistid").toString();

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/exhibitor/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final String getResponseJson = getResponse.getContentAsText();

        //We take the shortlist entity we just created and verify the usual properties.

        final String query = "$[?(@.id == '" + createdShortlistEntityId + "')][0]";

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, query + ".targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, query + ".groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, query + ".extKey", eid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, query + ".targetType", "exhibitor");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg is unchanged from the first add request.

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();
        final String actualRegistrationFirstName = JsonPath.read(getRegistrationResponseJson, "$.firstname").toString();
        final String actualRegistrationLastName = JsonPath.read(getRegistrationResponseJson, "$.lastname").toString();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);
        assertFalse("Registration.firstName should not be altered", actualRegistrationFirstName.equals(registrationFirstName));
        assertFalse("Registration.lastName should not be altered", actualRegistrationLastName.equals(registrationLastName));

        //everything.Test exhibitor

        final Connection connection = conf.openConnection("test");
        Exhibitor exhibitor = Exhibitor.findUniqueExhibitorByForeignId(connection, eid);

        assertEquals("Exhibitor.foreignId", exhibitor.foreignId, eid);
        assertTrue("Exhibitor.name remains unchanged from the original value " + exhibitor.name, !exhibitor.name.equals(unexpectedExhibitorName));
    }

    public void testAddToShortlist_Exhibitor_OldReg_NewExhibitor()
            throws Exception
    {
        //Add a shortlist item to a registration and exhibitor that already exists.
        final String rid = REGISTRATION_ID;
        final String eid = UUID.randomUUID().toString();

        String registrationFirstName = DEFAULT_REGISTRATION_FIRST_NAME;
        String registrationLastName = DEFAULT_REGISTRATION_LAST_NAME;
        String exhibitorName = "exhibitor - " + eid;

        final String createShortlistJsonResponse = createShortList(rid, registrationFirstName, registrationLastName, eid, "exhibitor", exhibitorName);
        final String createdShortlistEntityId = JsonPath.read(createShortlistJsonResponse, "$.shortlistid").toString();

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/exhibitor/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final String getResponseJson = getResponse.getContentAsText();

        //This is an old reg, so we need to check the most recently added shortlist item.
        final String query = "$[?(@.id == '" + createdShortlistEntityId + "')][0]";

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, query + ".targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, query + ".groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, query + ".extKey", eid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, query + ".targetType", "exhibitor");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);

        final String actualRegistrationFirstName = JsonPath.read(getRegistrationResponseJson, "$.firstname").toString();
        final String actualRegistrationLastName = JsonPath.read(getRegistrationResponseJson, "$.lastname").toString();

        assertTrue("Registration.firstName is not changed", !actualRegistrationFirstName.equals(registrationFirstName));
        assertTrue("Registration.lastName is not changed", !actualRegistrationLastName.equals(registrationLastName));

        // everything.Test exhibitor

        final Connection connection = conf.openConnection("test");
        Exhibitor exhibitor = Exhibitor.findUniqueExhibitorByForeignId(connection, eid);

        assertEquals("Exhibitor.foreignId", eid, exhibitor.foreignId);
        assertEquals("Exhibitor.name", exhibitorName, exhibitor.name);
    }

    //--- everything.Test
    public void testAddToShortlist_Session_NewReg_NewSession()
            throws Exception
    {
        String rid = UUID.randomUUID().toString();
        String sid = UUID.randomUUID().toString();
        String sessionName = RandomStringUtils.randomAlphanumeric(50);

        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, sid, "session", sessionName);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/session/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final String getResponseJson = getResponse.getContentAsText();

        //We expect one user data record.

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, "$[0].groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, "$[0].extKey", sid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, "$[0].targetType", "session");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);
        assertJsonPathEquals("Registration.firstName", getRegistrationResponseJson, "$.firstname", "RegFirstName");
        assertJsonPathEquals("Registration.lastName", getRegistrationResponseJson, "$.lastname", "RegLastName");

        // everything.Test session

        final Connection connection = conf.openConnection("test");
        Session session  = Session.findUniqueSessionByForeignId(connection, sid);

        assertEquals("Session.foreignId", session.foreignId, sid);
        assertEquals("Session.name", session.name, sessionName);
    }

    public void testAddToShortlist_Session_NewReg_OldSession()
            throws Exception
    {
        String rid = UUID.randomUUID().toString();
        String sid = SESSION_ID;
        String registrationFirstName = DEFAULT_REGISTRATION_FIRST_NAME;
        String registrationLastName = DEFAULT_REGISTRATION_LAST_NAME;
        final String unexpectedSessionName = RandomStringUtils.randomAlphanumeric(50);

        createShortList(rid, registrationFirstName, registrationLastName, sid, "session", unexpectedSessionName);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/session/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));

        final String getResponseJson = getResponse.getContentAsText();

        //We expect one user data record as this is a new reg.

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, "$[0].targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, "$[0].groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, "$[0].extKey", sid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, "$[0].targetType", "session");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);
        assertJsonPathEquals("Registration.firstName", getRegistrationResponseJson, "$.firstname", registrationFirstName);
        assertJsonPathEquals("Registration.lastName", getRegistrationResponseJson, "$.lastname", registrationLastName);

        // everything.Test session

        final Connection connection = conf.openConnection("test");
        Session session = Session.findUniqueSessionByForeignId(connection, sid);

        assertEquals("Session.foreignId", session.foreignId, sid);
        assertTrue("Session.name remains unchanged from the original value " + session.name, !session.name.equals(unexpectedSessionName));
    }

    public void testAddToShortlist_Session_OldReg_OldSession()
            throws Exception
    {
        //Add a shortlist item to a registration and exhibitor that already exists.
        final String rid = REGISTRATION_ID;
        final String sid = SESSION_ID;

        String registrationFirstName = DEFAULT_REGISTRATION_FIRST_NAME;
        String registrationLastName = DEFAULT_REGISTRATION_LAST_NAME;
        String unexpectedSessionName = RandomStringUtils.randomAlphanumeric(50);

        final String createShortlistJsonResponse = createShortList(rid, registrationFirstName, registrationLastName, sid, "session", unexpectedSessionName);
        final String createdShortlistEntityId = JsonPath.read(createShortlistJsonResponse, "$.shortlistid").toString();

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/session/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final String getResponseJson = getResponse.getContentAsText();

        //We take the shortlist entity we just created and verify the usual properties.

        final String query = "$[?(@.id == '" + createdShortlistEntityId + "')][0]";

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, query + ".targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, query + ".groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, query + ".extKey", sid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, query + ".targetType", "session");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg is unchanged from the first add request.

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();
        final String actualRegistrationFirstName = JsonPath.read(getRegistrationResponseJson, "$.firstname").toString();
        final String actualRegistrationLastName = JsonPath.read(getRegistrationResponseJson, "$.lastname").toString();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);
        assertFalse("Registration.firstName should not be altered", actualRegistrationFirstName.equals(registrationFirstName));
        assertFalse("Registration.lastName should not be altered", actualRegistrationLastName.equals(registrationLastName));

        //everything.Test session

        final Connection connection = conf.openConnection("test");
        Session session = Session.findUniqueSessionByForeignId(connection, sid);

        assertEquals("Session.foreignId", session.foreignId, sid);
        assertTrue("Session.name remains unchanged from the original value " + session.name, !session.name.equals(unexpectedSessionName));
    }

    public void testAddToShortlist_Session_OldReg_NewSession()
            throws Exception
    {
        //Add a shortlist item to a registration and exhibitor that already exists.
        final String rid = REGISTRATION_ID;
        final String sid = UUID.randomUUID().toString();

        String registrationFirstName = DEFAULT_REGISTRATION_FIRST_NAME;
        String registrationLastName = DEFAULT_REGISTRATION_LAST_NAME;
        String sessionName = "session - " + sid;

        final String createShortlistJsonResponse = createShortList(rid, registrationFirstName, registrationLastName, sid, "session", sessionName);
        final String createdShortlistEntityId = JsonPath.read(createShortlistJsonResponse, "$.shortlistid").toString();

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/session/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final String getResponseJson = getResponse.getContentAsText();

        //We take the shortlist entity we just created and verify the usual properties.

        final String query = "$[?(@.id == '" + createdShortlistEntityId + "')][0]";

        final int createDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".createDt").toString());
        final int updateDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".updateDt").toString());
        final int deleteDt = Integer.parseInt(JsonPath.read(getResponseJson, query + ".deleteDt").toString());
        final int targetId = Integer.parseInt(JsonPath.read(getResponseJson, query + ".targetId").toString());

        assertJsonPathEquals("UserData.groupName", getResponseJson, query + ".groupName", "shortlist");
        assertTrue("UserData.targetId is non-zero", targetId > 0);
        assertJsonPathEquals("UserData.extKey", getResponseJson, query + ".extKey", sid);
        assertJsonPathEquals("UserData.targetType", getResponseJson, query + ".targetType", "session");
        assertTrue("UserData.createDT>updateDT", createDt > updateDt);
        assertTrue("UserData.createDT>deletedDT", createDt > deleteDt);

        // everything.Test reg

        final HttpResponse getRegistrationResponse = HttpHelper.get(url("test", RegistrationTransfer2Test.SERVICES2_REGISTRATION_TRANSFER_GET + rid), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getRegistrationResponse.getText(), 200, getRegistrationResponse.getCode());
        final String getRegistrationResponseJson = getRegistrationResponse.getContentAsText();

        assertJsonPathEquals("Registration.foreignRegistrationId", getRegistrationResponseJson, "$.registrationid", rid);

        final String actualRegistrationFirstName = JsonPath.read(getRegistrationResponseJson, "$.firstname").toString();
        final String actualRegistrationLastName = JsonPath.read(getRegistrationResponseJson, "$.lastname").toString();

        assertTrue("Registration.firstName is not changed", !actualRegistrationFirstName.equals(registrationFirstName));
        assertTrue("Registration.lastName is not changed", !actualRegistrationLastName.equals(registrationLastName));

        // everything.Test session

        final Connection connection = conf.openConnection("test");
        Session session = Session.findUniqueSessionByForeignId(connection, sid);

        assertEquals("Session.foreignId", sid, session.foreignId);
        assertEquals("Session.name", sessionName, session.name);
    }

    //PRODUCTS

    //Products is tricky because there is no "known" products in the DB (actually there are but they have no foreignId).

    //DELETE TESTS

    //SINGLE BY TYPE

    public void testRemoveFromShortlist_Exhibitor ()
            throws Exception
    {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String etype = "exhibitor";
        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test exhibitor - " + eid);
        Thread.sleep(1000);     // Delay
        removeFromShortlist(rid, eid, etype);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/exhibitor/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final List<UserDataDTO> userDataDTOList = getResponse.getContentAsObjectList(UserDataDTO.class, dtoSerializer);

        assertEquals("number of user data", 1, userDataDTOList.size());

        UserDataDTO dto = userDataDTOList.get(0);
        assertEquals("UserData.groupName", "SHORTLIST", dto.getGroupName().name());
        assertTrue("UserData.targetId", dto.getTargetId() > 0);
        assertEquals("UserData.targetId", "EXHIBITOR", dto.getTargetType().name());
        assertEquals("UserData.extKey", eid, dto.getExtKey());
        assertTrue("UserData.deleteDT>createDT", dto.getDeleteDt() > dto.getCreateDt());
        assertTrue("UserData.deleteDT>updateDT", dto.getDeleteDt() > dto.getUpdateDt());
    }

    public void testRemoveFromShortlist_Session ()
            throws Exception {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String etype = "session";
        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test session - " + eid);
        Thread.sleep(1000);     // Delay
        removeFromShortlist(rid, eid, etype);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/session/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final List<UserDataDTO> userDataDTOList = getResponse.getContentAsObjectList(UserDataDTO.class, dtoSerializer);

        assertEquals("number of user data", 1, userDataDTOList.size());

        UserDataDTO dto = userDataDTOList.get(0);
        assertEquals("UserData.groupName", "SHORTLIST", dto.getGroupName().name());
        assertTrue("UserData.targetId", dto.getTargetId() > 0);
        assertEquals("UserData.targetId", "SESSION", dto.getTargetType().name());
        assertEquals("UserData.extKey", eid, dto.getExtKey());
        assertTrue("UserData.deleteDT>createDT", dto.getDeleteDt() > dto.getCreateDt());
        assertTrue("UserData.deleteDT>updateDT", dto.getDeleteDt() > dto.getUpdateDt());
    }


    public void testRemoveFromShortlist_Product ()
            throws Exception {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String etype = "product";
        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test product - " + eid);
        Thread.sleep(1000);     // Delay
        removeFromShortlist(rid, eid, etype);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/product/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final List<UserDataDTO> userDataDTOList = getResponse.getContentAsObjectList(UserDataDTO.class, dtoSerializer);

        assertEquals("number of user data", 1, userDataDTOList.size());

        UserDataDTO dto = userDataDTOList.get(0);
        assertEquals("UserData.groupName", "SHORTLIST", dto.getGroupName().name());
        assertTrue("UserData.targetId", dto.getTargetId() > 0);
        assertEquals("UserData.targetId", "PRODUCT", dto.getTargetType().name());
        assertEquals("UserData.extKey", eid, dto.getExtKey());
        assertTrue("UserData.deleteDT>createDT", dto.getDeleteDt() > dto.getCreateDt());
        assertTrue("UserData.deleteDT>updateDT", dto.getDeleteDt() > dto.getUpdateDt());
    }

    //MULTIPLE BY TYPE

    public void testRemoveFromShortlist_MultipleOfSameExhibitor()
            throws Exception {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String etype = "exhibitor";

        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test exhibitor - " + eid);
        Thread.sleep(1000);     // Delay
        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test exhibitor - " + eid);
        Thread.sleep(1000);     // Delay
        removeFromShortlist(rid, eid, etype);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/exhibitor/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final List<UserDataDTO> userDataDTOList = getResponse.getContentAsObjectList(UserDataDTO.class, dtoSerializer);

        assertEquals("number of user data", 2, userDataDTOList.size());

        for(final UserDataDTO dto : userDataDTOList) {
            assertEquals("UserData.groupName", "SHORTLIST", dto.getGroupName().name());
            assertTrue("UserData.targetId", dto.getTargetId() > 0);
            assertEquals("UserData.targetId", "EXHIBITOR", dto.getTargetType().name());
            assertEquals("UserData.extKey", eid, dto.getExtKey());
            assertTrue("UserData.deleteDT>createDT", dto.getDeleteDt() > dto.getCreateDt());
            assertTrue("UserData.deleteDT>updateDT", dto.getDeleteDt() > dto.getUpdateDt());
        }
    }


    public void testRemoveFromShortlist_MultipleOfSameSession()
            throws Exception {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String etype = "session";

        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test session - " + eid);
        Thread.sleep(1000);     // Delay
        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test session - " + eid);
        Thread.sleep(1000);     // Delay
        removeFromShortlist(rid, eid, etype);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/session/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final List<UserDataDTO> userDataDTOList = getResponse.getContentAsObjectList(UserDataDTO.class, dtoSerializer);

        assertEquals("number of user data", 2, userDataDTOList.size());

        for(final UserDataDTO dto : userDataDTOList) {
            assertEquals("UserData.groupName", "SHORTLIST", dto.getGroupName().name());
            assertTrue("UserData.targetId", dto.getTargetId() > 0);
            assertEquals("UserData.targetId", "SESSION", dto.getTargetType().name());
            assertEquals("UserData.extKey", eid, dto.getExtKey());
            assertTrue("UserData.deleteDT>createDT", dto.getDeleteDt() > dto.getCreateDt());
            assertTrue("UserData.deleteDT>updateDT", dto.getDeleteDt() > dto.getUpdateDt());
        }
    }


    public void testRemoveFromShortlist_MultipleOfSameProduct()
            throws Exception {
        String rid = UUID.randomUUID().toString();
        String eid = UUID.randomUUID().toString();
        String etype = "product";

        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test Product - " + eid);
        Thread.sleep(1000);     // Delay
        createShortList(rid, DEFAULT_REGISTRATION_FIRST_NAME, DEFAULT_REGISTRATION_LAST_NAME, eid, etype, "everything.Test Product - " + eid);
        Thread.sleep(1000);     // Delay
        removeFromShortlist(rid, eid, etype);

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_GET_SHORTLISTS_PATH + rid + "/product/"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        final List<UserDataDTO> userDataDTOList = getResponse.getContentAsObjectList(UserDataDTO.class, dtoSerializer);

        assertEquals("number of user data", 2, userDataDTOList.size());

        for(final UserDataDTO dto : userDataDTOList) {
            assertEquals("UserData.groupName", "SHORTLIST", dto.getGroupName().name());
            assertTrue("UserData.targetId", dto.getTargetId() > 0);
            assertEquals("UserData.targetId", "PRODUCT", dto.getTargetType().name());
            assertEquals("UserData.extKey", eid, dto.getExtKey());
            assertTrue("UserData.deleteDT>createDT", dto.getDeleteDt() > dto.getCreateDt());
            assertTrue("UserData.deleteDT>updateDT", dto.getDeleteDt() > dto.getUpdateDt());
        }
    }


    //UNHAPPY PATH

    public void testAddToShortlist_InvalidEntityType() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }


    public void testRemoveFromShortlist_InvalidEntityType() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }


    public void testAddToShortlist_MissingRegistrationId() throws Exception {
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_MissingRegistrationFirstName() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_MissingRegistrationLastName() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_MissingEntityId() throws Exception {
        final String rid = REGISTRATION_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_MissingEntityType() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_MissingEntityName() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_InvalidJSON() throws Exception {
        String json = RandomStringUtils.randomAlphanumeric(500);

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testRemoveFromShortlist_InvalidJSON() throws Exception {
        String json = RandomStringUtils.randomAlphanumeric(500);

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_EmptyBody() throws Exception {
        String json = "";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testRemoveFromShortlist_EmptyBody() throws Exception {
        String json = "";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code", 400, response.getCode());
    }

    public void testAddToShortlist_InvalidGUID() throws Exception {
        String invalidGuid = RandomStringUtils.randomAlphanumeric(50);

        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = "exhibitor";
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(invalidGuid), json);
        assertEquals("status code", 401, response.getCode());
    }

    public void testAddToShortlist_MissingGUID() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = "exhibitor";
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), new HashMap(), json);
        assertEquals("status code", 401, response.getCode());
    }

    public void testRemoveFromShortlist_InvalidGUID() throws Exception {
        String invalidGuid = RandomStringUtils.randomAlphanumeric(50);

        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = "exhibitor";
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(invalidGuid), json);
        assertEquals("status code", 401, response.getCode());
    }

    public void testRemoveFromShortlist_MissingGUID() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String rfirstname = DEFAULT_REGISTRATION_FIRST_NAME;
        final String rlastname = DEFAULT_REGISTRATION_LAST_NAME;
        final String entityType = "exhibitor";
        final String entityName = RandomStringUtils.randomAlphanumeric(20);

        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + rfirstname + "\",\n" +
                "    \"registrationlastname\" : \"" + rlastname + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";

        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), new HashMap(), json);
        assertEquals("status code", 401, response.getCode());
    }

    public void testRemoveFromShortlist_MissingRegistrationId() throws Exception {
        final String eid = EXHIBITOR_ID;
        final String entityType = "exhibitor";

        final String json = "{\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\"\n" +
                "}\n";

        final HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code: "+ response.getText(), 400, response.getCode());
    }

    public void testRemoveFromShortlist_MissingEntityId() throws Exception {
        final String rid = REGISTRATION_ID;
        final String entityType = "exhibitor";

        final String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\"\n" +
                "}\n";

        final HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code: "+ response.getText(), 400, response.getCode());
    }

    public void testRemoveFromShortlist_MissingEntityType() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;

        final String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"entityid\": \"" + eid + "\"\n" +
                "}\n";

        final HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code: "+ response.getText(), 400, response.getCode());
    }

    public void testRemoveFromShortlist_BadRequestMethod() throws Exception {
        final String rid = REGISTRATION_ID;
        final String eid = EXHIBITOR_ID;
        final String entityType = "exhibitor";

        final String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\"\n" +
                "}\n";

        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getResponse.getText(), 405, getResponse.getCode());

        final HttpResponse deleteResponse = HttpHelper.delete(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + deleteResponse.getText(), 405, getResponse.getCode());

        final HttpResponse putResponse = HttpHelper.put(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code: " + putResponse.getText(), 405, putResponse.getCode());
    }

    public void testAddToShortlist_BadRequestMethod() throws Exception {
        final HttpResponse getResponse = HttpHelper.get(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + getResponse.getText(), 405, getResponse.getCode());

        final HttpResponse deleteResponse = HttpHelper.delete(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code: " + deleteResponse.getText(), 405, getResponse.getCode());
    }

    //-- Private
    private String createShortList (String rid, String registrationFirstName, String registrationLastName, String eid, String entityType, String entityName)
            throws Exception
    {
        String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"registrationfirstname\": \"" + registrationFirstName + "\",\n" +
                "    \"registrationlastname\" : \"" + registrationLastName + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\",\n" +
                "    \"entityname\": \"" + entityName + "\"\n" +
                "}\n";
        HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_ADD_TO_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        final String jsonResponse = response.getContentAsText();

        assertEquals("status code", 201, response.getCode());
        assertJsonPathNotNull("AddUserDataResponse.shortlistid", jsonResponse, "$.shortlistid");
        assertJsonPathEquals("CreateShortList.entityid = AddUserDataResponse.entityid", jsonResponse, "$.entityid", eid);
        assertJsonPathEquals("CreateShortList.registrationid = AddUserDataResponse.registrationid", jsonResponse, "$.registrationid", rid);
        assertJsonPathEquals("CreateShortList.entitytype = AddUserDataResponse.entitytype", jsonResponse, "$.entitytype", entityType);

        return jsonResponse;
    }

    private void removeFromShortlist(String rid, String eid, String entityType) throws Exception {
        final String json = "{\n" +
                "    \"registrationid\": \"" + rid + "\",\n" +
                "    \"entityid\": \"" + eid + "\",\n" +
                "    \"entitytype\": \"" + entityType + "\"\n" +
                "}\n";

        final HttpResponse response = HttpHelper.post(url("test", SERVICES2_SHORTLISTTRANSFER_REMOVE_FROM_SHORTLIST_PATH), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), json);
        assertEquals("status code: "+ response.getText(), 200, response.getCode());
    }

    private Map<String, String> getBaseQueryStringParamsWithGUID(final String webServiceGUID) {
        return new HashMap<String, String>() {{
            put("partner_guid", webServiceGUID);
        }};
    }
}
