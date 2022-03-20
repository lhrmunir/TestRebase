package com.stream.misc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMapDifference {

    public static void main(String [] args) {

        Optional<String> optionalStr = Optional.of("test");

        // assertEquals(Optional.of("TEST"), optionalStr.map(String::toUpperCase));

        System.out.println("Optional.of(\"TEST\") = " + Optional.of("TEST"));

        System.out.println("optionalStr.map(String::toUpperCase) = " + optionalStr.map(String::toUpperCase));
        /*   ---------------  */

        // assertEquals(Optional.of(Optional.of("STRING")), Optional.of("string").map(s -> Optional.of("STRING")));
        System.out.println("Optional.of(Optional.of(\"STRING\")) " + Optional.of(Optional.of("STRING")));
        System.out.println("Optional.of(\"string\").map(s -> Optional.of(\"STRING\")) = " + Optional.of("string").map(s -> Optional.of("STRING")));
        /* ----------------- */

        // assertEquals(Optional.of("STRING"), Optional.of("string").flatMap(s -> Optional.of("STRING")));
        System.out.println("Optional.of(\"STRING\") = " + Optional.of("STRING"));
        System.out.println("Optional.of(\"string\").flatMap(s -> Optional.of(\"STRING\")) = " + Optional.of("string").flatMap(s -> Optional.of("STRING")));
        /* ----------------- */
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("myList = " + myList);
        // assertEquals(asList("A", "B"), myList);

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println("list = " + list);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

    }
}
