package com.stream.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String [] args)
    {
        /*
             input = "AABCCCDDAAA";
             output = A2B1C3D2A3
             using java 8 streams without traditional condition and loops
         */
        String inString = "aaa";
        System.out.println("");

        //some list simulating your somethingList
        List<Integer> list = List.of(2,4,6,1,3,5);

        String result = list.stream()
                //make sure the stream is sequential to keep processing order
                .sequential()
                //start reduction with an initial value
                .reduce("initial",
                        //in the accumulator you get the previous reduction result and the current element
                        (test, element) -> {
                            //simulates your conditions, just adding the new element for demonstration purposes
                            // test could also be replaced
                            if( element % 2 == 0 ) {
                                test += ", even:" + element;
                            } else {
                                test += ", odd: " + element;
                            }
                            //return the new reduction result
                            return test;
                        },
                        //combiner is not used in sequential streams so just one of the elements
                        (l, r) -> l);

        System.out.println("result = " + result);
        // -----------------------------------------
        // Creating list of integers
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

        // Finding sum of all elements
        int sum = array.stream().reduce(0,
                (element1, element2) -> element1 + element2);

        // Displaying sum of all elements
        System.out.println("The sum of all elements is " + sum);
        // -----------------------------------------

        String inputStr = "AABCCCDDAAA";

        Map<Character, Long> charFrequency = inputStr.chars()
                .mapToObj(c -> (char) c) //Stream<String>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String mapAsString = charFrequency.keySet().stream()
                .map(key -> key.toString() + charFrequency.get(key))
                .collect(Collectors.joining(""));

        Map<Character, Long> charFrequency2 = inputStr.chars()
                .mapToObj(c -> (char) c) //Stream<String>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String singleString = inputStr.chars()
                .mapToObj(c -> (char) c) //Stream<String>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .keySet().stream()
                .map(key -> key.toString() + charFrequency2.get(key))
                .collect(Collectors.joining(""));


        System.out.println( charFrequency ) ;
        System.out.println( mapAsString ) ;

        System.out.println( "singleString = " + singleString ) ;

        // -----------------------------------------

        // sString inputStr = "AABCCCDDAAA";
        char[] ch = inputStr.toCharArray();

//        Stream<Character> characterStream = inputStr.chars()
//                .mapToObj(c -> (char) c)
//                .reduce(0, (el1, el2) -> {
//                            //simulates your conditions, just adding the new element for demonstration purposes
//                            // test could also be replaced
//                            if ( el1.equals(el2) ) {
//                                test += ", even:" + element;
//                            } else {
//                                test += ", odd: " + element;
//                            }
//                            //return the new reduction result
//                            return test;
//                        },
//                        //combiner is not used in sequential streams so just one of the elements
//                        (l, r) -> l);


        List<String> words = Arrays.asList("Welcome", "to", "the", "java", "world");
        Map<Character, Long> charFrequency1 = words.stream() //Stream<String>
                .flatMap(a -> a.chars().mapToObj(c -> (char) c)) // Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println( charFrequency1 ) ;

        System.out.println("******************************************************************************************");

        String perfect_solution = inputStr.chars()
                .mapToObj(c -> (char) c) //Stream<String>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().map((entry) -> entry.getKey() + entry.getValue().toString()) //stream each entry, map it to string value
                .collect(Collectors.joining("")); //and 'collect' or put them together by joining

        System.out.println( "perfect_solution = " + perfect_solution ) ;

        System.out.println("*****************************************************************************************");
    }


}

