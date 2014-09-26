package com.sherpa.test.ws;

import com.sherpa.test.dto.DemographicAnswerDTO;
import com.sherpa.test.dto.DemographicQuestionDTO;
import com.sherpa.test.dto.RegistrationCategoryDTO;
import com.sherpa.test.dto.RegistrationDTO;
import com.sherpa.test.enums.HttpMethod;
import com.sherpa.test.helpers.HttpHelper;
import com.sherpa.test.helpers.HttpResponse;
import com.sherpa.test.serialization.Serializer;
import com.sherpa.test.serialization.json.CommonObjectMapper;
import com.sherpa.test.serialization.json.JsonSerializer;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sherpa.test.junit.ObjectTestUtils.assertRegistrationEquals;

public class RegistrationTransfer2Test extends AbstractWebServiceTestCase {
    public static final String SHERPA_WEB_SERVICE_GUID = "4c06de77eadea226282e13d0f7ffc871";
    public static final String SERVICES2_REGISTRATION_TRANSFER_DELETE = "/services2/registration-transfer/delete/";
    public static final String SERVICES2_REGISTRATION_TRANSFER_GET = "/services2/registration-transfer/get/";
    public static final String SERVICES2_REGISTRATION_TRANSFER_PUT = "/services2/registration-transfer/put/";
    public static final String EMPTY_STRING = "";

    private final Serializer dtoSerializer = new JsonSerializer(new CommonObjectMapper());

    //AUTHENTICATION

    public void testDelete_InvalidGUID()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID("1234");

        //The invalid guid check is done before the parameter check so I can put whatever I want here.
        final String url = getRequestUrl(HttpMethod.DELETE);
        final HttpResponse response = HttpHelper.delete(url, params);

        assertEquals("status code", 401, response.getCode());
    }

    public void testGet_InvalidGUID()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID("1234");

        //The invalid guid check is done before the parameter check so I can put whatever I want here.
        final String url = getRequestUrl(HttpMethod.GET);
        final HttpResponse response = HttpHelper.get(url, params);

        assertEquals("status code", 401, response.getCode());
    }

    public void testPut_InvalidGUID()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID("1234");

        //The invalid guid check is done before the parameter check so I can put whatever I want here.
        final String url = getRequestUrl(HttpMethod.PUT);
        final HttpResponse response = HttpHelper.put(url, params, EMPTY_STRING);

        assertEquals("status code", 401, response.getCode());
    }

    //BASIC PARAMETER CHECKING (missing path parameters or request body)

    public void testDelete_MissingRegistrationId()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        final String url = getRequestUrl(HttpMethod.DELETE);
        final HttpResponse response = HttpHelper.delete(url, params);

        assertEquals("status code", 400, response.getCode());
    }

    public void testGet_MissingRegistrationId()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        final String url = getRequestUrl(HttpMethod.GET);
        final HttpResponse response = HttpHelper.get(url, params);

        assertEquals("status code", 400, response.getCode());
    }

    public void testPut_MissingRegistrationBody()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        final String url = getRequestUrl(HttpMethod.PUT);
        final HttpResponse response = HttpHelper.put(url, params, EMPTY_STRING);

        assertEquals("status code", 400, response.getCode());
    }

    public void testDelete_RegistrationNotFound()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        //%3F = ?
        final String url = getRequestUrl(HttpMethod.DELETE, "%3F%3F%3F%3F");
        final HttpResponse response = HttpHelper.delete(url, params);

        assertEquals("status code", 404, response.getCode());
    }

    public void testGet_RegistrationNotFound()
            throws Exception {
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        //%3F = ?
        final String url = getRequestUrl(HttpMethod.GET, "%3F%3F%3F%3F");
        final HttpResponse response = HttpHelper.get(url, params);

        assertEquals("status code", 404, response.getCode());
    }

    //TODO: We need one dummy registration data that is guaranteed to be there at allActive times.
    // In theory the GET is tested by PUT when it verifies the integrity of the object sent back from the server after a PUT.

//    // GET TEST
//
//    public void testGet_TestRecordMatch()
//            throws Exception {
//        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);
//
//        final String url = getRequestUrl(HttpMethod.GET, "testya");
//        final HttpResponse response = HttpHelper.get(url, params);
//        final String rawJSONResponse = response.getContentAsText();
//
//        assertEquals("status code", 200, response.getCode());
//
//        final Registration receivedRegistration = Registration.fromJSON(rawJSONResponse);
//        final Registration expectedRegistration = new Registration();
//        final RegistrationCategory expectedRegistrationCategory = new RegistrationCategory();
//
//        expectedRegistrationCategory.setCategoryid("RC0");
//        expectedRegistrationCategory.setCategoryname("everything.Test RegistrationCategory 1");
//
//        expectedRegistration.setRegistrationid("testya");
//        expectedRegistration.setFirstname("Yoann");
//        expectedRegistration.setLastname("Archambault");
//        expectedRegistration.setPrefix("Mr.");
//        expectedRegistration.setCompany("Sherpa RTLS inc.");
//        expectedRegistration.setOptout(false);
//        expectedRegistration.setRegistrationcategory(expectedRegistrationCategory);
//        expectedRegistration.setAddress1("306 St Zotique");
//        expectedRegistration.setCity("Montreal");
//        expectedRegistration.setStateprovcode("QC");
//        expectedRegistration.setCountry("CANADA");
//        expectedRegistration.setZippostalcode("33556");
//        expectedRegistration.setPhone("514-9990001");
//        expectedRegistration.setMobilephone("514-199001");
//        expectedRegistration.setFax("514-9990002");
//        expectedRegistration.setEmail("ya@sherpa-solutions.com");
//
//        assertRegistrationEquals(expectedRegistration, receivedRegistration);
//    }

    // DELETE doesn't do anything at the moment so we won't bother checking

    // PUT/POST Error because of no registrationid

    public void testPut_MissingRegistrationId ()
            throws Exception {
        //I think an object with no values will work splendidly.
        final RegistrationDTO badRegistration = new RegistrationDTO();
        final String badRegistrationAsJSON = dtoSerializer.serializeObject(badRegistration);

        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        final String url = getRequestUrl(HttpMethod.PUT);
        final HttpResponse response = HttpHelper.put(url, params, badRegistrationAsJSON);

        System.out.println("Input:\n" + badRegistrationAsJSON);
        System.out.println("Output:\n" + response.getContentAsText());

        assertEquals("status code", 201, response.getCode());
        assertJsonPathEquals(response.getContentAsText(), "$.errors.count", "1");
        assertJsonPathEquals(response.getContentAsText(), "$.errors.messages[0].id", "index_0");
        assertJsonPathEquals(response.getContentAsText(), "$.errors.messages[0].message", "No registrationid given for this record. Skipped.");
    }

    public void testPut_HappyPathNoDemoOrRegCategory()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("happyusernodemoorreg");
        registration.setFirstname("Happy");
        registration.setMiddlename("Yet Sad");
        registration.setLastname("User");
        registration.setPrefix("mr");
        registration.setSuffix("phd");
        registration.setAttendstatuscode("HU");
        registration.setIsexhibitor(true);
        registration.setShowonnetworkingapp(true);
        registration.setAddress1("123 Fake Street");
        registration.setAddress2("Suite 200");
        registration.setBadgemailed(new DateTime().withMillisOfSecond(0));
        registration.setCity("Montreal");
        registration.setCompany("Sherpa RTLS Solutions Inc.");
        registration.setEmail("bl@sherpa-solutions.com");
        registration.setCountry("Canada");
        registration.setLogin("happyusernodemoorreg");
        registration.setPassword("33556");

        final String url = getRequestUrl(HttpMethod.PUT);
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        HttpResponse putResponse = HttpHelper.put(url, params, dtoSerializer.serializeObject(registration));
        final String putJsonResponse = putResponse.getContentAsText();
        System.out.println(putJsonResponse);

        assertEquals("status code", 201, putResponse.getCode());

        assertJsonPathEquals(putJsonResponse, "$.records_received", "1");
        assertJsonPathEquals(putJsonResponse, "$.records_imported", "1");
        assertJsonPathEquals(putJsonResponse, "$.warnings.count", "0");
        assertJsonPathEquals(putJsonResponse, "$.errors.count", "0");

        //We aren't doing a batch if its just one record.
        assertJsonPathNull(putJsonResponse, "$.batch_transaction_id");
        assertJsonPathNotNull(putJsonResponse, "$.processing_time");

        //Now we test what we pushed.
        final String getUrl = getRequestUrl(HttpMethod.GET, registration.getRegistrationid());
        final HttpResponse getResponse = HttpHelper.get(getUrl, params);
        assertEquals("status code", 201, putResponse.getCode());
        final String getJsonResponse = getResponse.getContentAsText();

        final RegistrationDTO addedRegistration = getResponse.getContentAsObject(RegistrationDTO.class, dtoSerializer);

        assertRegistrationEquals(registration, addedRegistration);
    }

    public void testPut_HappyPathRegCategoryNoDemo()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("happyuserregcatnodemo");
        registration.setFirstname("Happy");
        registration.setMiddlename("Yet Sad");
        registration.setLastname("User");
        registration.setPrefix("mr");
        registration.setSuffix("phd");
        registration.setAttendstatuscode("HU");
        registration.setIsexhibitor(true);
        registration.setShowonnetworkingapp(true);
        registration.setAddress1("123 Fake Street");
        registration.setAddress2("Suite 200");
        registration.setBadgemailed(new DateTime().withMillisOfSecond(0));
        registration.setCity("Montreal");
        registration.setCompany("Sherpa RTLS Solutions Inc.");
        registration.setEmail("bl@sherpa-solutions.com");
        registration.setCountry("Canada");
        registration.setLogin("happyuserregcatnodemo");
        registration.setPassword("33556");

        final RegistrationCategoryDTO registrationCategory = new RegistrationCategoryDTO();
        registrationCategory.setCategoryid("TESTREGCAT1");
        registrationCategory.setCategoryname("TEST REGISTRATION CATEGORY 1");
        registrationCategory.isIsexhibitorcategory();

        registration.setRegistrationcategory(registrationCategory);

        final String url = getRequestUrl(HttpMethod.PUT);
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        HttpResponse response = HttpHelper.put(url, params, dtoSerializer.serializeObject(registration));
        final String json = response.getContentAsText();
        System.out.println(json);

        assertEquals("status code", 201, response.getCode());

        assertJsonPathEquals(json, "$.records_received", "1");
        assertJsonPathEquals(json, "$.records_imported", "1");
        assertJsonPathEquals(json, "$.warnings.count", "0");
        assertJsonPathEquals(json, "$.errors.count", "0");

        //We aren't doing a batch if its just one record.
        assertJsonPathNull(json, "$.batch_transaction_id");

        assertJsonPathNotNull(json, "$.processing_time");

        //Now we test what we pushed.
        final String getUrl = getRequestUrl(HttpMethod.GET, registration.getRegistrationid());
        final HttpResponse getResponse = HttpHelper.get(getUrl, params);
        assertEquals("status code", 200, getResponse.getCode());

        final RegistrationDTO addedRegistration = getResponse.getContentAsObject(RegistrationDTO.class, dtoSerializer);

        assertRegistrationEquals(registration, addedRegistration);
    }

    public void testPut_HappyPathRegistrationWithDemo() throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("happyuserdemo");
        registration.setFirstname("Happy");
        registration.setMiddlename("Yet Sad");
        registration.setLastname("User");
        registration.setPrefix("mr");
        registration.setSuffix("phd");
        registration.setAttendstatuscode("HU");
        registration.setIsexhibitor(true);
        registration.setShowonnetworkingapp(true);
        registration.setAddress1("123 Fake Street");
        registration.setAddress2("Suite 200");
        registration.setBadgemailed(new DateTime().withMillisOfSecond(0));
        registration.setCity("Montreal");
        registration.setCompany("Sherpa RTLS Solutions Inc.");
        registration.setEmail("bl@sherpa-solutions.com");
        registration.setCountry("Canada");
        registration.setLogin("happyuserregcatnodemo");
        registration.setPassword("33556");

        final RegistrationCategoryDTO registrationCategory = new RegistrationCategoryDTO();
        registrationCategory.setCategoryid("TESTREGCAT1");
        registrationCategory.setCategoryname("TEST REGISTRATION CATEGORY 1");
        registrationCategory.isIsexhibitorcategory();
        registration.setRegistrationcategory(registrationCategory);

        final List<DemographicQuestionDTO> demographicQuestions = new ArrayList<DemographicQuestionDTO>();

        final DemographicQuestionDTO question1 = new DemographicQuestionDTO();
        question1.setQuestioncode("Q1");
        question1.setQuestiontext("What is your salary range");

        final DemographicAnswerDTO answer1 = new DemographicAnswerDTO();
        answer1.setAnswercode("Q1A1");
        answer1.setAnswertext("20000 - 50000");

        final DemographicAnswerDTO answer2 = new DemographicAnswerDTO();
        answer2.setAnswercode("Q1A2");
        answer2.setAnswertext("50001 - 100000");

        question1.getAnswers().add(answer1);
        question1.getAnswers().add(answer2);

        final DemographicQuestionDTO question2 = new DemographicQuestionDTO();
        question2.setQuestioncode("Q2");
        question2.setQuestiontext("What is your profession?");

        final DemographicAnswerDTO q2answer1 = new DemographicAnswerDTO();
        q2answer1.setAnswercode("Q2A1");
        q2answer1.setAnswertext("Other");
        q2answer1.setIsother(true);

        question2.getAnswers().add(q2answer1);

        demographicQuestions.add(question1);
        demographicQuestions.add(question2);

        registration.setDemographics(demographicQuestions);

        final String url = getRequestUrl(HttpMethod.PUT);
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

        HttpResponse response = HttpHelper.put(url, params, dtoSerializer.serializeObject(registration));
        final String json = response.getContentAsText();
        System.out.println(json);

        assertJsonPathEquals(json, "$.records_received", "1");
        assertJsonPathEquals(json, "$.records_imported", "1");
        assertJsonPathEquals(json, "$.warnings.count", "0");
        assertJsonPathEquals(json, "$.errors.count", "0");

        //We aren't doing a batch if its just one record.
        assertJsonPathNull(json, "$.batch_transaction_id");

        assertJsonPathNotNull(json, "$.processing_time");

        //Now we test what we pushed.
        final String getUrl = getRequestUrl(HttpMethod.GET, registration.getRegistrationid());
        final HttpResponse getResponse = HttpHelper.get(getUrl, params);
        assertEquals("status code", 200, getResponse.getCode());

        final RegistrationDTO addedRegistration = getResponse.getContentAsObject(RegistrationDTO.class, dtoSerializer);

        assertRegistrationEquals(registration, addedRegistration);
    }


    public void testPut_BatchDetection() throws Exception {
        final RegistrationDTO registration1 = new RegistrationDTO();
        registration1.setRegistrationid("batchreg1");
        registration1.setFirstname("Happy");
        registration1.setMiddlename("Yet Sad");
        registration1.setLastname("User");
        registration1.setPrefix("mr");
        registration1.setSuffix("phd");
        registration1.setAttendstatuscode("HU");
        registration1.setIsexhibitor(true);
        registration1.setShowonnetworkingapp(true);
        registration1.setAddress1("123 Fake Street");
        registration1.setAddress2("Suite 200");
        registration1.setBadgemailed(new DateTime().withMillisOfSecond(0));
        registration1.setCity("Montreal");
        registration1.setCompany("Sherpa RTLS Solutions Inc.");
        registration1.setEmail("bl@sherpa-solutions.com");
        registration1.setCountry("Canada");
        registration1.setLogin("batchreg1");
        registration1.setPassword("33556");

        final RegistrationDTO registration2 = new RegistrationDTO();
        registration2.setRegistrationid("batchreg2");
        registration2.setFirstname("Happy");
        registration2.setMiddlename("Yet Sad");
        registration2.setLastname("User");
        registration2.setPrefix("mr");
        registration2.setSuffix("phd");
        registration2.setAttendstatuscode("HU");
        registration2.setIsexhibitor(true);
        registration2.setShowonnetworkingapp(true);
        registration2.setAddress1("123 Fake Street");
        registration2.setAddress2("Suite 200");
        registration2.setBadgemailed(new DateTime().withMillisOfSecond(0));
        registration2.setCity("Montreal");
        registration2.setCompany("Sherpa RTLS Solutions Inc.");
        registration2.setEmail("bl@sherpa-solutions.com");
        registration2.setCountry("Canada");
        registration2.setLogin("batchreg2");
        registration2.setPassword("33556");

        final List<RegistrationDTO> registrations = new ArrayList<RegistrationDTO>();
        registrations.add(registration1);
        registrations.add(registration2);

        final String url = getRequestUrl(HttpMethod.PUT);
        final Map<String, String> params = getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID);

//        HttpResponse response = HttpHelper.put(url, params, new CommonObjectMapper().writeValueAsString(registrations));
        HttpResponse response = HttpHelper.put(url, params, dtoSerializer.serializeList(registrations));
        final String json = response.getContentAsText();
        System.out.println(json);

        assertEquals("status code", 201, response.getCode());

        assertJsonPathEquals(json, "$.records_received", "2");
        assertJsonPathEquals(json, "$.records_imported", "2");
        assertJsonPathEquals(json, "$.warnings.count", "0");
        assertJsonPathEquals(json, "$.errors.count", "0");

        //We are doing a batch, lets see if the transaction id is returned
        assertJsonPathNotNull(json, "$.batch_transaction_id");
        assertJsonPathNotNull(json, "$.processing_time");

        //Now we test what we pushed.
        final String getUrl1 = getRequestUrl(HttpMethod.GET, registration1.getRegistrationid());
        final HttpResponse getResponse1 = HttpHelper.get(getUrl1, params);
        assertEquals("status code", 200, getResponse1.getCode());

        final RegistrationDTO addedRegistration1 = getResponse1.getContentAsObject(RegistrationDTO.class, dtoSerializer);

        final String getUrl2 = getRequestUrl(HttpMethod.GET, registration2.getRegistrationid());
        final HttpResponse getResponse2 = HttpHelper.get(getUrl2, params);
        assertEquals("status code", 200, getResponse2.getCode());

        final RegistrationDTO addedRegistration2 = getResponse2.getContentAsObject(RegistrationDTO.class, dtoSerializer);

        assertRegistrationEquals(registration1, addedRegistration1);
        assertRegistrationEquals(registration2, addedRegistration2);
    }

    public void testPut_NameAndLoginDefaults()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("testdefaultlogintoregid");

        final HttpResponse response = HttpHelper.put(getRequestUrl(HttpMethod.PUT), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), dtoSerializer.serializeObject(registration));
        final String json = response.getContentAsText();
        System.out.println(json);
        assertEquals("status code", 201, response.getCode());

        assertJsonPathEquals(json, "$.records_received", "1");
        assertJsonPathEquals(json, "$.records_imported", "1");
        assertJsonPathEquals(json, "$.warnings.count", "3");
        assertJsonPathEquals(json, "$.warnings.messages[0].message", "No firstname or lastname provided for this record. Will be defaulted to '.'");
        assertJsonPathEquals(json, "$.warnings.messages[0].id", "testdefaultlogintoregid");
        assertJsonPathEquals(json, "$.warnings.messages[1].message", "No login has been supplied, defaulting to registrationid");
        assertJsonPathEquals(json, "$.warnings.messages[1].id", "testdefaultlogintoregid");
        assertJsonPathEquals(json, "$.warnings.messages[2].message", "No password has been suppied, using zippostalcode. If zippostalcode not supplied then defaulting to 77777.");
        assertJsonPathEquals(json, "$.warnings.messages[2].id", "testdefaultlogintoregid");

        final HttpResponse getResponse = HttpHelper.get(getRequestUrl(HttpMethod.GET, registration.getRegistrationid()), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));
        assertEquals("status code", 200, getResponse.getCode());
        final RegistrationDTO actualRegistration = getResponse.getContentAsObject(RegistrationDTO.class, dtoSerializer);

        assertEquals(registration.getRegistrationid(), actualRegistration.getRegistrationid());
        assertEquals(registration.getRegistrationid(), actualRegistration.getLogin());
        assertEquals(DigestUtils.md5Hex("77777"), actualRegistration.getPassword());
        assertEquals(".", actualRegistration.getFirstname());
        assertEquals(".", actualRegistration.getLastname());
    }


    public void testPut_BadDemographicsData_MissingQuestionCodeOrText()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("baddemographicstest1");
        final DemographicQuestionDTO question = new DemographicQuestionDTO();
        final List<DemographicQuestionDTO> questions = new ArrayList<DemographicQuestionDTO>();
        questions.add(question);

        registration.setDemographics(questions);

        final HttpResponse response = HttpHelper.put(getRequestUrl(HttpMethod.PUT), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), dtoSerializer.serializeObject(registration));
        final String putResponseJson = response.getContentAsText();

        assertEquals("status code", 201, response.getCode());
        assertJsonPathEquals(putResponseJson, "$.errors.count", "1");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].id", "baddemographicstest1");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].message", "Missing either 'questioncode' or 'questiontext' for demographics object");
    }


    public void testPut_BadDemographicsData_MissingAnswersForValidQuestion()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("baddemographicstest2");
        final DemographicQuestionDTO question = new DemographicQuestionDTO();
        question.setQuestioncode("Bogus everything.Test Question Code");
        question.setQuestiontext("Bogus everything.Test Question Text");

        final List<DemographicQuestionDTO> questions = new ArrayList<DemographicQuestionDTO>();
        questions.add(question);

        registration.setDemographics(questions);

        final HttpResponse response = HttpHelper.put(getRequestUrl(HttpMethod.PUT), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), dtoSerializer.serializeObject(registration));
        final String putResponseJson = response.getContentAsText();

        assertEquals("status code", 201, response.getCode());
        assertJsonPathEquals(putResponseJson, "$.errors.count", "1");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].id", "baddemographicstest2");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].message", "Invalid demographics structure. Each question should contain one or more answers.");
    }

    public void testPut_ErroredRecordIsNotPersisted()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("badtesterroredregistration");
        final DemographicQuestionDTO question = new DemographicQuestionDTO();
        question.setQuestioncode("Bogus everything.Test Question Code");
        question.setQuestiontext("Bogus everything.Test Question Text");

        final List<DemographicQuestionDTO> questions = new ArrayList<DemographicQuestionDTO>();
        questions.add(question);

        registration.setDemographics(questions);

        final HttpResponse response = HttpHelper.put(getRequestUrl(HttpMethod.PUT), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), dtoSerializer.serializeObject(registration));
        final String putResponseJson = response.getContentAsText();

        assertEquals("status code", 201, response.getCode());
        assertJsonPathEquals(putResponseJson, "$.errors.count", "1");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].id", "badtesterroredregistration");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].message", "Invalid demographics structure. Each question should contain one or more answers.");

        final HttpResponse getResponse = HttpHelper.get(getRequestUrl(HttpMethod.GET, "badtesterroredregistration"), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID));

        assertEquals("status code", 404, getResponse.getCode());
    }

    public void testPut_BadDemographicsData_MissingAnswerCodeOrTextForValidQuestion()
            throws Exception {
        final RegistrationDTO registration = new RegistrationDTO();
        registration.setRegistrationid("baddemographicstest3");
        final DemographicQuestionDTO question = new DemographicQuestionDTO();
        question.setQuestioncode("Bogus everything.Test Question Code");
        question.setQuestiontext("Bogus everything.Test Question Text");
        final DemographicAnswerDTO answer = new DemographicAnswerDTO();
        final List<DemographicAnswerDTO> answers = new ArrayList<DemographicAnswerDTO>();
        answers.add(answer);
        question.setAnswers(answers);

        final List<DemographicQuestionDTO> questions = new ArrayList<DemographicQuestionDTO>();
        questions.add(question);

        registration.setDemographics(questions);

        final HttpResponse response = HttpHelper.put(getRequestUrl(HttpMethod.PUT), getBaseQueryStringParamsWithGUID(SHERPA_WEB_SERVICE_GUID), dtoSerializer.serializeObject(registration));
        final String putResponseJson = response.getContentAsText();

        assertEquals("status code", 201, response.getCode());
        assertJsonPathEquals(putResponseJson, "$.errors.count", "1");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].id", "baddemographicstest3");
        assertJsonPathEquals(putResponseJson, "$.errors.messages[0].message", "Missing either answercode or answertext in questioncode " + registration.getDemographics().get(0).getQuestioncode());
    }

    private Map<String, String> getBaseQueryStringParamsWithGUID(final String webServiceGUID) {
        return new HashMap<String, String>() {{
            put("partner_guid", webServiceGUID);
        }};
    }

    private String getRequestUrl(final HttpMethod method) {
        String pathFragment = "";

        switch(method) {
            case GET:
                pathFragment = SERVICES2_REGISTRATION_TRANSFER_GET;
                break;
            case DELETE:
                pathFragment = SERVICES2_REGISTRATION_TRANSFER_DELETE;
                break;
            case PUT:
            case POST:
                pathFragment = SERVICES2_REGISTRATION_TRANSFER_PUT;
                break;
            default:
                throw new UnsupportedOperationException("HttpMethod " + method.toString() + " not supported.");
        }

//        return url(null, "dev-192", pathFragment);
        return url("test", pathFragment);
    }

    private String getRequestUrl(final HttpMethod method, final String uriSuffix) {
        return getRequestUrl(method) + uriSuffix;
    }
}


