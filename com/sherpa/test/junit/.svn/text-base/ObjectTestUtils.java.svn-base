package com.sherpa.test.junit;

import com.sherpa.test.dto.DemographicAnswerDTO;
import com.sherpa.test.dto.DemographicQuestionDTO;
import com.sherpa.test.dto.RegistrationCategoryDTO;
import com.sherpa.test.dto.RegistrationDTO;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

public class ObjectTestUtils {

    public static void assertRegistrationEquals(RegistrationDTO expected, RegistrationDTO actual) throws Exception {
        //If they're pointing to the same address then they're equal, otherwise we'll check field by field.
        if(expected != actual) {
            //Check some preconditions.
            assert expected != null : "Expected object is null but actual is not-null";
            assert expected.getDemographics().size() == actual.getDemographics().size() : "Expected demographics list does not contain the same number of elements as the actual demographics list";

            Collections.sort(expected.getDemographics());
            Collections.sort(actual.getDemographics());

            assertEquals(expected.isShowonnetworkingapp(), actual.isShowonnetworkingapp());
            assertEquals(expected.getRegistrationid(), actual.getRegistrationid());
            assertEquals(expected.getAddress1(), actual.getAddress1());
            assertEquals(expected.getAddress2(), actual.getAddress2());
            assertEquals(expected.getAttendstatuscode(), actual.getAttendstatuscode());
            //Shave off the milliseconds which causes the default equals to fail.
            assertEquals(expected.getBadgemailed(), actual.getBadgemailed());
            assertEquals(expected.getCity(), actual.getCity());
            assertEquals(expected.getCountry() == null ? expected.getCountry() : expected.getCountry().toLowerCase(), actual.getCountry() == null ? actual.getCountry() : actual.getCountry().toLowerCase());
            assertEquals(expected.getCompany(), actual.getCompany());
            assertEquals(expected.getEmail(), actual.getEmail());
            assertEquals(expected.getFax(), actual.getFax());
            assertEquals(expected.getFirstname(), actual.getFirstname());
            assertEquals(expected.getLastname(), actual.getLastname());
            assertEquals(expected.getMiddlename(), actual.getMiddlename());
            assertEquals(expected.getMobilecarrier(), actual.getMobilecarrier());
            assertEquals(expected.getNickname(), actual.getNickname());
            assertEquals(expected.getOtherregistrationid(), actual.getOtherregistrationid());
            assertEquals(expected.getPrefix(), actual.getPrefix());
            assertEquals(expected.getSuffix(), actual.getSuffix());
            assertEquals(expected.getStateprovcode(), actual.getStateprovcode());
            assertEquals(expected.getPhone(), actual.getPhone());
            assertEquals(expected.getLogin(), actual.getLogin());
            assertEquals(DigestUtils.md5Hex(expected.getPassword()), actual.getPassword());
            assertEquals(expected.getDivision(), actual.getDivision());
            assertEquals(expected.getMobilephone(), actual.getMobilephone());
            assertEquals(expected.getTotalcost(), actual.getTotalcost());
            assertEquals(expected.getTotalpaid(), actual.getTotalpaid());
            assertEquals(expected.getWebsite(), actual.getWebsite());
            assertEquals(expected.getZippostalcode(), actual.getZippostalcode());
            assertEquals(expected.isIsexhibitor(), actual.isIsexhibitor());

            assertRegistrationCategoryEquals(expected.getRegistrationcategory(), actual.getRegistrationcategory());

            for(int i = 0; i != expected.getDemographics().size(); i++) {
                final DemographicQuestionDTO expectedQuestion = expected.getDemographics().get(i);
                final DemographicQuestionDTO actualQuestion = actual.getDemographics().get(i);
                assertDemographicQuestionEquals(expectedQuestion, actualQuestion);
            }
        }
    }

    public static void assertRegistrationCategoryEquals(RegistrationCategoryDTO expected, RegistrationCategoryDTO actual) throws Exception {
        //If they're pointing to the same address then they're equal, otherwise we'll check field by field.
        if(expected != actual) {
            assert expected != null : "Expected object is null but actual is not-null";
            assertEquals(expected.getCategoryid(), actual.getCategoryid());
            assertEquals(expected.getCategoryname(), actual.getCategoryname());
            assertEquals(expected.isIsexhibitorcategory(), actual.isIsexhibitorcategory());
        }
    }

    public static void assertDemographicQuestionEquals(DemographicQuestionDTO expected, DemographicQuestionDTO actual) {
        //If they're pointing to the same address then they're equal, otherwise we'll check field by field.
        if(expected != actual) {
            assert expected != null : "Expected object is null but actual is not-null";
            assert expected.getAnswers().size() == actual.getAnswers().size() : "Expected demographic answers list does not contain the same number of elements as the actual demographic answers list";

            Collections.sort(expected.getAnswers());
            Collections.sort(actual.getAnswers());

            assertEquals(expected.getQuestioncode(), actual.getQuestioncode());
            assertEquals(expected.getQuestiontext(), actual.getQuestiontext());

            for(int i = 0; i != expected.getAnswers().size(); i++) {
                final DemographicAnswerDTO expectedAnswer = expected.getAnswers().get(i);
                final DemographicAnswerDTO actualAnswer = actual.getAnswers().get(i);
                assertDemographicAnswerEquals(expectedAnswer, actualAnswer);
            }
        }
    }

    public static void assertDemographicAnswerEquals(DemographicAnswerDTO expected, DemographicAnswerDTO actual) {
        //If they're pointing to the same address then they're equal, otherwise we'll check field by field.
        if(expected != actual) {
            assert expected != null : "Expected object is null but actual is not-null";
            assertEquals(expected.getAnswercode(), actual.getAnswercode());
            assertEquals(expected.getAnswertext(), actual.getAnswertext());
            assertEquals(expected.getIsother(), actual.getIsother());
        }
    }
}
