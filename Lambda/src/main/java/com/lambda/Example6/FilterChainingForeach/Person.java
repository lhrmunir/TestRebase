package com.lambda.Example6.FilterChainingForeach;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Person {
	private String surName;
	private int age;
	private String gender;

	public Person(String sur, int ag) {
		surName = sur;
		age = ag;
		gender = "Male";
	}

	public void printName() {
		System.out.println("surName = " + surName);
	}

	public String printCustom(Function<Person, String> f) {
		return f.apply(this);
	}

	public static List<Person> createShortList() {
		List<Person> people = new ArrayList<>();

		people.add(new Person("John", 16));
		people.add(new Person("Mike", 17));
		people.add(new Person("Donald", 18));
		people.add(new Person("JAMHOORA", 16));

		return people;
	}

	public String getSurName() {
		return surName;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

}
