package com.methodreference.codersdesks;

//http://www.codersdesks.com/java-8-method-reference-with-example/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConstructorReferenceExample {

	public static void main(String[] args) {
		 
		List<Integer> integers = IntStream.range(1, 10).boxed()
	         .collect(Collectors.toCollection( ArrayList::new ));
	 
		System.out.println(integers);
	 
		}
	
}
