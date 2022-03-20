package com.functionalinterface.fiPredicate.geeksforgeeks;

/*
	https://www.geeksforgeeks.org/remove-elements-from-a-list-that-satisfy-given-predicate-in-java/
	Java Program to remove nulls from a List using Java 8 ArrayList.RemoveIF()
*/

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*; 

class GenericPredicateRemoveIfListDemo
{ 
		 // Generic function to remove elements using Predicate 
		 public static <T> List<T> removeElementsUsingPredicate(List<T> list, Predicate<T> pred) 
		 { 
			    // Removing nulls using Java Stream using Predicate condition in removeIf() 
			 	list.removeIf(x -> pred.test(x)); 
			
			    // Return the list  
			    return list; 
		 } 
		
		 public static void main(String[] args) 
		 { 
			     // Create a list with null values 
			     List<String> lstA = new ArrayList<>( Arrays.asList("Geeks", 
											                       null, 
											                       "forGeeks", 
											                       null, 
											                       "A computer portal")); 
			
				List<String> lstB = lstA.stream().collect(Collectors.toList());
				
				lstA.add(0, "This is lstA");
				lstB.add(0, "This is lstB");
				
				// Print the lists 
				System.out.println("First List with null values: " + lstA); 
				System.out.println("Second List with null values: " + lstB); 
					
					
			
				// Creating a Predicate condition checking for null 
				// Predicate<String> nonNull = item -> Objects.nonNull(item);
				Predicate<String> nonNull = i -> (i != null); 
				// Creating a Predicate condition checking for null 
				// Predicate<String> isNull = item -> Objects.isNull(item);
				Predicate<String> isNull = i -> (i == null);
		
		     
				// Removing using Predicate 
				lstA = removeElementsUsingPredicate(lstA, isNull); 
				// Print the list 
				System.out.println("lstA with null values REMOVED: " + lstA); 
					
					
				// Removing using Predicate 
				lstB = removeElementsUsingPredicate(lstB, nonNull); 
				// Print the list 
				System.out.println("lstB with only null values: " + lstB); 
		} 
} 
