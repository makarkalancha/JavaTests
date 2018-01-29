package com.everything.json_utils.jackson_inheritance;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by mcalancea
 * Date: 25 Jan 2018
 * Time: 17:21
 */
public class JacksonInheritanceDemo {
    public static void main(String[] args) throws Exception{
        Dog dog = new Dog();
        dog.name = "lacy";

        Animal animal = new Animal();
        animal.name = "animal !!!";

        Zoo zoo = new Zoo();
        zoo.animal = animal;

        String result = new ObjectMapper()
                .writeValueAsString(zoo);

        System.out.println(result);
    }
}
