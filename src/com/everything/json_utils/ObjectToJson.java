package com.everything.json_utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcalancea on 2016-03-08.
 */
public class ObjectToJson {

    public static void main(String[] args) {
        SomeClass someClass1 = new SomeClass();
        someClass1.setId(1L);
        someClass1.setFormulaName("name");
        someClass1.setActive(true);

        SomeClass someClass2 = new SomeClass();
        someClass2.setId(2L);
        someClass2.setFormulaName("name2");
        someClass2.setActive(false);

        List<SomeClass> someClasses = new ArrayList<>();
        someClasses.add(someClass1);
        someClasses.add(someClass2);

        Gson gson = new Gson();
        String json = gson.toJson(someClasses);

        System.out.println(json);
    }

    public static class SomeClass {

        private Long id;
        private String formulaName;
        private Boolean isActive;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Boolean getActive() {
            return isActive;
        }

        public void setActive(Boolean active) {
            isActive = active;
        }

        public String getFormulaName() {
            return formulaName;
        }

        public void setFormulaName(String formulaName) {
            this.formulaName = formulaName;
        }
    }

}
