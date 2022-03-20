package com.functionalinterface.fiPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    static class Person {
        String name;
        int age;
        String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        public static void showPersons(List<Person> list, Predicate<Person> condition) {
            for (Person p : list)
                if (condition.test(p)) System.out.println(p.toString());
        }
    }

    public static void main(String... args) 
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Mark Zuckerberg", 33, "M"));
        personList.add(new Person("Bill Gates", 62, "M"));
        personList.add(new Person("Marissa Mayer", 42, "F"));
        personList.add(new Person("Satya Nadella", 50, "M"));
        personList.add(new Person("Sundar Pichai", 45, "M"));
        personList.add(new Person("Sergey Brin", 44, "M"));
        personList.add(new Person("Larry Page", 45, "M"));
        personList.add(new Person("Missy Brian", 35, "F"));

        Predicate<Person> isFemale = (p) -> p.gender.equals("F");
        Predicate<Person> isYoung = (p) -> p.age <= 35;
        Predicate<Person> isAged = (p) -> p.age >= 45;

        System.out.println("Female persons: ");
        Person.showPersons(personList, isFemale);

        System.out.println("Young persons: ");
        Person.showPersons(personList, isYoung);

        System.out.println("Aged persons: ");
        Person.showPersons(personList, isAged);
    }
}
