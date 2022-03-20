package com.functionalinterface.flibbertyfunkyfaces.predicate_ex;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by yevgen on 20.02.17.
 */
public class PredicateSample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer % 2 == 0) return true;
                else return false;
            }
        };
        System.out.println("Print even numbers in Java 7 style:");
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }

        Predicate<Integer> predicateForEvenNumbers = n -> n % 2 == 0;
        System.out.println("Print even numbers:");
        eval(list, predicateForEvenNumbers);


        Predicate<Integer> predicateGreaterThanFive = n -> n > 5;
        System.out.println("Print even numbers greater than 5:");
        eval(list, predicateForEvenNumbers.and(predicateGreaterThanFive));
        System.out.println("Print the same:");
        eval(list, n -> n % 2 == 0 && n > 5);

        System.out.println("Print uneven numbers:");
        eval(list, predicateForEvenNumbers.negate());

        System.out.println("Print all even numbers or uneven numbers greater than 5:");
        eval(list, predicateForEvenNumbers.or(predicateForEvenNumbers.negate().and(predicateGreaterThanFive)));

        System.out.println("Print test for method isEqual:");
        Predicate<String> sample = Predicate.isEqual("one");
        System.out.println(sample.test("another"));

        System.out.println("Print second test for method isEqual:");
        list.stream().filter(Predicate.isEqual(5)).forEach(n -> System.out.println(n));

        System.out.println("Print names:");
        List<Person> names = new ArrayList<>();
        names.add(new Person("Richard", "Dawkins"));
        names.add(new Person("Richard", "Feynman"));
        names.add(new Person("Douglas", "Hofstadter"));
        names.add(new Person("Martin", "Odersky"));
        Predicate<Person> pred1 = name -> "Richard".equals(name.getFirstName()); // Ð’Ñ�Ðµ Ñ�Ð¾Ð²Ð¿Ð°Ð´ÐµÐ½Ð¸Ñ� Ñ� Ð¸Ð¼ÐµÐ½ÐµÐ¼ "Richard"
        Predicate<Person> pred2 = name -> "Odersky".equals(name.getLastName()); // Ð’Ñ�Ðµ Ñ�Ð¾Ð²Ð¿Ð°Ð´ÐµÐ½Ð¸Ñ� Ñ� Ñ„Ð°Ð¼Ð¸Ð»Ð¸ÐµÐ¹ "Odersky"
        names.removeIf(pred1.or(pred2)); // Ð£Ð´Ð°Ð»Ð¸Ð¼ Ð¸Ð· Ñ�Ð¿Ð¸Ñ�ÐºÐ° Ð¸Ð¼Ñ‘Ð½ Ð²Ñ�Ðµ Ñ�Ð¾Ð²Ð¿Ð°Ð´ÐµÐ½Ð¸Ñ� Ñ� ÑƒÐ»Ð¾Ð²Ð¸Ñ�Ð¼Ð¸ Ð½Ð°ÑˆÐ¸Ñ… Ð¿Ñ€ÐµÐ´Ð¸ÐºÐ°Ñ‚Ð¾Ð²
        names.stream().forEach(System.out::println);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        list.stream()
                .filter(predicate)
                .forEach(s -> System.out.println(s));
    }
}
