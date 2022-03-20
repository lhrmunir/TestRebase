package com.methodreference.advancedArpitMedium;

import java.util.function.BiFunction;

public class MethodReferenceObjectType {

    public static void main(String[] args) {

        // Using anonymous class

        BiFunction<String,Integer,String> bf1=new BiFunction<>() {

            @Override
            public String apply(String t, Integer u) {
                return t.substring(u);
            }
        };
        String subString1 = getSubstring("Java2blog",2,bf1);
        System.out.println(subString1);

        // Using lambda expression
        BiFunction<String,Integer,String> bf2 =  (t,u) -> t.substring(u);
        String subString2 = getSubstring("Java2blog",2,bf2);
        System.out.println(subString2);

        // Using Method reference
        BiFunction<String,Integer,String> bf3 = String::substring;
        String subString3 = getSubstring("Java2blog",2,bf3);
        System.out.println(subString3);
    }

    public static String getSubstring(String str1,int beginIndex,BiFunction<String,Integer,String> p)
    {
        return p.apply(str1, beginIndex);

    }

}
