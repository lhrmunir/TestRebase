package com.methodreference.advancedArpitMedium;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferecesLambdaExpressionMain {

    public static void main(String args[])
    {
        List<String> countryList = Arrays.asList(new String[] {"India", "China","Nepal","Russia"});

        System.out.println("=======================");
        System.out.println("Using anonymous class");
        System.out.println("=======================");

        // Using anonymous class
        countryList.stream().forEach(

                new Consumer<String>() {
                    @Override
                    public void accept(String country) {
                        System.out.println(country);
                    }
                });

        System.out.println("=======================");
        System.out.println("Using lambda expression");
        System.out.println("=======================");

        // Using lambda expression
        countryList.stream().forEach( country -> {
                    System.out.println(country);
                }
        );

        System.out.println("=======================");
        System.out.println("Using Method references");
        System.out.println("=======================");

        // Using method reference
        countryList.stream().forEach( System.out::println );
    }
}