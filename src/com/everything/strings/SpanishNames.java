package com.everything.strings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 07/11/14
 * Time: 1:53 PM
 */
public class SpanishNames {
    public static void main(String[] args) {
        String[] spanishNamesArrays = {
                "Ing. D. Guillermo Redrado Salvatierra",
                "D. Guillermo Redrado Salvatierra",
                "Ing. Gabriel Torres Aguilar",
                "Ing. Luis Narvaez",
                "Elías Cisneros Ávila",
                "Luis Gerardo Baza Santamaría"
        };
        for(String name : spanishNamesArrays){
            getFirstLastName(name);
        }
    }

    private static void getFirstLastName(String name) {
        SpanishName spanishName = new SpanishName(name);

        System.out.println("name: "+name+
                "; first:" + spanishName.getFirstName() +
                "; last:" + spanishName.getLastName()+
                "; title:" + spanishName.getTitle()
        );
    }



    private static class SpanishName{
        private StringBuilder title = new StringBuilder();
        private StringBuilder firstName = new StringBuilder();
        private StringBuilder lastName = new StringBuilder();

        private final String fullName;
        private final Set<String> predefinedTitleSet = new HashSet<String>();

        {
            predefinedTitleSet.add("Ing.");
        }

        public SpanishName(String fullName) {
            this.fullName = fullName;
            process();
        }

        public String getTitle() {
            return title.toString();
        }

        public String getFirstName() {
            return firstName.toString();
        }

        public String getLastName() {
            return lastName.toString();
        }

        private void process(){
            List<String> fullNameList = StringUtil.split(fullName, " ");
            if(predefinedTitleSet.contains(fullNameList.get(0))) {
                title.append(fullNameList.get(0));
                fullNameList.remove(0);
            }

            if (fullNameList.size() == 2) {
                firstName.append(fullNameList.get(0));
                lastName.append(fullNameList.get(1));
            } else if(fullNameList.size() > 2) {
                List<String> lastNameList = fullNameList.subList(fullNameList.size() - 2, fullNameList.size());
                lastName.append(StringUtil.merge(lastNameList," "));
//                fullNameList.remove(fullNameList.size() - 2);
//                fullNameList.remove(fullNameList.size() - 1);
//                firstName.append(StringUtil.merge(fullNameList, " "));

                List<String> firstNameList = fullNameList.subList(0, fullNameList.size() - 2);
                firstName.append(StringUtil.merge(firstNameList, " "));
            }
        }
    }
}
