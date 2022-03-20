package com.functionalinterface.fiSupplier;

import java.util.function.Supplier;

public class SupplierRoytuts {

	public static void main(String[] args) {
		showValues(() -> "Hi");
		showValues(() -> "Hey");
		showValues(() -> "Hello");
		showValues(() -> 39.901);
		
		Supplier<Integer> supplierInteger = () -> 50;
		System.out.println(supplierInteger.get());
		
		Supplier<String> supplierString = () -> "Soumitra";
		System.out.println(supplierString.get());

		Supplier<User> userSupplier = (() -> {

					User testUser = new User("I am Human Being");
					// testUser.setName("I am Human");
					return testUser;

				});
		System.out.println(userSupplier.get());
		System.out.println(userSupplier.get().getName());
	}

	public static void showValues(Supplier<?> supplier)
	{
		System.out.println(supplier.get());
	}

}
