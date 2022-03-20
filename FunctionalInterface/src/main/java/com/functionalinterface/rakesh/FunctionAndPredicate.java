package com.functionalinterface.rakesh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionAndPredicate 
{
    public static Predicate<String> startsWithA(final String letter) {
        return name -> name.startsWith(letter);
    }

    public static void main(String[] args) {

        final List<String> fruits = Arrays.asList("Apple", "Banana", "Cherries", "Dates", "Eggfruit", "Fig", "Grapes", "Hackberry");

        final Function<String, Predicate<String>> startWithC = (String prefix) -> {
            Predicate<String> checkWithLetter = (String name) -> name.startsWith(prefix);
            return checkWithLetter;
        };

        final Function<String, Predicate<String>> startWithD = (prefix) -> (name) -> name.startsWith(prefix);

        final Function<String, Predicate<String>> startsWithF =
                new Function<String, Predicate<String>>() {
                    @Override
                    public Predicate<String> apply(String s) 
                    {
                        return new Predicate<String>() {
                            @Override
                            public boolean test(String name) {
                                return name.startsWith(s);
                            }
                        };
                    }
                };


        fruits.stream().filter(startsWithA("A")).forEach(System.out::println);
        fruits.stream().filter(name -> name.startsWith("B")).forEach(System.out::println);
        fruits.stream().filter(startWithC.apply("C")).forEach(System.out::println);
        fruits.stream().filter(startWithD.apply("D")).forEach(System.out::println);
        fruits.stream().filter(startsWithF.apply("F")).forEach(System.out::println);
        fruits.stream().filter(startWithD.apply("G")).forEach(new Consumer<String>() 
        {
            public void accept(final String name) {
                System.out.println(name);
            }
        });

    }
}
