package com.stream.javamagazine;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    https://blogs.oracle.com/javamagazine/post/functional-programming-in-java-part-2-lambda-reuse-lexical-scoping-and-closures-and-reduce
 */
public class LambdaConcisenessDemo {

    public static void main(String [] args) {
        System.out.println("inside LambdaConcisenessDemo");

        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

        /*
            The lambda expressions made the code concise, but they quietly led to duplicate code.
            In the below example, one change to the lambda expression requires changes in more than one place—that’s a no-no.
            Fortunately, you can assign lambda expressions to variables and reuse them, as you would with objects.
         */
        final long countFriendsStartN = friends.stream()
                                            .filter(name -> name.startsWith("N"))
                                            .count();
        final long countEditorsStartN = editors.stream()
                                            .filter(name -> name.startsWith("N"))
                                            .count();
        final long countComradesStartN = comrades.stream()
                                            .filter(name -> name.startsWith("N"))
                                            .count();

        /*
                VERSION-2 : More Refined - but Duplication in lambda expressions is here.
        */
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB =  name -> name.startsWith("B");


        final long countFriendsStartB = friends.stream()
                                            .filter(startsWithB)
                                            .count();
        final long countFriendsStartN1 = friends.stream()
                                            .filter(startsWithN)
                                            .count();
        final long countEditorsStartN1 = editors.stream()
                                            .filter(startsWithN)
                                            .count();
        final long countComradesStartN1 = comrades.stream()
                                            .filter(startsWithN)
                                            .count();
        /*
                VERSION-3 : More Refined Removing Duplication Using lexical scoping and closures
                            Below method is declared outside main()
                (Please read the whole article to get GREAT knowlidge at:
                https://blogs.oracle.com/javamagazine/post/functional-programming-in-java-part-2-lambda-reuse-lexical-scoping-and-closures-and-reduce.
                It is also downloaded as PDF)

                      public static Predicate<String> checkIfStartsWith(final String letter) {
                            return name -> name.startsWith(letter);
                       }
        */
        final long countFriendsStartN2 = friends.stream()
                                                    .filter(checkIfStartsWith("N"))
                                                    .count();
        final long countFriendsStartB2 = friends.stream()
                                                    .filter(checkIfStartsWith("B"))
                                                    .count();


        /*
                VERSION-4 : MOST Refined -  Refactoring to narrow the scope.

                           (Please read the whole article to get GREAT knowlidge at:
                            https://blogs.oracle.com/javamagazine/post/functional-programming-in-java-part-2-lambda-reuse-lexical-scoping-and-closures-and-reduce.
                            It is also downloaded as PDF)
        */
        final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
            Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
            return checkStarts;
        };

         /*
                VERSION - 2 : MOST Refined
         */
        final Function<String, Predicate<String>> startsWithLetter2 = letter -> name -> name.startsWith(letter);


        pickName(friends, "N");
        pickName(friends, "Z");


        pickName2(friends, "N");
        pickName2(friends, "Z");

        pickName3(friends, "N");
        pickName3(friends, "Z");

        System.out.println("Total number of characters in all names: " +
                                            friends.stream()
                                                    .mapToInt(name -> name.length())
                                                    .sum());

        final Optional<String> aLongName = friends.stream()
                                             .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name ->
                System.out.println( String.format("A longest name: %s", name)) );

        final String steveOrLonger = friends.stream()
                                        .reduce("Steve", (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);

        System.out.println(String.join(", ", friends));

        System.out.println(friends.stream()
                                .map(String::toUpperCase)
                                .collect(Collectors.joining(", ")));

    } /* --------------- END ---------- OF --------- MAIN() ------------------- */

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    public static void pickName(final List<String> names, final String startingLetter)
    {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.print(String.format("inside pickName() : A name starting with %s: ", startingLetter));

        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    /*
            VERSION - 2 : More Refined
     */
    public static void pickName2(final List<String> names, final String startingLetter)
    {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        System.out.println(String.format( "inside pickName2() : A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
    }

    /*
           VERSION - 3 : Same as Version-2 but a bit more short
    */
    public static void pickName3(final List<String> names, final String startingLetter)
    {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        foundName.ifPresent( name -> System.out.println("inside pickName3() : Hello " + name));

        System.out.println(String.format( "inside pickName3() : A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
    }

}
