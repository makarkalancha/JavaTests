package com.everything.java8tests.localdate;

//import fj.data.Stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

//import fj.F; import fj.F2;
//import fj.data.Option;

//import static fj.Function.curry;
//import static fj.data.Option.isSome_;
//import static fj.data.Option.none;
//import static fj.data.Option.some;
//import static fj.data.Stream.stream;
//import static fj.data.Stream.stream;
//import static fj.data.Option.isSome_;

/**
 * Created by mcalancea
 * Date: 18 Apr 2018
 * Time: 11:22
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
//        String timeDate = "2018-04-21T16:45:03Z";
        String timeDate = "2011-12-03T10:15:30Z";
//        String timeDate = "2018-04-21T16:45:03";
//        String timeDate = "2011-12-03T10:15:30";
//        String timeDate = "2018-04-25T16:45:03.000Z";

        String patternISO_LOCAL_DATE_TIME = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";
        String patternISO_DATE_TIME = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        System.out.println(timeDate.matches(patternISO_LOCAL_DATE_TIME));

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

        LocalDateTime localDateTime = LocalDateTime.parse(timeDate, dateTimeFormatter);
//        LocalDateTime localDateTime = LocalDateTime.parse(timeDate);

        System.out.println(localDateTime);

        List<LocalDateTime> localDateTimes = Arrays.asList(
                LocalDateTime.of(LocalDate.of(2018, Month.OCTOBER, 1), LocalTime.of(1, 2, 3)),
                LocalDateTime.of(LocalDate.of(2018, Month.SEPTEMBER, 30), LocalTime.of(19, 2, 3)),
                LocalDateTime.of(LocalDate.of(2018, Month.OCTOBER, 1), LocalTime.of(1, 2, 2)),
                LocalDateTime.of(LocalDate.of(2018, Month.OCTOBER, 1), LocalTime.of(1, 2, 3))
                );
        LocalDateTime maxLocalDateTime = localDateTimes.stream()
                .max(Comparator.naturalOrder())
                .orElse(LocalDateTime.now());
        System.out.println("max:" + maxLocalDateTime);

        List<String> localDateTimesString = Arrays.asList(
                "20181001010203",
                "20180930190203",
                "20181001010204",
                "20181001010203",
                "201810010102",
                null,
                ""
        );
        final DateTimeFormatter TRANSACTION_NUMBER_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        LocalDateTime maxLocalDateTimeOutOfString = localDateTimesString.stream()
                .filter(string -> parseWithPattern(string, TRANSACTION_NUMBER_FORMAT).isPresent())
                .map(string -> LocalDateTime.parse(string, TRANSACTION_NUMBER_FORMAT))
                .max(Comparator.naturalOrder())
                .orElse(LocalDateTime.now());
        System.out.println("max string:" + maxLocalDateTimeOutOfString);

//        String str = "1986-04-08 12:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//        System.out.println(dateTime);


    }

//    F<String, F<String, Option<LocalDateTime>>> parseDate =
//            curry(new F2<String, String, Option<LocalDateTime>>() {
//                public Option<LocalDateTime> f(String pattern, String s) {
//                    try {
//                        return some(LocalDateTime.parse(s, DateTimeFormatter.ofPattern(pattern)));
//                    } catch (DateTimeParseException e) {
//                        return none();
//                    }
//                }
//            });

//    public Option<LocalDateTime> parseWithPatterns(String s, Stream<String> patterns) {
//        return stream(s)
//                .apply(
//                        patterns
//                                .map(parseDate)
//                )
//                .find(isSome_());
//    }

    private static final BiFunction<String, DateTimeFormatter, Optional<LocalDateTime>> PARSE_DATE =
            (string, pattern) ->
                /*public Optional<LocalDateTime> apply(String pattern, String s) */{
                    try {
                        return Optional.of(LocalDateTime.parse(string, pattern));
                    } catch (Exception e) {
                        return Optional.empty();
                    }
//                }
            };

    private static Optional<LocalDateTime> parseWithPattern(String s, final DateTimeFormatter pattern) {
        return PARSE_DATE.apply(s, pattern);
    }
}
