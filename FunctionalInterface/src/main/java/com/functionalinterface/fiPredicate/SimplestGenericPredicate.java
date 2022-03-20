package com.functionalinterface.fiPredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SimplestGenericPredicate {

    public static void main(String [] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strList = Arrays.asList("Tim","Kim","John","a","a","a");

        evaluate(intList, n -> true);

        evaluate(strList, n -> true);
    }

    // public static <T> List<T> removeElements(List<T> list, Predicate<T> pred)
    public static <T> void evaluate(List<T> list, Predicate<T> predicate) {
        for(T num: list) {
            if (predicate.test(num)) {
                System.out.print(num + ",");
            }
        }
        System.out.println();
    }
}
