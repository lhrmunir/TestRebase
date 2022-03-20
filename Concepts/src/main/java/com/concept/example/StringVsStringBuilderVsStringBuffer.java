package com.concept.example;

// https://www.journaldev.com/538/string-vs-stringbuffer-vs-stringbuilder#:~:text=String%20is%20immutable%20whereas%20StringBuffer,uses%20StringBuffer%20or%20StringBuilder%20class.

import java.util.GregorianCalendar;
/*
        String vs StringBuffer vs StringBuilder
        -------------------------------------------
        - String is immutable whereas StringBuffer and StringBuilder are mutable classes.
        - StringBuffer is thread-safe and synchronized whereas StringBuilder is not.
          That’s why StringBuilder is faster than StringBuffer.

        - String concatenation operator (+) internally uses StringBuffer or StringBuilder class.

        - For String manipulations in a non-multi threaded environment, we should use StringBuilder else use StringBuffer class.

        ==========

        If the new operator is used to create a string, it gets created in the heap memory.
        The + operator is overloaded for String. We can use it to concatenate two strings. Although internally it uses StringBuffer to perform this action.
        String overrides equals() and hashCode() methods. Two Strings are equal only if they have the same character sequence.
        The equals() method is case sensitive. If you are looking for case insensitive checks, you should use equalsIgnoreCase() method.

        String vs StringBuffer
        ===========================
        - Since String is immutable in Java, whenever we do String manipulation like concatenation, substring, etc.
          it generates a new String and discards the older String for garbage collection.

        - These are heavy operations and generate a lot of garbage in heap.
          So Java has provided StringBuffer and StringBuilder classes that should be used for String manipulation.

        - StringBuffer and StringBuilder are mutable objects in Java.
          They provide append(), insert(), delete(), and substring() methods for String manipulation.



        StringBuffer vs StringBuilder
        ================================
        - StringBuffer was the only choice for String manipulation until Java 1.4. But, it has one disadvantage that all of its public methods are synchronized.
          StringBuffer provides Thread safety but at a performance cost.

        - In most of the scenarios, we don’t use String in a multithreaded environment.
          So Java 1.5 introduced a new class StringBuilder, which is similar to StringBuffer except for thread-safety and synchronization.

        - StringBuffer has some extra methods such as substring, length, capacity, trimToSize, etc.
          However, these are not required since you have all these present in String too. That’s why these methods were never implemented in the StringBuilder class.

        - StringBuffer was introduced in Java 1.0 whereas StringBuilder class was introduced in Java 1.5 after looking at shortcomings of StringBuffer.

        - If you are in a single-threaded environment or don’t care about thread safety, you should use StringBuilder.
          Otherwise, use StringBuffer for thread-safe operations.


*/

public class StringVsStringBuilderVsStringBuffer {

    public static void main(String[] args)
    {
        System.gc();
        long start=new GregorianCalendar().getTimeInMillis();
        long startMemory=Runtime.getRuntime().freeMemory();
        StringBuffer sb = new StringBuffer();
        //StringBuilder sb = new StringBuilder();
        for(int i = 0; i<10000000; i++){
            sb.append(":").append(i);
        }
        long end=new GregorianCalendar().getTimeInMillis();
        long endMemory=Runtime.getRuntime().freeMemory();
        System.out.println("Time Taken:"+(end-start));
        System.out.println("Memory used:"+(startMemory-endMemory));
        /* ----------------------------------------------------------------- */

        System.gc();
        start=new GregorianCalendar().getTimeInMillis();
        startMemory=Runtime.getRuntime().freeMemory();
        // StringBuffer sb = new StringBuffer();
        StringBuilder sbld = new StringBuilder();
        for(int i = 0; i<10000000; i++){
            sbld.append(":").append(i);
        }
        end=new GregorianCalendar().getTimeInMillis();
        endMemory=Runtime.getRuntime().freeMemory();
        System.out.println("Time Taken:"+(end-start));
        System.out.println("Memory used:"+(startMemory-endMemory));
    }
}
