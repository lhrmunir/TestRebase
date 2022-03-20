package com.functionalinterface.fiPredicate.geeksforgeeks;

/*
	https://www.geeksforgeeks.org/remove-elements-from-a-list-that-satisfy-given-predicate-in-java/
	Java Program to remove "ABC" from a List using List.removeAll() and Predicate
*/
import java.util.function.Predicate; 
import java.util.*; 

class GenericPredicateCollections {

	// Generic function to remove elements using Predicate 
	public static <T> List<T> removeElements(List<T> list, Predicate<T> pred) 
	{ 

		// Create collection using Predicate 
		Collection<T> collection = new ArrayList<>(); 

		for (T t : list) { 
			if (pred.test(t)) { 
				collection.add(t); 
			} 
		} 

		// Print the list 
		System.out.println("Collection to be removed: " + collection); 

		// Removing "ABC" using List.removeAll() passing a collection 
		list.removeAll(collection); 

		// Return the list 
		return list; 
	} 

	public static void main(String[] args) 
	{ 

		// Create a list with null values 
		List<String> lstA = new ArrayList<>(Arrays.asList("1", "ABC", "15", "ABC", "12", "5", "ABC", "20")); 

		// Print the list 
		System.out.println("Original List: " + lstA); 

		// Creating a Predicate condition checking for "ABC" 
		Predicate<String> is10 = i -> (i == "ABC"); 

		// Removing using Predicate 
		lstA = removeElements(lstA, is10); 

		// Print the list 
		System.out.println("Updated List: " + lstA); 
	} 
} 

