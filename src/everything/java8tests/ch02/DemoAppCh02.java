package everything.java8tests.ch02;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import everything.java8tests.ch01.Student;
import org.jsoup.select.Collector;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * User: Makar Kalancha
 * Date: 02/02/2015
 * Time: 15:02
 */
public class DemoAppCh02 {
    public static void main(String[] args)  throws IOException {
        System.out.println("func#001 2.1");
        DemoAppCh02.func001();
//
//        System.out.println("func#002 2.2");
//        DemoAppCh02.func002();
//
//        //infinite
////        System.out.println("func#003 2.2: infinite streams");
////        DemoAppCh02.func003();
//
//        //infinite
////        System.out.println("func#004 2.2: iterate streams");
////        DemoAppCh02.func004();
//
//        System.out.println("func#005 2.2: pattern streams");
//        DemoAppCh02.func005();
//
//        System.out.println("func#006 2.2: lines auto close streams");
//        DemoAppCh02.func006();
//
//        System.out.println("func#007 2.3: list streams");
//        DemoAppCh02.func007();
//
//        System.out.println("func#008 2.3: lower case streams");
//        DemoAppCh02.func008();
//
//        System.out.println("func#009 2.3: first character streams");
//        DemoAppCh02.func009();
//
//        System.out.println("func#010 2.3: character streams");
//        DemoAppCh02.func010();
//
//        System.out.println("func#011 2.4: infinite streams with limit");
//        DemoAppCh02.func011();
//
//        System.out.println("func#012 2.4: skip 2 streams");
//        DemoAppCh02.func012();
//
//        System.out.println("func#013 2.4: concat streams");
//        DemoAppCh02.func013();
//
//        System.out.println("func#014 2.4: peek streams");
//        DemoAppCh02.func014();
//
//        System.out.println("func#015 2.5: distinct");
//        DemoAppCh02.func015();
//
//        System.out.println("func#016 2.5: comparator");
//        DemoAppCh02.func016();

//        //reduction operations: count, max
//        System.out.println("func#017 2.6: reductions");
//        DemoAppCh02.func017();

//        System.out.println("func#018 2.6: find first with M");
//        DemoAppCh02.func018();

//        System.out.println("func#019 2.6: find any with M");
//        DemoAppCh02.func019();

//        System.out.println("func#020 2.6: it there a match with Q");
//        DemoAppCh02.func020();

//        System.out.println("func#021 2.6: all / none match");
//        DemoAppCh02.func021();

//        System.out.println("func#022 2.7.1: Optional->ifPresent");
//        DemoAppCh02.func022();

//        System.out.println("func#023 2.7.1: Optional->map");
//        DemoAppCh02.func023();

//        System.out.println("func#024 2.7.1: Optional->orElse");
//        DemoAppCh02.func024();

//        System.out.println("func#025 2.7.1: Optional->orElseGet");
//        DemoAppCh02.func025();

//        System.out.println("func#026 2.7.1: Optional->orException");
//        DemoAppCh02.func026();

//        System.out.println("func#027 2.7.2: Optional create");
//        DemoAppCh02.func027();

//        System.out.println("func#028 2.7.3: Optional composing");
//        DemoAppCh02.func028();

//        System.out.println("func#029 2.8: Reduce");
//        DemoAppCh02.func029();

//        System.out.println("func#030 2.8: Reduce with identity");
//        DemoAppCh02.func030();

//        System.out.println("func#031 2.8: Reduce accumulator function");
//        DemoAppCh02.func031();

//        System.out.println("func#032 2.9: to array");
//        DemoAppCh02.func032();

//        System.out.println("func#033 2.9: collect");
//        DemoAppCh02.func033();
//
//        System.out.println("func#034 2.9: collect in stringBuilder");
//        DemoAppCh02.func034();

//        System.out.println("func#035 2.9: collector");
//        DemoAppCh02.func035();

//        System.out.println("func#036 2.9: collector joining");
//        DemoAppCh02.func036();

//        System.out.println("func#037 2.9: collector joining objects");
//        DemoAppCh02.func037();

//        System.out.println("func#038 2.9: average student age and summary statistics");
//        DemoAppCh02.func038();

//        System.out.println("func#039 2.10: students in map");
//        DemoAppCh02.func039();

//        System.out.println("func#040 2.10: locale");
//        DemoAppCh02.func040();

//        System.out.println("func#041 2.10: locale in every country");
//        DemoAppCh02.func041();

//        System.out.println("func#042 2.10: students in tree map");
//        DemoAppCh02.func042();

//        System.out.println("func#043 2.11: grouping locales by country");
//        DemoAppCh02.func043();

//        System.out.println("func#044 2.11: partitioning locales by country");
//        DemoAppCh02.func044();

//        System.out.println("func#045 2.11: grouping locales by country put in set");
//        DemoAppCh02.func045();

//        System.out.println("func#046 2.11: count");
//        DemoAppCh02.func046();

//        System.out.println("func#047 2.11: sum, min, max province population");
//        DemoAppCh02.func047();

//        System.out.println("func#048 2.11: country to language");
//        DemoAppCh02.func048();

//        System.out.println("func#049 2.11: city population stats");
//        DemoAppCh02.func049();

//        System.out.println("func#050 2.11: province to city names");
//        DemoAppCh02.func050();

//        System.out.println("func#051 2.12: streams of primitives");
//        DemoAppCh02.func051();

//        System.out.println("func#052 2.12: chars");
//        DemoAppCh02.func052();

//        System.out.println("func#053 2.12: string length");
//        DemoAppCh02.func053();

//        System.out.println("func#054 2.12: boxind primites");
//        DemoAppCh02.func054();

//        System.out.println("func#055 2.12: random");
//        DemoAppCh02.func055();

//        System.out.println("func#056 2.13: parallel");
//        DemoAppCh02.func056();

//        System.out.println("func#057 2.13: parallel cities");
//        DemoAppCh02.func057();

    }

    public static void func057() {
        Map<String, List<String>> result = getCityList().
                stream().
//                parallel().
                collect(
                        Collectors.groupingByConcurrent(City::getProvince,
                                Collectors.mapping(City::getCityName,Collectors.toList())
                                )
                );
        result.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void func056() throws IOException{
        func001();

        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        List<String> words = Arrays.asList(content.split("[\\P{L}]+"));

        //Error—race condition!
        //sometimes: elemnt[2]=18; [0, 4, 18, 13, 22, 10, 5, 11, 4, 4, 4, 0]
        System.out.println("\nless 12 (Error—race condition!)");
        int[] shortWords = new int[12];
        words.stream().
                parallel().
                forEach(s->{
                    if(s.length() < 12 ) {
                        shortWords[s.length()]++;
                    }
                });
        System.out.println(Arrays.toString(shortWords));
        //elemnt[2]=19; [0, 4, 19, 13, 22, 10, 5, 11, 4, 4, 4, 0]
        System.out.println("less 12 (NO—race condition!)");
        AtomicIntegerArray shortWordsInAtomicInt = new AtomicIntegerArray(12);
        words.stream().
                parallel().
                forEach(s->{
                    if(s.length() < 12 ) {
                        shortWordsInAtomicInt.getAndAdd(s.length(),1);
                    }
                });
        System.out.println(shortWordsInAtomicInt);
    }

    public static void func055() {
        Random random = new Random();
        IntStream randomIntStream = random.ints(5, 1, 25);
        String string = randomIntStream.
                mapToObj(Integer::toString).
                collect(Collectors.joining(", "));
        System.out.println(string);
    }

    public static void func054() {
        Stream<Integer> integerStream = IntStream.range(0, 5).boxed();
        integerStream.forEach(str -> System.out.println(str + "\t->\t" + Integer.toBinaryString(str)));

    }

    public static void func053() {
        Stream<String> stringStream = Stream.of("put", "me", "in", "A", "LIST");
        IntStream intStream = stringStream.mapToInt(String::length);
        intStream.forEach(System.out::println);
    }

    public static void func052() {
        String sentence = "\uD835\uDD46 is the set of octonions.";
        IntStream intStream = sentence.codePoints();
        String string = intStream.
                mapToObj(Integer::toHexString).
                collect(Collectors.joining(", "));
        System.out.println(string);
    }

    public static void func051() {
        System.out.println("--stream");
        IntStream intStream = IntStream.of(1, 1, 2, 3, 5);
//        intStream.forEach(System.out::println);
//        System.out.println("sum:"+intStream.sum());
//        System.out.println("min:"+intStream.min());
//        System.out.println("max:"+intStream.max());
        System.out.println(intStream.summaryStatistics());

        System.out.println("--stream upper bound is excluded");
        IntStream intStreamExcluded = IntStream.range(0,5);
        intStreamExcluded.forEach(System.out::println);

        System.out.println("--stream upper bound is included");
        IntStream intStreamIncluded = IntStream.rangeClosed(0,5);
        intStreamIncluded.forEach(System.out::println);
    }

    public static void func050() {
        Map<String, String> provinceToCityNames1 = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince,
                                Collectors.reducing("",
                                        City::getCityName,
                                        (s,t) -> s.length() == 0 ? t : s+", "+t
                                )
                        )
                );
        System.out.println("--version 1");
        provinceToCityNames1.forEach((k, v) -> System.out.println(k + " = " + v));


        Map<String, String> provinceToCityNames2 = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince,
                                Collectors.mapping(City::getCityName,
                                        Collectors.joining(", ")
                                )
                        )
                );
        System.out.println("--version 2");
        provinceToCityNames2.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void func049() {
        Map<String, IntSummaryStatistics> provinceToCityPopulationSummary = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince,
                                Collectors.summarizingInt(City::getPopulation)
                        )
                );
        System.out.println("STATISTICS:");
        provinceToCityPopulationSummary.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void func048() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguage = localeStream.collect(
                Collectors.groupingBy(l->l.getDisplayCountry(Locale.ENGLISH),
                        Collectors.mapping(l->l.getDisplayLanguage(Locale.ENGLISH),
                                Collectors.toSet()
                            )
                        )
        );
        countryToLanguage.forEach((k,v)->System.out.println(k+"-->"+v));
    }

    public static void func047() {
        Map<String, Integer> provinceToCityPopulation = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince, TreeMap::new, Collectors.summingInt(City::getPopulation))
                );
        System.out.println("--sum:");
        provinceToCityPopulation.forEach((k, v) -> System.out.println(k + " = " + v));

        Map<String, City> maxToCityPopulation = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(City::getPopulation)),
                                        c -> c.get()
                                )
                        )
                );
        System.out.println("--max:");
        maxToCityPopulation.forEach((k, v) -> System.out.println(k + " = " + v));

        Map<String, City> minToCityPopulation = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(Comparator.comparing(City::getPopulation)),
                                        c -> c.get()
                                )
                        )
                );
        System.out.println("--min:");
        minToCityPopulation.forEach((k, v) -> System.out.println(k + " = " + v));

        Map<String, Optional<String>> provinceToLongestCityName = getCityList().stream().
                collect(
                        Collectors.groupingBy(City::getProvince,
                                Collectors.mapping(City::getCityName,
                                        Collectors.maxBy(Comparator.comparing(String::length))
                                )
                        )
                );
        System.out.println("--longest name:");
        provinceToLongestCityName.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static List<City> getCityList() {
        City cityOfToronto = new City("Toronto", "Ontario", 5583064);
        City cityOfMontreal = new City("Montreal", "Quebec", 3824221);
        City cityOfVancouver = new City("Vancouver","British Columbia",2313328);
        City cityOfOttawa = new City("Ottawa–Gatineau","Ontario–Quebec",1236324);
        City cityOfCalgary = new City("Calgary","Alberta",1214839);
        City cityOfEdmonton = new City("Edmonton","Alberta",1159869);
        City cityOfQuebec = new City("Quebec","Quebec",765706);
        City cityOfWinnipeg = new City("Winnipeg","Manitoba",730018);
        City cityOfHamilton = new City("Hamilton","Ontario",721053);
        City cityOfKitchener = new City("Kitchener–Cambridge–Waterloo","Ontario",477160);
        City cityOfLondon = new City("London","Ontario",474786);
        City cityOfCatharinesNiagara = new City("St. Catharines–Niagara","Ontario",392184);
        City cityOfHalifax = new City("Halifax","Nova Scotia",390328);
        City cityOfOshawa = new City("Oshawa","Ontario",356177);
        City cityOfVictoria = new City("Victoria","British Columbia",344615);
        City cityOfWindsor = new City("Windsor","Ontario",319246);
        City cityOfSaskatoon = new City("Saskatoon","Saskatchewan",260600);
        City cityOfRegina = new City("Regina","Saskatchewan",210556);
        City cityOfSherbrooke = new City("Sherbrooke","Quebec",201890);
        City cityOfStJohns = new City("St. John's","Newfoundland and Labrador",196966);
        return Arrays.asList(cityOfToronto, cityOfMontreal, cityOfVancouver, cityOfOttawa, cityOfCalgary,
                cityOfEdmonton, cityOfQuebec, cityOfWinnipeg, cityOfHamilton, cityOfKitchener, cityOfLondon,
                cityOfCatharinesNiagara, cityOfHalifax, cityOfOshawa, cityOfVictoria, cityOfWindsor, cityOfSaskatoon,
                cityOfRegina, cityOfSherbrooke, cityOfStJohns);
    }

    public static void func046() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocales = localeStream.collect(
                Collectors.groupingBy(Locale::getDisplayCountry, Collectors.counting()
            ));
        countryToLocales.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void func045() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocales = localeStream.collect(
                Collectors.groupingBy(Locale::getDisplayCountry, Collectors.toSet()));
        countryToLocales.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void func044() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = localeStream.collect(
            Collectors.partitioningBy(
                    l->l.getLanguage().equals("en")
            )
        );
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        System.out.println("---englishAndOtherLocales");
        englishAndOtherLocales.forEach((k, v) -> System.out.println(k + " = " + v));
        System.out.println("---englishLocales");
        englishLocales.forEach(System.out::println);
    }

    public static void func043() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = localeStream.collect(
                Collectors.groupingBy(Locale::getDisplayCountry));
        countryToLocales.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public static void func042() {
        Student studentA = new Student(1, "A");
        studentA.setAge(17);
        Student studentB = new Student(2, "B");
        studentB.setAge(20);
        Student studentC = new Student(3, "C");
        studentC.setAge(21);
        Student studentD = new Student(4, "D");
        studentD.setAge(19);

        Map<Long, Student> map = Stream.of(studentA, studentB, studentC, studentD).
                collect(Collectors.toMap(
                                Student::getId,
                                Function.<Student>identity(),
                                (existingValue, newValue) -> {throw new IllegalStateException();},
                                TreeMap::new
                        )
                );

        map.forEach((k,v)-> System.out.println(k+" = "+v));

    }

    public static void func041() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = localeStream.collect(
                Collectors.toMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage(Locale.ENGLISH)),
                        (existingSet,newSet)-> { //Union of a and b
                            Set<String> r = new HashSet<>(existingSet);
                            r.addAll(newSet);
                            return r;
                        }
                )
        );
        countryLanguageSets.forEach((k, v) -> System.out.println(k + " = " + v));
    }
    
    public static void func040() {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = localeStream.collect(
                Collectors.toMap(
                        l -> l.getDisplayLanguage(),
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue
                )
        );
        languageNames.forEach((k,v)-> System.out.println(k+" = "+v));
    }

    public static void func039() {
        Student studentA = new Student(1, "A");
        studentA.setAge(17);
        Student studentB = new Student(2, "B");
        studentB.setAge(20);
        Student studentC = new Student(3, "C");
        studentC.setAge(21);
        Student studentD = new Student(4, "D");
        studentD.setAge(19);

//        Map<Long, String> map = Stream.of(studentA, studentB, studentC, studentD).
//                parallel().
//                collect(Collectors.toMap(Student::getId, Student::getName));

        //objects
        Map<Long, Student> map = Stream.of(studentA, studentB, studentC, studentD).
                parallel().
                collect(Collectors.toMap(Student::getId, Function.<Student>identity()));

        map.forEach((k,v)-> System.out.println(k+" = "+v));

    }

    public static void func038() {
        Student studentA = new Student(1, "A");
        studentA.setAge(17);
        Student studentB = new Student(2, "B");
        studentB.setAge(20);
        Student studentC = new Student(3, "C");
        studentC.setAge(21);
        Student studentD = new Student(4, "D");
        studentD.setAge(19);

        List<Student> studentList = Arrays.asList(studentA, studentB, studentC, studentD);
        double avg = studentList.
                parallelStream().
                mapToDouble(student -> student.getAge()).
                average().
                getAsDouble();
        System.out.println(avg);

        DoubleSummaryStatistics doubleSummaryStatistics = studentList.
                parallelStream().
                mapToDouble(student -> student.getAge()).
                summaryStatistics();
        System.out.println("avg:"+doubleSummaryStatistics.getAverage());
        System.out.println("qty:"+doubleSummaryStatistics.getCount());
        System.out.println("max:"+doubleSummaryStatistics.getMax());
        System.out.println("min:"+doubleSummaryStatistics.getMin());
        System.out.println("sum:"+doubleSummaryStatistics.getSum());
    }

    public static void func037() {
        Student studentA = new Student(1, "A");
        studentA.setAge(17);
        Student studentB = new Student(2, "B");
        studentB.setAge(20);
        Student studentC = new Student(3, "C");
        studentC.setAge(21);
        Student studentD = new Student(4, "D");
        studentD.setAge(19);

        String string = Stream.of(studentA, studentB, studentC, studentD).
                parallel().
                map(Object::toString).
                collect(Collectors.joining("\r\n"));

        System.out.println(">" + string + "<");
    }

    public static void func036() {
        String string = Stream.of("add", "me", "To", "THE", "list").
//                parallel().
                collect(Collectors.joining(", "));
        System.out.println(">" + string + "<");
    }

    public static void func035() {
        Set<String> strings = Stream.of("add","me","To","THE","list").
                collect(Collectors.toSet());
        strings.forEach(System.out::println);

        System.out.println("\ntreeset:");
        TreeSet<String> treeSet = Stream.of("add","me","To","THE","list").
                collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);
    }

    public static void func034() {
        StringBuilder stringBuilder = Stream.of("add","me","To","THE","list").
                collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
        System.out.println(stringBuilder);
    }
//    reduce is a "fold" operation, it applies a binary operator to each element in the stream where the
//    fist argument to the operator in the return value of the previous application and the second argument
//    is the current stream element.
//
//    collection is an aggregation operation where a "collection" is created and each element is "added"
//    to that collection. Collections in different parts of the stream are then added together.
    public static void func033() {
        HashSet<String> strings = Stream.of("add","me","To","THE","list").
                collect(HashSet::new, HashSet::add, HashSet::addAll);
        strings.forEach(System.out::println);
    }

    public static void func032() {
        Object[] strings = Stream.of("add","me","To","THE","list").
                toArray();
//        String[] strings = Stream.of("add","me","To","THE","list").
//                toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }

    public static void func031() {
        Integer sum = Stream.of("add","me","To","THE","list").
                reduce(0,
                        (total, word) -> total + word.length(),
                        (total1, total2) -> total1 + total2
                );
        System.out.println(sum);

        Integer sum1 = Stream.of("add","me","To","THE","list").
                mapToInt(String::length).sum();
        System.out.println(sum1);
    }

    public static void func030() {
//        Stream<Integer> stream = Stream.of(3, 5, 6, 10);
        Stream<Integer> stream = Stream.empty();
        ////v0 op v1 op v2 op . . .
        ////(x op y) op z = x op (y op z).
        ////(6 + 3) + 2 = 6 + (3 + 2).
        ////not suitable for reduce function (6 − 3) − 2 ≠ 6 − (3 − 2).
        Integer sum = stream.reduce(0,(x, y) -> x + y);
        System.out.println(sum);
    }

    public static void func029() {
//        Stream<Integer> stream = Stream.of(3, 5, 6, 10);
        Stream<Integer> stream = Stream.empty();
        ////v0 op v1 op v2 op . . .
        ////(x op y) op z = x op (y op z).
        ////(6 + 3) + 2 = 6 + (3 + 2).
        ////not suitable for reduce function (6 − 3) − 2 ≠ 6 − (3 − 2).
//        Optional<Integer> sum = stream.reduce((x, y) -> x + y);
        Optional<Integer> sum = stream.reduce(Integer::sum);
        System.out.println(sum.orElse(1000000000));
    }

    public static void func028() {
        System.out.println(inverse(0d).flatMap(DemoAppCh02::squareRoot));
        System.out.println(inverse(2d).flatMap(DemoAppCh02::squareRoot));
        System.out.println();
        System.out.println(Optional.of(-4d).flatMap(DemoAppCh02::inverse).flatMap(DemoAppCh02::squareRoot));
        System.out.println(Optional.of(9d).flatMap(DemoAppCh02::inverse).flatMap(DemoAppCh02::squareRoot));
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.<Double>empty() : Optional.of(Math.sqrt(x));
    }

    public static void func027() throws IOException {
        System.out.println(inverse(0d).orElse(-1d));
        System.out.println(inverse(2d));
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.<Double>empty() : Optional.of(1 / x);
//        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static void func026() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("M")).findAny(); //added
//        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("Q")).findAny(); //not added
        String string = startsWithM.orElseThrow(NoSuchElementException::new);
        System.out.println(string);
    }

    public static void func025() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

//        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("M")).findAny(); //added
        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("Q")).findAny(); //not added
        String string = startsWithM.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println(string);
    }

    public static void func024() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("M")).findAny(); //added
//        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("Q")).findAny(); //not added
        String string = startsWithM.orElse("bazinga");
        System.out.println(string);
    }

    public static void func023() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

//        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("M")).findAny(); //added
        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("Q")).findAny(); //not added
        List<String> match = new ArrayList<>();
        Optional<Boolean> isAdded = startsWithM.map(match::add);
        match.forEach(System.out::println);
        System.out.println("was added? "+isAdded);
    }

    public static void func022() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("M")).findAny();
//        if(startsWithM.isPresent()){
//            System.out.println("starts with M: " + startsWithM.get());
//        }
////        or
        startsWithM.ifPresent( s -> System.out.println("starts with M: " + s));

        List<String> match = new ArrayList<>();
        startsWithM.ifPresent(match::add);
        match.forEach(System.out::println);
    }

    public static void func021() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        List<String> wordList = words.parallel().collect(Collectors.toList());
//        List<String> wordList = new ArrayList<>();
//        wordList.add("Qadsf");
//        wordList.add("Qadsf");
//        wordList.add("Qadsf");

        boolean isAllMatch = wordList.stream().parallel().allMatch(s -> s.startsWith("Q"));
        boolean isNoneMatch = wordList.stream().parallel().noneMatch(s -> s.startsWith("Q"));
        System.out.println("is all match with Q: " + isAllMatch);
        System.out.println("is none match with Q: " + isNoneMatch);
    }

    public static void func020() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        boolean isThereAMatch = words.parallel().anyMatch(s -> s.startsWith("Q"));
        System.out.println("is there a match with Q: " + isThereAMatch);
    }

    public static void func019() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        Optional<String> startsWithM = words.parallel().filter(s -> s.startsWith("M")).findAny();
        if(startsWithM.isPresent()){
            System.out.println("starts with M: " + startsWithM.get());
        }
    }

    public static void func018() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        Optional<String> startsWithM = words.filter(s->s.startsWith("M")).findFirst();
        if(startsWithM.isPresent()){
            System.out.println("starts with M: " + startsWithM.get());
        }
    }

    public static void func017() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);
        Stream<String> words = Stream.of("aa","z");

        //"a" < "zz", byte code of string
        List<String> largestList = words.sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        largestList.forEach(System.out::println);

        Optional<String> largest = largestList.stream().max(String::compareToIgnoreCase);
        if(largest.isPresent()){
            System.out.println("largest: "+largest.get());
        }
    }

    public static void func016() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);

        Stream<String> longestFirst = words.sorted(Comparator.comparing(String::length).reversed());
        longestFirst.forEach(System.out::println);
    }

    public static void func015() {
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        uniqueWords.forEach(System.out::println);
    }

    public static void func014() {
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray();
        System.out.println(Arrays.toString(powers));
    }

    public static void func013() {
        Stream<Character> characterStream = Stream.concat(characterStream("hello"),characterStream("world"));
        characterStream.forEach(System.out::println);
    }

    public static void func012() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> stream = wordList.stream().skip(2);
        stream.forEach(System.out::println);
    }

    public static void func011() {
        System.out.println("random from 7 to 22");
        Stream<Integer> stream = Stream.generate(() -> (int)(Math.random() * 20 + 7)).limit(10);
        stream.forEach(System.out::println);
    }

    public static void func010() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        System.out.println("stream of stream:");
        System.out.println("[... ['y', 'o', 'u', 'r'], ['b', 'o', 'a', 't'],...]");
        Stream<Stream<Character>> characterStream = wordList.stream().map(w -> characterStream(w));
        characterStream.forEach(stream -> stream.forEach(System.out::println));

        System.out.println("\nflat map:");
        System.out.println("[... 'y', 'o', 'u', 'r', 'b', 'o', 'a','t', ...]");
        Stream<Character> characterStream1 = wordList.stream().flatMap(w -> characterStream(w));
        characterStream1.forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for(char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }


    public static void func009() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> wordStream = wordList.stream();
        Stream<Character> charAtWordStream = wordStream.map(s -> s.charAt(0));
        charAtWordStream.forEach(System.out::println);
    }

    public static void func008() {
        List<String> wordList = new ArrayList<>();
        wordList.add("ADD");
        wordList.add("me");
        wordList.add("TO");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> wordStream = wordList.stream();

        Stream<String> lowerCaseWordStream = wordStream.map(String::toLowerCase);
        lowerCaseWordStream.forEach(System.out::println);
    }

    public static void func007() {
        List<String> wordList = new ArrayList<>();
        wordList.add("add");
        wordList.add("me");
        wordList.add("to");
        wordList.add("your");
        wordList.add("LIST");

        Stream<String> wordStream = wordList.stream();
//        wordStream.forEach(System.out::println);

        Stream<String> longWordStream = wordStream.filter(w -> w.length() > 2);
        longWordStream.forEach(System.out::println);
    }

    public static void func006() throws IOException {
        try(Stream<String> lines = Files.lines(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java"))){
            lines.forEach(System.out::println);
        }
    }

    public static void func005() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(content);
        words.forEach(System.out::println);
    }

    public static void func004() {
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        integers.forEach(System.out::println);
    }

    public static void func003() {
        Stream<String> stream1 = Stream.generate(() -> "echo");
//        stream1.forEach(System.out::println);

        Stream<Double> stream2 = Stream.generate(Math::random);
//        stream2.forEach(System.out::println);
    }

    public static void func002() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        Stream<String> words1 = Stream.of(content.split("[\\P{L}]+"));
        System.out.println("words1:");
        words1.forEach(System.out::println);

        Stream<String> words2 = Stream.of("gently","down","the","stream");
        System.out.println("\nwords2:");
        words2.forEach(System.out::println);

    }

    public static void func001() throws IOException{
        String content = new String(Files.readAllBytes(Paths.get("D:\\SRC\\Java_work_dir\\test\\src\\everything\\java8tests\\Demo.java")), StandardCharsets.UTF_8);
//        http://www.regular-expressions.info/unicode.html
//        In addition to complications, Unicode also brings new possibilities.
// One is that each Unicode character belongs to a certain category.
// You can match a single character belonging to the "letter" category with \p{L}.
// You can match a single character not belonging to that category with \P{L}.
        List<String> words = Arrays.asList(content.split("[\\P{L}]+"));

        System.out.println("java prior version 8");
        int countFilter = 0;
        int countAll = 0;
        for(String word : words){
            if(word.length()>12) {
                System.out.println(word);
                countFilter++;
            }
            countAll++;
        }
        System.out.println("count, length > 12:"+countFilter);
        System.out.println("count all:"+countAll);

        System.out.println("\njava 8");
        long countFilterJava8 = words.stream().filter(w -> w.length() > 12).count();
        words.stream().filter(w -> w.length() > 12).forEach(System.out::println);
        System.out.println("count, length > 12:"+countFilterJava8);

        long countFilterParallel=words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println("\nparallel stream, count, length > 12:"+countFilterParallel);
    }
}
