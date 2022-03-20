package com.assortedgood;
/*
        https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

        Name of class on page : MethodReferencesExamples.java
 */
import java.util.function.BiFunction;

public class OracleDocsMthdRef01 {



    public static void main(String[] args) {

        OracleDocsMthdRef01 myApp = new OracleDocsMthdRef01();

        // Calling the method mergeThings with a LAMBDA EXPRESSION
        System.out.println(OracleDocsMthdRef01.mergeThings("Hello ", "LAMBDA EXPRESSION!", (a, b) -> a + b));

        // Reference to a STATIC METHOD
        System.out.println(OracleDocsMthdRef01.mergeThings("Hello ", "STATIC METHOD!", OracleDocsMthdRef01::appendStrings));

        // Reference to an INSTANCE METHOD of a PARTICULAR OBJECT
        System.out.println(OracleDocsMthdRef01.mergeThings("Hello ", "INSTANCE METHOD of a PARTICULAR OBJECT!", myApp::appendStrings2));

        // Reference to an INSTANCE METHOD of an ARBITRARY OBJECT of a PARTICULAR TYPE
        System.out.println(OracleDocsMthdRef01.mergeThings("Hello ", "INSTANCE METHOD of an ARBITRARY OBJECT of a PARTICULAR TYPE!", String::concat));

        /* - - - - - - - - -  */
        // Calling the method mergeThings with a LAMBDA EXPRESSION
        System.out.println(OracleDocsMthdRef01.mergeThings(5.2, 6.0, (a, b) -> a + b));
    }
    /* ---------------------------------------  ------------------------------------ */

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + b;
    }

    public String appendStrings2(String a, String b) {
        return a + b;
    }

//    public <T> T appendStringsT(a<T super Number>, b<T extends Number>) {
//
//        return a + b;
//    }
}
