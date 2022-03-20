package com.methodreference.codersdesks;

//http://www.codersdesks.com/java-8-method-reference-with-example/

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InstanceMethodReferenceExample {

	public static void main(String[] args) {

		List<Device> devices = Arrays.asList(new Device(1, "Mobile"), new Device(3, "Laptop"), new Device(2, "PC"),
				new Device(5, "Router"), new Device(4, "Mouse"));

		System.out.println("devices before sort using instace method");
		System.out.println(devices);

		InstanceMethodReferenceExample ec = new InstanceMethodReferenceExample();

		Collections.sort(devices, ec::compareById);

		System.out.println("devices after sort using instace method");

		System.out.println(devices);

	}

	public int compareById(Device d1, Device d2) {
		return Integer.compare(d1.getId(), d2.getId());
	}
}
