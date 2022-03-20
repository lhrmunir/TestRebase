package com.methodreference.advancedExample;

/*
 * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
// import java.util.Collections;

/*
        https://docs.oracle.com/javase/tutorial/java/javaOO/examples/Person.java
        https://docs.oracle.com/javase/tutorial/java/javaOO/examples/MethodReferencesTest.java

        https://stackoverflow.com/questions/1946668/sorting-using-comparator-descending-order-user-defined-classes/1947527
*/
public class MethodRefCompAdvancedExample {

    // The method transferElements copies elements from one collection to another

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements( SOURCE sourceCollection, Supplier<DEST> collectionFactory)
    {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }
    /* --------------------------------------------------------------------- */
    public static void main(String... args) {

        List<Person> roster = Person.createRoster();

        String[] stringNamesArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };

        for (Person p : roster) {
            p.printPerson();
        }

        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);  // UNCOMMENT IT
        /* ------------------------------------------------------------------------------------------------------------------ */
        // https://stackoverflow.com/questions/1946668/sorting-using-comparator-descending-order-user-defined-classes/1947527

        class PersonAgeComparator implements Comparator<Person>
        {
            public int compare(Person a, Person b)
            {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        /* ------------------------------------------------------------------------------------------------------------------ */


        // 1 - WITHOUT METHOD REFERENCE
        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // 2 - WITH LAMBDA EXPRESSION
        Arrays.sort(rosterAsArray, (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        // 3 - WITH METHOD REFERENCE
        Arrays.sort(rosterAsArray, Person::compareByAge);

        /* ------------------------------------------------------------------------------------------------------------------ */
        // https://stackoverflow.com/questions/1946668/sorting-using-comparator-descending-order-user-defined-classes/1947527

        // Reference to an instance method of a particular object
        class ComparisonProvider {

            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }

            public int compareByBirthday(Person a, Person b) {
                return b.getBirthday().compareTo(a.getBirthday());
            }
            // ------------- OR -----------
            // Collections.  //    .sort(rosterAsArray, Collections.reverseOrder(new Person.AgeComparator()));
            // Collections.sort(rosterAsArray, Collections.reverseOrder(new Person.AgeComparator()));
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();

        /* ------------------------------------------------------------------------------------------------------------------ */

        // Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);
        mySortComparator(rosterAsArray, myComparisonProvider::compareByName);

        System.out.println("\n Printing rosterAsArray after sorting using myComparisonProvider::compareByName:");
        Arrays.stream(rosterAsArray).forEach(p ->  p.printPerson());

        /* ------------------------------------------------------------------------------------------------------------------ */

        mySortComparator(rosterAsArray, myComparisonProvider::compareByAge);

        System.out.println("\n Printing rosterAsArray after sorting using myComparisonProvider::compareByAge:");
        Arrays.stream(rosterAsArray).forEach(p ->  p.printPerson());

        /* ------------------------------------------------------------------------------------------------------------------ */

        mySortComparator(rosterAsArray, myComparisonProvider::compareByBirthday);

        System.out.println("\n Printing rosterAsArray after sorting using myComparisonProvider::compareByBirthday:");
        Arrays.stream(rosterAsArray).forEach(p ->  p.printPerson());

        /* ------------------------------------------------------------------------------------------------------------------ */

        Person [] tmpPersonArr1 = rosterAsArray;

        Collections.sort(Arrays.asList(tmpPersonArr1), Collections.reverseOrder(myComparisonProvider::compareByAge));

        System.out.println("\n Printing tmpPersonArr1 after sorting using  Collections.reverseOrder(myComparisonProvider::compareByAge):");
        Arrays.stream(tmpPersonArr1).forEach(p ->  p.printPerson());
        /* ------------------------------------------------------------------------------------------------------------------ */

        Person [] tmpPersonArr2 = rosterAsArray;
        Arrays.sort(tmpPersonArr2, (el1, el2) -> { return el2.getBirthday().compareTo(el1.getBirthday());});

        // ------- NEW STYLE ------
        System.out.println("\n Printing tmpPersonArr2 after inline sorting [NEW STYLE]):");
        Arrays.stream(tmpPersonArr2).forEach(p ->  p.printPerson());
        /* ------------------------------------------------------------------------------------------------------------------ */
        // Reference to an instance method of an arbitrary object of a particular type



        Arrays.sort(stringNamesArray, String::compareToIgnoreCase);

        System.out.println("\n Printing stringNamesArray (using LAMBDA):");
        Arrays.stream(stringNamesArray).forEach(p -> System.out.println(p));

        System.out.println("\n Printing stringNamesArray (using METHOD REFERENCE):");
        Arrays.stream(stringNamesArray).forEach(System.out::println);
        /* ------------------------------------------------------------------------------------------------------------------ */

        Set<Person> rosterSetLambda = transferElements(roster, () -> { return new HashSet<>(); });
        // ------ OR -------
        Set<Person> rosterSetMethodRef = transferElements( roster, HashSet::new);

        System.out.println("\n Printing rosterSetLambda : ");
        rosterSetLambda.stream().forEach(p -> p.printPerson());

        System.out.println("\n Printing rosterSetMethodRef : ");
        rosterSetMethodRef.stream().forEach(p -> p.printPerson());

        /* ------------------------------------------------------------------------------------------------------------------ */

        Consumer<Person> c1 = s -> System.out.println(s.getName());             /* CONSUMER OF PERSON */
        Consumer<Person> c2 = System.out::println;                              /* CONSUMER OF PERSON */

        Consumer<String> c3 = System.out::println;                              /* CONSUMER OF STRING */

        System.out.println("\n Printing  => Consumer<Person> c1 = s -> System.out.println(s); : ");
        rosterSetMethodRef.stream().forEach(c1);

        System.out.println("\n Printing =>  c2::accept : ");
        rosterSetMethodRef.stream().forEach(c2::accept);

        System.out.println("\n Printing =>  Consumer<Person> c2 = System.out::println; : ");
        rosterSetMethodRef.stream().forEach(pp -> c2.accept(pp));               /* PRINTING PERSON */


        System.out.println("\n Printing =>  Consumer<Person> c3 = System.out::println; : ");
        rosterSetMethodRef.stream().forEach(pp -> c3.accept(pp.getName()));     /* PRINTING STRING */




    }
    /* ---------------- END --------- OF ----------- public static void main(String... args) ----------------------- */

    private static <T> T[] mySortComparator( T[] genericArr, java.util.Comparator<? super T> genericComp) {

        // Person[] rosterAsArray, ) {

        Set dataSet = new HashSet();

        T[] genArr = null;

        // Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        Arrays.sort(genericArr, genericComp);

        genArr = genericArr;

        return genArr;
    }
}
