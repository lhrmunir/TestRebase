package com.methodreference.advancedgood;

/*
        for:
        http://blog.marcinchwedczuk.pl/method-references-in-java-8
 */
class Person {

    // private final String name;
    private String name;

    public Person() {

    }
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String firstName, String lastName) {
        name = firstName + " " + lastName;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}
