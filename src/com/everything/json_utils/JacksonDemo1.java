package com.everything.json_utils;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Makar Kalancha
 * Date: 03 Jul 2017
 * Time: 14:23
 */
public class JacksonDemo1 {
    @JsonFilter("filter")
    public static class A {
        public final String fieldA1;

        public A(final String fieldA1) {this.fieldA1 = fieldA1;}
    }

    @JsonFilter("filter")
    public static class B {
        public final String fieldB1;
        public final List<A> listOfAinB;

        public B(final String fieldB1, final List<A> listOfAinB) {
            this.fieldB1 = fieldB1;
            this.listOfAinB = listOfAinB;
        }
    }
    @JsonFilter("filter")
    public static class Foo {
        public final String fieldFoo1;
        public final List<B> fieldB2;

        public Foo(final String fieldFoo1, final List<B> fieldB2) {
            this.fieldFoo1 = fieldFoo1;
            this.fieldB2 = fieldB2;
        }
    }

    public static class MyFilter extends SimpleBeanPropertyFilter {
        private final Map<Class<?>, Set<String>> excludePropMap;

        public MyFilter(final Map<Class<?>, Set<String>> excludePropMap) {
            this.excludePropMap = excludePropMap;
        }

        @Override
        protected boolean include(final BeanPropertyWriter writer) {
            return false;
        }

        @Override
        protected boolean include(final PropertyWriter writer) {
            if (writer instanceof BeanPropertyWriter) {
                final Class<?> cls = ((BeanPropertyWriter) writer).getMember().getDeclaringClass();
                final Set<String> excludePropSet = excludePropMap.get(cls);
                return excludePropSet == null || !excludePropSet.contains(writer.getName());
            }
            return true;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        final B b = new B("B1", Arrays.asList(new A("A1"), new A("A2")));
        final Foo foo = new Foo("foo", Arrays.asList(b));
        final ObjectMapper mapper = new ObjectMapper();
        final SimpleFilterProvider filters = new SimpleFilterProvider();
        final Map<Class<?>, Set<String>> excludePropMap =
                Collections.<Class<?>, Set<String>>singletonMap(
                        B.class,
                        Collections.singleton("field1"));
        filters.addFilter("filter", new MyFilter(excludePropMap));
        mapper.setFilters(filters);
        final ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(foo));
    }

}
