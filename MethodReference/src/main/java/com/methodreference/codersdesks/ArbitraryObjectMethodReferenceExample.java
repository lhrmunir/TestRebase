package com.methodreference.codersdesks;

//http://www.codersdesks.com/java-8-method-reference-with-example/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArbitraryObjectMethodReferenceExample {

	public static void main(String[] args) {

		List<Device> devices = Arrays.asList(new Device(1, "Mobile"), new Device(3, "Laptop"), new Device(2, "PC"),
				new Device(5, "Router"), new Device(4, "Mouse"));

		Map<Integer, String> deviceMap = devices.stream().collect(Collectors.toMap(Device::getId, Device::getType));

		System.out.println("deviceMap " + deviceMap);
	}

}
