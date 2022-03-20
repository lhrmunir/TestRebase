package com.stream.sorting.mkyong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApplication {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");

        /* 
        List<String> sortedList = list.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
            
        List<String> sortedList = list.stream()
            .sorted((o1,o2)-> o1.compareTo(o2))
            .collect(Collectors.toList());
        */
        
        System.out.println("------------------------------- DEMO STREAM SORTING ---------------------------------------");

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        
        sortedList.forEach(System.out::println);
        
        
        /*
        List<String> sortedList = list.stream()
            .sorted((o1,o2)-> o2.compareTo(o1))
            .collect(Collectors.toList());
        */
        System.out.println("------------------------------- DEMO STREAM REVERSE SORTING ---------------------------------------");
        
        List<String> sortedListReverse = list.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        sortedListReverse.forEach(System.out::println);

    }
}
