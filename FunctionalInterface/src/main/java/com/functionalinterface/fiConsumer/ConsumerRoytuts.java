package com.functionalinterface.fiConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerRoytuts {

	public static void main(String[] args) {
		List<String> greets = Arrays.asList("Hi", "Hey", "Hello");

		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};

		greets.forEach(consumer);

		System.out.println("===============================");

		User user = new User("Soumitra");
		Consumer<User> updateName = u -> u.setName("Roytuts");
		updateName.accept(user);

		System.out.println(user.getName());
	}

}
