package com.methodreference.codersdesks;

// http://www.codersdesks.com/java-8-method-reference-with-example/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaticMethodReferenceExample {

	public static void main(String[] args) {

		List<Device> devices = Arrays.asList(new Device(1, "Mobile"), new Device(3, "Laptop"), new Device(2, "PC"),
				new Device(5, "Router"), new Device(4, "Mouse"));

		System.out.println("devices before sort");
		System.out.println(devices);

		Comparator<Device> compt = StaticMethodReferenceExample::compareById;

		Collections.sort(devices, compt);

		System.out.println("devices after sort");

		System.out.println(devices);

	}

	public static int compareById(Device d1, Device d2) {
		return Integer.compare(d1.getId(), d2.getId());
	}
}
