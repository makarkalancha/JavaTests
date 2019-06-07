/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
public class GenericReturnMethod {
    private Map<Long, Map<String, Field>> agencyIdToTaxonomyFields = new HashMap<>();

    public void put(Long id, Map<String, Field> map){
        agencyIdToTaxonomyFields.put(id, map);
    }

    public static void main(String[] args) {
        Map<String, Field> nameField = new HashMap<>();
        GenericReturnMethod genericReturnMethod = new GenericReturnMethod();
        genericReturnMethod.put(1L, nameField);

        Field Field1 = Field.builder()
                .name("name")
                .type("STRING")
                .value("123st")
                .build();
        Field Field2 = Field.builder()
                .name("number")
                .type("LONG")
                .value("123")
                .build();

        nameField.put("name", Field1);
        nameField.put("number", Field2);

//        String valueStr = genericReturnMethod.getFieldValue(1L,"name");
        Long valueLong = genericReturnMethod.getFieldValue(1L,"number");
//        System.out.println(valueStr);
        System.out.println(valueLong);

    }

    private <T> T getFieldValue(Long agencyId, String fieldName){
        Map<String, Field> FieldMap = agencyIdToTaxonomyFields.get(agencyId);
        Field field = FieldMap.get(fieldName);
        if(field.getType().equals("LONG")){
//            return (T)Long.getLong(field.getValue());
            return (T)new Long(field.getValue());
        }
        return null;
    }
}
