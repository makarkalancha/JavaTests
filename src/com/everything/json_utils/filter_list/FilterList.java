package com.everything.json_utils.filter_list;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 07/10/2017
 * Time: 14:05
 */
public class FilterList {

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Set.class, new CurrencyIdToNominalValueAdapter())
//            .registerTypeAdapter(FilterA.class, new CurrencyIdToNominalValueAdapter())
//            .registerTypeAdapter(FilterB.class, new CurrencyIdToNominalValueAdapter())
            .create();

    public static void main(String[] args) {
        Filter filterA = new FilterA("nameA", "by name");
        Filter filterB = new FilterB("nameB", "by date");
        Set<Filter> filtersOriginal = new LinkedHashSet<>();
        filtersOriginal.add(filterA);
        filtersOriginal.add(filterB);

        String json = gson.toJson(filtersOriginal, Set.class);

        System.out.println(json);

        Set<Filter> filtersFromJson = gson.fromJson(json, Set.class);
        for(Filter filter : filtersFromJson){
            System.out.println(filter);
        }


    }

    //https://stackoverflow.com/questions/25673984/convert-guava-hashmultimap-to-json
//https://stackoverflow.com/questions/10589716/how-to-sort-guava-multimap-key-date
//    https://stackoverflow.com/questions/5800433/polymorphism-with-gson
    private static class CurrencyIdToNominalValueAdapter implements /*InstanceCreator<Filter>,*/
            JsonSerializer<Set<Filter>>, JsonDeserializer<Set<Filter>> {

        private static final String CLASS_NAME = "className";
        private static final String NAME = "name";
        private static final String CRITERION = "criterion";

//        @Override
//        public Filter createInstance(Type type) {
//            System.out.println(type);
//            return new FilterA("testname", "testcriterion");
//        }

        @Override
        public JsonElement serialize(Set<Filter> src, Type typeOfSrc, JsonSerializationContext context) {
//            List<String> stringList = src.stream()
//                    .map(filter -> filter.toString())
//                    .collect(Collectors.toList());
//
//            System.out.println(src.getClass().getTypeName());
//            System.out.println(src.getClass().getCanonicalName());

            JsonArray array = new JsonArray();
            for(Filter filterObj : src){
                JsonObject object = new JsonObject();
//                object.addProperty(CLASS_NAME, filterObj.getClass().getCanonicalName());
//                object.addProperty(CLASS_NAME, filterObj.getClass().getSimpleName());
//                object.addProperty(CLASS_NAME, filterObj.getClass().getName());
                object.addProperty(CLASS_NAME, filterObj.getClass().getTypeName());
                object.addProperty(NAME, filterObj.getName());
                object.addProperty(CRITERION, filterObj.getCriterion());
                array.add(object);
            }
//            filter.addProperty("name", src.getName());
//            filter.addProperty("criterion", src.getCriterion());
//            filter.addProperty("class", src.getClass().getCanonicalName());
//            System.out.println(filter);
            return array;
        }

        @Override
        public Set<Filter> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {

            Set<Filter> result = new LinkedHashSet<>();

            JsonArray jsonArray = json.getAsJsonArray();
            for(JsonElement jsonElement : jsonArray){
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String className =  jsonObject.get(CLASS_NAME).toString();
                String name =  jsonObject.get(NAME).toString();
                String criterion =  jsonObject.get(CRITERION).toString();

                Class<?> klass = null;
                try{
                    klass = Class.forName(className);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                try {
                    Constructor<?> constructor = klass.getConstructor(String.class, String.class);
                    Filter filterInstance = (Filter) constructor.newInstance(name, criterion);
                    result.add(filterInstance);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                        InvocationTargetException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }


            }

//            final Filter result = null;
//            final Object[] array = context.deserialize(json, multimapTypeToMapType(typeOfT));
//            for (final Object e : array) {
//                result.add((Filter)e);
//            }
            return result;
        }
//
//        private <V> Type multimapTypeToMapType(Type type) {
//            final Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
//            assert typeArguments.length == 2;
//            @SuppressWarnings("unchecked")
//            final TypeToken<Map<Long, Collection<V>>> mapTypeToken = new TypeToken<Map<Long, Collection<V>>>() {}
//                    .where(new TypeParameter<V>() {}, (TypeToken<V>) TypeToken.of(typeArguments[1]));
//            return mapTypeToken.getType();
//        }
        //    private static class CurrencyIdToNominalValueAdapter implements InstanceCreator<Set<Filter>>,
//            JsonSerializer<Set<Filter>>, JsonDeserializer<Set<Filter>> {
//    @Override
//    public Set<Filter> createInstance(Type type) {
//        return new LinkedHashSet<>();
//    }
//
//    @Override
//    public JsonElement serialize(Set<Filter> src, Type typeOfSrc, JsonSerializationContext context) {
//        List<String> stringList = src.stream()
//                .map(filter -> filter.toString())
//                .collect(Collectors.toList());
//
//        return context.serialize(stringList);
//    }
//
//    @Override
//    public Set<Filter> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
//            throws JsonParseException {
//        final Set<Filter> result = new HashSet<>();
//        final Object[] array = context.deserialize(json, multimapTypeToMapType(typeOfT));
//        for (final Object e : array) {
//            result.add((Filter)e);
//        }
//        return result;
//    }
//
//    private <V> Type multimapTypeToMapType(Type type) {
//        final Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
//        assert typeArguments.length == 2;
//        @SuppressWarnings("unchecked")
//        final TypeToken<Map<Long, Collection<V>>> mapTypeToken = new TypeToken<Map<Long, Collection<V>>>() {}
//                .where(new TypeParameter<V>() {}, (TypeToken<V>) TypeToken.of(typeArguments[1]));
//        return mapTypeToken.getType();
//    }
    }
}
