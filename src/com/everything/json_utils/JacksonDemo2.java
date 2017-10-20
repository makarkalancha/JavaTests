package com.everything.json_utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;

/**
 * Created by Makar Kalancha
 * Date: 03 Jul 2017
 * Time: 14:23
 */
public class JacksonDemo2 {
//    @JsonFilter("filter")
    public static class Wrapper<T> {
        public T field;
        public String fieldWrapper;

//        public Wrapper() {
//        }

        public Wrapper(T field, String fieldWrapper) {
            this.field = field;
            this.fieldWrapper = fieldWrapper;
        }

//        public T getField() {
//            return field;
//        }
//
//        public void setField(T field) {
//            this.field = field;
//        }
//
//        public String getFieldWrapper() {
//            return fieldWrapper;
//        }
//
//        public void setFieldWrapper(String fieldWrapper) {
//            this.fieldWrapper = fieldWrapper;
//        }

        @Override
        public String toString() {
            return "Wrapper{" +
                    "field=" + field +
                    ", fieldWrapper='" + fieldWrapper + '\'' +
                    '}';
        }
    }

//    @JsonFilter("filter")
    public static class Inside {
        public String fieldB1;

//        public Inside() {
//        }

        public Inside(final String fieldB1) {
            this.fieldB1 = fieldB1;
        }

//        public String getFieldB1() {
//            return fieldB1;
//        }
//
//        public void setFieldB1(String fieldB1) {
//            this.fieldB1 = fieldB1;
//        }

        @Override
        public String toString() {
            return "Inside{" +
                    "fieldB1='" + fieldB1 + '\'' +
                    '}';
        }
}

//    public static class MyFilter extends SimpleBeanPropertyFilter {
//        private final Map<Class<?>, Set<String>> excludePropMap;
//
//        public MyFilter(final Map<Class<?>, Set<String>> excludePropMap) {
//            this.excludePropMap = excludePropMap;
//        }
//
//        @Override
//        protected boolean include(final BeanPropertyWriter writer) {
//            return false;
//        }
//
//        @Override
//        protected boolean include(final PropertyWriter writer) {
//            if (writer instanceof BeanPropertyWriter) {
//                final Class<?> cls = ((BeanPropertyWriter) writer).getMember().getDeclaringClass();
//                final Set<String> excludePropSet = excludePropMap.get(cls);
//                return excludePropSet == null || !excludePropSet.contains(writer.getName());
//            }
//            return true;
//        }
//    }

    public static void main(String[] args) throws JsonProcessingException, IOException {
        final Inside inside = new Inside("inside1");
        final Wrapper<Inside> wrapper = new Wrapper<>(inside, "wrapper");
        final ObjectMapper mapper = new ObjectMapper();
//        final SimpleFilterProvider filters = new SimpleFilterProvider();
//        final Map<Class<?>, Set<String>> excludePropMap =
//                Collections.<Class<?>, Set<String>>singletonMap(
//                        B.class,
//                        Collections.singleton("field1"));
//        filters.addFilter("filter", new MyFilter(excludePropMap));
//        mapper.setFilters(filters);
        final ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(wrapper);
//        System.out.println(json);

        JavaType collectionType = mapper.getTypeFactory().constructParametrizedType(Wrapper.class,  Wrapper.class, Inside.class);
        Wrapper<Inside> wrapper1 = mapper.readValue(json, collectionType);
        System.out.println(wrapper1);
    }

}
