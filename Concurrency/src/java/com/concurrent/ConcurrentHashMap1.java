package com.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Benjamin Winterberg
 */
public class ConcurrentHashMap1 {

    public static void main(String[] args) {
        System.out.println("Parallelism: " + ForkJoinPool.getCommonPoolParallelism());

        testForEach();
        testSearch();
        testReduce();
    }

    private static void testReduce() {
        ConcurrentHashMap<String, String> chMap = new ConcurrentHashMap<>();
        chMap.putIfAbsent("foo", "bar");
        chMap.putIfAbsent("han", "solo");
        chMap.putIfAbsent("r2", "d2");
        chMap.putIfAbsent("c3", "p0");

        String reduced = chMap.reduce(1, (key, value) -> key + "=" + value,
                (s1, s2) -> s1 + ", " + s2);

        System.out.println(reduced);
    }

    private static void testSearch() {
        ConcurrentHashMap<String, String> chMap = new ConcurrentHashMap<>();
        chMap.putIfAbsent("foo", "bar");
        chMap.putIfAbsent("han", "solo");
        chMap.putIfAbsent("r2", "d2");
        chMap.putIfAbsent("c3", "p0");

        System.out.println("\ninside testSearch() --------- search()  ---- DEMO --------- \n");

        String result1 = chMap.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if (key.equals("foo") && value.equals("bar")) {
                return "foobar";
            }
            return null;
        });

        System.out.println("inside testSearch() >>>>> result1 = " + result1);

        System.out.println("\ninside testSearch() --------- searchValues()  ---- DEMO --------- \n");

        String result2 = chMap.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });


        System.out.println("inside testSearch() >>>>> result2 = " + result2);
    }

    private static void testForEach() {
        ConcurrentHashMap<String, String> chMap = new ConcurrentHashMap<>();
        chMap.putIfAbsent("foo", "bar");
        chMap.putIfAbsent("han", "solo");
        chMap.putIfAbsent("r2", "d2");
        chMap.putIfAbsent("c3", "p0");

        System.out.println("-------------- ParallelismThreshold = 1 ------- DEMO BELOW ---------------------------");
        chMap.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));

        System.out.println("-------------- ParallelismThreshold = 5 ------- DEMO BELOW ---------------------------");
        chMap.forEach(5, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("chMap.mappingCount() = " + chMap.mappingCount() + " >>> chMap.size() = " + chMap.size());
    }

}
