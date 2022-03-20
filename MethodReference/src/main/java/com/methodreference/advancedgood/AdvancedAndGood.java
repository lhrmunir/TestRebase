package com.methodreference.advancedgood;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
        http://blog.marcinchwedczuk.pl/method-references-in-java-8
 */
public class AdvancedAndGood {

    public static void main (String [] args) {

        // Both functions do the same thing:
        Function<Person, String> getNameLambda = person -> person.getName();
        Function<Person, String> getNameMethRef = Person::getName;

        // How to use it with stream:
        List<String> lstNames1 = Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
                .map(person -> person.getName())
                .collect(Collectors.toList());

        List<String> lstNames2 = Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Going to print lstNames1");
        lstNames1.forEach(n -> System.out.println(n));

        System.out.println("Going to print lstNames2");
        lstNames2.forEach(n -> System.out.println(n));

        /*  ------------------------------------------------------------------------------------------  */

        List<Person> linuxUsers = new ArrayList<>();

        Consumer<Person> addUserLambda = person -> linuxUsers.add(person);
        Consumer<Person> addUserMethRef = linuxUsers::add;

        Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
                .forEach(person -> linuxUsers.add(person));


        System.out.println("Going to print linuxUsers");
        linuxUsers.forEach(n -> System.out.println(n.toString()));

        Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
                .forEach(linuxUsers::add);

        System.out.println("Going to print linuxUsers");
        linuxUsers.forEach(n -> System.out.println(n.toString()));

        /*  ------------------------------------------------------------------------------------------  */

        Person anonymous = new Person();

        BiConsumer<String, String> setNameMethRef_1 =  (first, last) -> anonymous.setName(first, last);

        BiConsumer<String, String> setNameMethRef_2 = anonymous::setName;

        setNameMethRef_1.accept("BiConFirstNaME", "BiConLastNaMe");
        System.out.println("Going to print anonymous.getName() BiConsumer -> anonymous = " +  anonymous.toString());

        setNameMethRef_2.accept("BiConFirst Method", "BiConLast Reference");
        System.out.println("Going to print anonymous.getName() BiConsumer -> anonymous = " +  anonymous.toString());

        // When we provide both instance on which to call a method and all method arguments we may use method references too:




        /*  ------------------------------------------------------------------------------------------  */
/*
            MOST MOST IMPORTANT BELOW :
 */
        TriConsumer<Person, String, String> setNameOnPersonL = (person, first, last) -> person.setName(first, last);

        TriConsumer<Person, String, String> setNameOnPersonMR = Person::setName;

        setNameOnPersonL.apply(anonymous, "James", "Bond");
        System.out.println("Going to print anonymous.getName() = " +  anonymous.getName());

        setNameOnPersonMR.apply(anonymous, "Donald Method", "Trump Reference");
        System.out.println("Going to print anonymous.getName() = " +  anonymous.getName());

        /*  ------------------------------------------------------------------------------------------  */

        // Using method references when working with static methods is also easy, for example:

        IntBinaryOperator maxLambda = (a, b) -> Integer.max(a, b);
        IntBinaryOperator maxMethRef = Integer::max;

        DoubleSupplier randomLambda = () -> Math.random();
        DoubleSupplier randomMethRef = Math::random;


        /*  ------------------------------------------------------------------------------------------  */

        /*
                Now let’s move to constructor references.
                Every lambda expression in form () -> new FooClass() can be rewritten to use constructor reference
                as FooClass::new, for example:
         */
        Supplier<ArrayList<Person>> createListLambda = () -> new ArrayList<>();
        Supplier<ArrayList<Person>> createListMethRef = ArrayList::new;

        // This also work when constructor has parameters:

        Function<String, Person> createPersonWithNameL = name -> new Person(name);

        Function<String, Person> createPersonWithNameMR = Person::new;


        /*  ------------------------------------------------------------------------------------------  */

        // We may even use constructor references to create arrays:

        // https://www.geeksforgeeks.org/intfunction-interface-in-java-with-examples/
        BiConsumer<String, String> bc = (x, y) -> { System.out.println(x + y); };
        bc.accept("aaaaaa","bbbbbb");


        IntFunction<String[]> xcreateArrayL = size -> {

            return new String[size];

        };


        IntFunction<String[]> createArrayL = size -> new String[size];  // it will return String Array of "size" length
        IntFunction<String[]> createArrayMR = String[]::new;            // it will return String Array. Length will be provided later in apply()



        String [] strArray_0 = xcreateArrayL.apply(11);
        String [] strArray_1 = createArrayL.apply(5);
        String [] strArray_2 = createArrayMR.apply(7);

        strArray_0[0] = "Dolat Khan";
        System.out.println("strArray_0[0] = " + strArray_0[0] + " >>>>>> strArray_0.size = " + strArray_0.length);

        strArray_1[4] = "Pakistan";
        System.out.println("strArray_1[4] = " + strArray_1[4] + " >>>>>> strArray_1.size = " + strArray_1.length);

        strArray_2[6] = "Europe.....";
        System.out.println("strArray_2[6] = " + strArray_2[6] + " >>>>>> strArray_2.size = " + strArray_2.length);

        // Unfortunately this doesn't work with 2D arrays
        BiFunction<Integer, Integer, String[][]> createArray2DL = (rows, cols) -> new String[rows][cols];
        String[][] arrString2Dim = createArray2DL.apply(4, 9);

        arrString2Dim[3][8] = "Element in .....LAST ROW AND LAST COLUMN";
        System.out.println("sarrString2Dim[3][8] = " + arrString2Dim[3][8] + " >>>>>> arrString2Dim.size = " + arrString2Dim.length);

        String [] arrRowOneOf2Dim = arrString2Dim[0];

        arrRowOneOf2Dim[7] = "OLYMPIA STREET...";
        System.out.println("sarrRowOneOf2Dim[7]  = " + arrRowOneOf2Dim[7]  + " >>>>>> arrRowOneOf2Dim.size = " + arrRowOneOf2Dim.length);


        // createArray2DL[2][3] = "";

        // System.out.println("createArray2DL.toString() = " + createArray2DL[2][3]);

        // This will create SINGLE ARRAY of arrays not 2D array
        // Each row of this array will be initially set to null
 /*  ERROR   */    //       IntFunction<Integer, String[][]> notWork = String[][]::new;



        /*  ------------------------------------------------------------------------------------------  */



        /*  ------------------------------------------------------------------------------------------  */
    }
}
