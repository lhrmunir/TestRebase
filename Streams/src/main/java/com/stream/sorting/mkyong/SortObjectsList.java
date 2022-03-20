package com.stream.sorting.mkyong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortObjectsList {

    static List<User> usersList = Arrays.asList(
            new User("C forty", 40),
            new User("D thirty", 30),
            new User("A ninety", 90),
            new User("B sixty", 60),
            new User("F eleven", 11),
            new User("E ten", 10));

    public static void main(String[] args) {
        
        /*List<User> sortedList = users.stream()
            .sorted((o1, o2) -> o1.getAge() - o2.getAge())
            .collect(Collectors.toList());*/
            
    	System.out.println("\r\n------------------------------- DEMO STREAM SORTING BASED ON AGE---------------------------------------");
    	   
        List<User> sortedList = usersList.stream()
            .sorted(Comparator.comparingInt(User::getAge))
            .collect(Collectors.toList());
 
        sortedList.forEach(System.out::println);
        
        System.out.println("\r\n------------------------------- DEMO STREAM REVERSE SORTING BASED ON AGE---------------------------------------");
        
        List<User> sortedListReverse = usersList.stream()
                .sorted(Comparator.comparingInt(User::getAge)
                .reversed())
                .collect(Collectors.toList());

        sortedListReverse.forEach(System.out::println);
        
        
    System.out.println("\r\n------------------------------- DEMO STREAM REVERSE SORTING BASED ON NAME---------------------------------------");
        
        /*List<User> sortedList = users.stream()
        .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
        .collect(Collectors.toList());*/
    
    List<User> sortedListOnName = usersList.stream()
        .sorted(Comparator.comparing(User::getName))
        .collect(Collectors.toList());
    
    sortedListOnName.forEach(System.out::println);
            

    }

    static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}