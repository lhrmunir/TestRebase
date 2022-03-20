package com.stream.best_eherrera.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://ocpj8.javastudyguide.com/ch12.html
// https://ocpj8.javastudyguide.com/ch16.html
// 

public class ReuseStreamExample01 
{

	 public static void main(String[] args) 
	 {
		 /* ------------------------- Meyhod *********** 01 ------------------------------- */
		 
		 List<String> words = Arrays.asList(new String[]{"james", "tommy", "holly", "tommy", "jennifer", "ramo", "tommy"});
		 
		 // ------------------------------------------------------------------------------------
		 
		 Stream<String> streamMethod1 = words.stream();
		 
		 streamMethod1.forEach(System.out::println);
		 
		// RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 
	/*	 
		 long streamElementCount = streamMethod1.count(); // RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 													 After the terminal operation is performed, the stream pipeline is consumed, and can't be used anymore.
		 
		 System.out.println("streamMethod1 : streamElementCount = " + streamElementCount);
		 streamMethod1.forEach(System.out::println);
    */
		 // ------------------------------------------------------------------------------------------------------------
		 
		 streamMethod1 = words.stream();
		 
		 long streamElementCount = streamMethod1.count(); 
		 
		 System.out.println("streamMethod1 : streamElementCount = " + streamElementCount);
		 
		 // streamMethod1.forEach(System.out::println); // RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 // After the terminal operation is performed, the stream pipeline is consumed, and can't be used anymore.
		 
		 // ------------------------------------------------------------------------------------------------------------
		 /*
		   							DEMONSTRATION OF REUSING THE STREAM
		  
		  */
		  Supplier<Stream<String>> wordSupplierStream = () -> words.stream();
		  
		  /*   ---------------------- MOST --------- IMPORTANT ------------------------------------------
		   
				   ---------- Gets following error if remove " () -> " from above statement:
				  
				   Supplier<Stream<String>> wordSupplierStream = words.stream(); 
				   
				   Type mismatch: cannot convert from Stream<String> to Supplier<Stream<String>>
		  */
		  
		 
		  wordSupplierStream.get().forEach(x -> System.out.println(x));

	      System.out.println("All Elements count in wordSupplierStream = " + wordSupplierStream.get().count());
	        
	      //get another new stream
	      long streamElementscount = wordSupplierStream.get().filter(x -> "tommy".equals(x)).count();
	        
	      System.out.println("Elements in wordSupplierStream with value 'tommy' = " + streamElementscount);
	        
        /* ------------------------- Meyhod *********** 02 ------------------------------- */
		 
	      Stream<String> stream = Stream.of("james", "tommy", "holly", "tommy", "jennifer", "ramo", "tommy");
	      
	      
		 /* ------------------------- Meyhod *********** 03 ------------------------------- */
		 
	      String[] wordsArray = {"james", "tommy", "holly", "tommy", "jennifer", "ramo", "tommy"};
	      Stream<String> streamNames = Stream.of(wordsArray);
		 
	      System.out.println("streamNames = ");
	      
	      streamNames.forEach(System.out::print); // will be printed as (due to print) : jamestommyhollytommyjenniferramotommy
	      
	      System.out.println("\n");
		 /* ------------------------- Meyhod *********** 04 (NOT RECOMMENDED) ------------------------------- */
		 
	      int[] nums = {1, 2, 3, 4, 5}; 
	      
	      // Stream.of(num); //NOT RECOMMENDED
	     
	      System.out.println("Stream.of(nums).count() = " + Stream.of(nums).count()); // It prints 1!
	      
	      /*
	       			WHY NOT RECOMMENDED : The reason is the signatures of the of method:
										  Read detail at : https://ocpj8.javastudyguide.com/ch12.html
										  
					// returns a stream of one element
					static <T> Stream<T> of(T t)
					// returns a stream whose elements are the specified values
					static <T> Stream<T> of(T... values)
					
					Since an int is not an object, but int[] is, the method chosen to create the stream is the first (Stream.of(T t)), 
					not the one with the vargs, so a stream of int[] is created, but since only one array is passed, 
					the result is a stream of one element.
	       */
		 
		 /* ------------------------- Meyhod *********** 05 ------------------------------- */
	      /*
	            RECOMMENDED SOLUTION OF (Not recommended method 04)
	      		To solve this, we can force Java to choose the vargs version by creating an array of objects (with Integer):
		  */
	      
	    	  Integer[] numsArr = {1, 2, 3, 4, 5};
	    	  
	    	  // It prints 5! i,e. CORRECT RESULT
	    	  System.out.println("Stream.of(numsArr).count() = " + Stream.of(numsArr).count());
	    	  
	    	  /* ------------------------- Meyhod *********** 06 ------------------------------- */  
	    	  
	    	  /*
	            ANOTHER RECOMMENDED SOLUTION OF (Not recommended method 04)
	      		To solve this, we can force Java to choose the vargs version by creating an array of objects (with Integer):
		  */
	    	  
	    	  
	    	int[] numsArr2 = {1, 2, 3, 4, 5};
	    	
	    	// It also prints 5!
	    	
	    	
	    	
//	    	if ( numsArr2 instanceof Array){
//	            System.out.println("numArr2 is instance of Array");
//	        }
	     
//	        //determining type of object in Java using getClass() method
//	        System.out.println("Checking type of object in Java using  getClass() ==>");
//	        if ( simpleRule.getClass() == Rule.class){
//	            System.out.println("System rule is instance of Rule");
//	        }

	    	
	    	System.out.println("Arrays.stream(numsArr2).count() = " + Arrays.stream(numsArr2).count());
	    	
	    	/* ------------------------- Meyhod *********** 07 (PRIMITIVE) ------------------------------- */
	    	
	    	int[] numsPrimitiveArray = {1, 2, 3, 4, 5};
	    	
	    	IntStream primitiveIntStream = IntStream.of(numsPrimitiveArray);
	    	// It also prints 5!
	    	
	    	System.out.println("primitiveIntStream count() = " + primitiveIntStream.count());
	    	
	    	// System.out.println("primitiveIntStream Elements = "); // java.lang.IllegalStateException: stream has already been operated upon or closed
	    	// primitiveIntStream.forEach(System.out::println);
	    	/*
	    	 * 			// https://ocpj8.javastudyguide.com/ch12.html
	    	 					Lesson learned: Don't use Stream<T>.of() when working with primitives.
	    	*/
	    	
	    	/* ------------------------- Meyhod *********** 08 [ INFINITE STREAM ]------------------------------- */
	    	
	    	// DoubleStream.generate, Stream.generate, . . .
	    	
	    	Stream<Double> generateStream = Stream.generate(new Supplier<Double>() {
	    	    public Double get() {
	    	        return Math.random();
	    	    }
	    	}).limit(5000);
	    	
	    	// ============================================              Or:

	    	Stream<Double> generateStream1 = Stream.generate(() -> Math.random()).limit(5000);

	    		// ============================================              Or:

	    	Stream<Double> generateStream2 = Stream.generate(Math::random).limit(5000);
	    	
	    	
	    	// generateStream.forEach(System.out::println);
	    	
	    	System.out.println("generateStream count() = " + generateStream.count());
	    	
	    	DoubleStream generatePrimDoubStream = DoubleStream.generate(new DoubleSupplier() {
	    	    public double getAsDouble() {
	    	        return Math.random();
	    	    }
	    	}).limit(5000);
	    	
	    	// ============================================              Or:

	    	DoubleStream generatePrimDoubStream1 = DoubleStream.generate(() -> Math.random()).limit(5000);

	    		// ============================================              Or:

	    	DoubleStream generatePrimDoubStream2 = DoubleStream.generate(Math::random).limit(5000);
	    	
	    	// System.out.println("generatePrimDoubStream count() = " + generatePrimDoubStream.count());
	    	
	    	System.out.println("generatePrimDoubStream Elements = " );
	    	
	    	generatePrimDoubStream.forEach(System.out::println);
	    	
	    	
	    	System.out.println("generatePrimDoubStream2 count() = " + generatePrimDoubStream2.count());
	    	
	    	/* ------------------------- Meyhod *********** 09  iterate / seed / UnaryOperator< - [ INFINITE STREAM ] ------------------------------- */
	    	
	    	/*
	    		This method returns an "infinite" stream produced by the iterative application of a function f to an initial element seed. 
	    		The first element (n = 0) in the stream will be the provided seed. For n > 0, the element at position n will be the result 
	    		of applying the function f to the element at position n - 1. For example:
			*/
	    	
	    		Stream<Integer> iterateStream1 = Stream.iterate(1, new UnaryOperator<Integer>() {
	    		    @Override
	    		    public Integer apply(Integer t) {
	    		        return t * 2; }
	    		}).limit(10);

	    	// =============================================================================	Or just:

	    		Stream<Integer> iterateStream2 = Stream.iterate(1, t -> t * 2).limit(10);
	    		
	    		System.out.println("iterateStream2 Elements = " );
		    	
	    		iterateStream2.forEach(System.out::println);
	    	
	    	/* ------------------------- Meyhod *********** 10 Stream.Builder<T>  ------------------------------- */
	    	
	    		Stream.Builder<String> builder =
	    			    Stream.<String>builder()
	    			       .add("h").add("e").add("l").add("l");
	    		
    			builder.accept("o");
    			Stream<String> streamFromBuilder = builder.build();
    			
    			System.out.println("streamFromBuilder Elements = " );
		    	
    			streamFromBuilder.forEach(System.out::println);	
	    	/* ------------------------- Meyhod *********** 11 ------------------------------- */
	 }
}

