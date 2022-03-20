package com.functionalinterface.fiPredicate.geeksforgeeks;

/*
		https://www.geeksforgeeks.org/remove-elements-from-a-list-that-satisfy-given-predicate-in-java/
		Java Program to remove nulls from a List using iterator and Predicate
 */
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*; 

class GenericPredicateIterator
{ 

	/*  ================================================================================= */
	
	// Generic function to remove Null or not null (AS Per Given in Predicate) Using Iterator 
	public static <T> List<T> removeNullUsingIterator(List<T> l, Predicate<T> p) 
	{ 

		// Create an iterator from the l 
		Iterator<T> itr = l.iterator(); 

		// Find and remove all null 
		while (itr.hasNext()) { 

			// Fetching the next element 
			T t = itr.next(); 

			// Checking for Predicate condition 
			if (p.test(t)) { 

				// If the condition matches, remove that element 
				itr.remove(); 
			} 
		} 

		// Return the null 
		return l; 
	} 
	/*  ================================================================================= */
	
	
	public static void main(String[] args) 
	{ 

		// Create the l with null values 
		List<String> lst1 = new ArrayList<>(Arrays.asList("Geeks", null, "forGeeks", null, "A computer portal"));
		List<String> lst1Easy = Arrays.asList("Geeks", null, "forGeeks", null, "A computer portal");

		List<String> lst2 = lst1.stream().collect(Collectors.toList());
		
		lst1.add(0, "This is List1");
		lst2.add(0, "This is List2");
		
		// Print the lists 
		System.out.println("First List with null values: " + lst1); 
		System.out.println("Second List with null values: " + lst2); 

		// Creating a Predicate condition checking for null 
		Predicate<String> nonNull = item -> Objects.nonNull(item); 
		// Creating a Predicate condition checking for null 
		Predicate<String> isNull = item -> Objects.isNull(item); 
		
		
		// Removing nulls using iterator and Predicate 
		lst1 = removeNullUsingIterator(lst1, isNull); 
		// Print the list 
		System.out.println("lst1 with null values removed: " + lst1); 
		
		
		// Removing nulls using iterator and Predicate 
		lst2 = removeNullUsingIterator(lst2, nonNull); 
		// Print the list 
		System.out.println("lst2 with only null values: " + lst2); 
	} 
} 
