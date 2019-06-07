/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
public class MapListTest {


    public static void main(String[] args) {
        Person friend101 = new Person(101L, "friend101", new ArrayList<>());
        Person friend102 = new Person(102L, "friend102", new ArrayList<>());
        Person friend103 = new Person(103L, "friend103", new ArrayList<>());
        Person john1 = new Person(1000L, "John", Arrays.asList(friend101, friend102, friend103));
        Person friend104 = new Person(104L, "friend104", new ArrayList<>());
        Person friend105 = new Person(105L, "friend105", new ArrayList<>());
        Person friend106 = new Person(106L, "friend106", new ArrayList<>());
        Person john2 = new Person(1000L, "John", Arrays.asList(friend104, friend105, friend106));


        Person friend210 = new Person(210L, "friend210", new ArrayList<>());
        Person friend220 = new Person(220L, "friend220", new ArrayList<>());
        Person friend230 = new Person(230L, "friend230", new ArrayList<>());
        Person jack = new Person(2000L, "Jack", Arrays.asList(friend210, friend220, friend230));

        List<Person> page1 = Arrays.asList(john1, jack, john2);

        Person friend107 = new Person(107L, "friend107", new ArrayList<>());
        Person friend108 = new Person(108L, "friend108", new ArrayList<>());
        Person friend109 = new Person(109L, "friend109", new ArrayList<>());
        Person john3 = new Person(1000L, "John", Arrays.asList(friend107, friend108, friend109));
        Person friend310 = new Person(310L, "friend310", new ArrayList<>());
        Person friend320 = new Person(320L, "friend320", new ArrayList<>());
        Person friend330 = new Person(330L, "friend330", new ArrayList<>());
        Person marie = new Person(3000L, "Marie", Arrays.asList(friend310, friend320, friend330));


        Person friend410 = new Person(410L, "friend410", new ArrayList<>());
        Person friend411= new Person(411L, "friend411", new ArrayList<>());
        Person friend412 = new Person(412L, "friend412", new ArrayList<>());
        Person jessica = new Person(4000L, "Jessica", Arrays.asList(friend410, friend411, friend412));

        List<Person> page2 = Arrays.asList(john3, marie, jessica);

////        Map<Long, Person> map1 = guys.stream()
////                .collect(Collectors.toMap(Person::getId, Function.identity()));
//        Map<Long, Person> map1 = new HashMap<>();
//        for(Person guy : guys){
//            Person tmp = map1.get(guy.id);
//            if(tmp == null){
//                map1.put(guy.id, new Person(guy));
//            }else {
//                List<Person> friendList = new ArrayList<>(tmp.friends);
//                friendList.addAll(guy.friends);
//                Set<Person> friends = new TreeSet<>(friendList);
//                tmp = new Person(tmp.id, tmp.name, new ArrayList<>(friends));
//                map1.put(tmp.id, tmp);
//            }
//        }
//        System.out.println(map1);
//
//        Multimap<Long, Person> guyFriendsMap = guys.stream()
//                .collect(Collector.of(
//                        ArrayListMultimap::create,
//                        (multimap, s) ->  {
//                            Person tmp = s;
//
//                            multimap.put(s.id, s);
//                        },
//                        (multimap1, multimap2) -> {
//                            multimap1.putAll(multimap2);
//                            return multimap1;
//                        }
//
//                ));
//        System.out.println(guyFriendsMap);

//        Map<Long, Person> guyFriendsMap1 = page1.stream()
//                .collect(Collector.of(
//                        HashMap::new,
//                        (multimap, s) ->  {
//                            Person tmp = multimap.get(s.id);
//                            if(tmp == null) {
//                                multimap.put(s.id, s);
//                            }else {
//                                List<Person> friendList = new ArrayList<>(tmp.friends);
//                                friendList.addAll(s.friends);
//                                Set<Person> friends = new TreeSet<>(friendList);
//                                tmp = new Person(tmp.id, tmp.name, new ArrayList<>(friends));
//                                multimap.put(tmp.id, tmp);
//                            }
//                        },
//                        (multimap1, multimap2) -> {
//                            multimap1.putAll(multimap2);
//                            return multimap1;
//                        }
//
//                ));
//        System.out.println(guyFriendsMap1);
//        Map<Long, Person> map2 = new HashMap<>();
//        guysMap.forEach((k, v) -> map2.merge(k,v, (v1, v2) -> {
//            v1.friends.addAll(v2.friends);
//            return v1;
//        }));
//        System.out.println(map2);

        List<List<Person>> lists = Arrays.asList(page1, page2);
        System.out.println(lists.stream().flatMap(l1 -> l1.stream()).count());
//        Map<Long, Person> guyFriendsMap3 = new HashMap<>();
//        for(List<Person> page : lists){
//            guyFriendsMap3.putAll(page.stream()
//                    .collect(Collector.of(
//                        HashMap::new,
//                        (map, person) ->{
//                            Person tmp = map.get(person.id);
//                            if(tmp == null) {
//                                map.put(person.id, person);
//                            }else {
//                                List<Person> friendList = new ArrayList<>(tmp.friends);
//                                friendList.addAll(person.friends);
//                                Set<Person> friends = new TreeSet<>(friendList);
//                                tmp = new Person(tmp.id, tmp.name, new ArrayList<>(friends));
//                                map.put(tmp.id, tmp);
//                            }
//                        },
//                        (map1, map2) -> {
//                            map1.putAll(map2);
//                            return map1;
//                        }
//                    )));
//        }
//
//        System.out.println(guyFriendsMap3);
    }

    private static class Person implements Comparable<Person> {

        private final Long id;
        private final String name;
        private final List<Person> friends;

        public Person(Long id, String name, List<Person> friends) {
            this.id = id;
            this.name = name;
            this.friends = friends;
        }

        public Person(Person person) {
            this.id = person.id;
            this.name = person.name;
            this.friends = person.friends;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Person> getFriends() {
            return friends;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", friends=" + friends +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            return this.id.compareTo(o.id);
        }
    }
}
