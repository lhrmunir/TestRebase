package com.lambda.Example4.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Person {
	private String surName;
	private int age;
	private String gender;

	public Person(String sur) {
		surName = sur;
		age = 17;
		gender = "Male";
	}

	public void printName() {
		System.out.println(surName);
	}

	public String printCustom(Function<Person, String> f) {
		return f.apply(this);
	}

	public static List<Person> createShortList() {
		List<Person> people = new ArrayList<>();

		people.add(new Person("z"));
		people.add(new Person("x"));
		people.add(new Person("c"));

		return people;
	}

	String getSurName() {
		return surName;
	}

	int getAge() {
		return age;
	}

	String getGender() {
		return gender;
	}

}
