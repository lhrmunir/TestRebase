package com.methodreference.advancedArpitMedium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class MethodReferenceConstructorMain {

    public static void main(String[] args) {


        ArrayList<String> list=new ArrayList<>();
        list.add("Rohan");
        list.add("Andy");
        list.add("Sneha");
        list.add("Rohan");

        // Anonymous class
        Function<List<String>,Set<String>> f1= new Function<List<String>, Set<String>>() {

            @Override
            public Set<String> apply(List<String> nameList) {

                return new HashSet<>(nameList);
            }
        };
        Set<String> set1 = f1.apply(list);
        System.out.println(set1);

        // Using lambda expression
        Function<List<String>,Set<String>> f2 = (nameList) -> new HashSet<>(nameList);
        Set<String> set2 = f2.apply(list);
        System.out.println(set2);

        // Using Method reference
        Function<List<String>,Set<String>> f3= HashSet::new;
        Set<String> set = f3.apply(list);
        System.out.println(set);
    }
}