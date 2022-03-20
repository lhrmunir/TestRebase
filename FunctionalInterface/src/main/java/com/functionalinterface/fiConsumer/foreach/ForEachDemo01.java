package com.functionalinterface.fiConsumer.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

// https://www.journaldev.com/2389/java-8-features-with-examples

public class ForEachDemo01 {

	public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+t);
			}

		});
		
		//traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
		
        System.out.println("==================================== BELOW PRIOR JAVA 8 [OLD WAY] ==========================================================");
        
        // https://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html
        
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API"); 
        
        // Prior Java 8 : 
        for (String feature : features) { System.out.println(feature); } 
        
        System.out.println("========================================= BELOW JAVA 8 WAY ================================================================");
        
        // In Java 8: 
        features.forEach(n -> System.out.println(n)); 
        
        System.out.println("========================== BELOW JAVA 8 WAY [SHORTHAND NOTATION FOR METHOD REFERENCE] ======================================");
        
        // Even better use Method reference feature of Java 8 
        // method reference is denoted by :: (double colon) operator 
        features.forEach(System.out::println);
	}

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}


}