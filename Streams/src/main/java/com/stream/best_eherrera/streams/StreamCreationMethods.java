package com.stream.best_eherrera.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

// https://ocpj8.javastudyguide.com/ch12.html
// https://ocpj8.javastudyguide.com/ch16.html

public class StreamCreationMethods 
{

	 public static void main(String[] args) 
	 {
		 /* ------------------------- Meyhod *********** 01 ------------------------------- */
		 
		 List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
		 Stream<String> streamMethod1 = words.stream();
		 
		 streamMethod1.forEach(System.out::println);
		 
		// RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 
	/*	 
		 long streamElementCount = streamMethod1.count(); // RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 
		 System.out.println("streamMethod1 : streamElementCount = " + streamElementCount);
		 streamMethod1.forEach(System.out::println);
    */
		 // ------------------------------------------------------------------------------------------------------------
		 
		 streamMethod1 = words.stream();
		 
		 long streamElementCount = streamMethod1.count(); 
		 
		 System.out.println("streamMethod1 : streamElementCount = " + streamElementCount);
		 
		 // streamMethod1.forEach(System.out::println); // RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 
		 
		 // ------------------------------------------------------------------------------------------------------------
		 
		 // SOLUTION TO ABOVE PROBLEM : RUNTIME ERROR : java.lang.IllegalStateException: stream has already been operated upon or closed
		 
		 // https://mkyong.com/java8/java-stream-has-already-been-operated-upon-or-closed/
		 
		 String[] array = {"a", "b", "c", "d", "b", "e", "b"};

	     Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        System.out.println("All Elements count in Stream = " + streamSupplier.get().count());
        
        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        
        System.out.println("Elements in Stream with value 'b' = " + count);
	       
        // ------------------------------------------------------------------------------------------------------------
        
        
	        
        /* ------------------------- Meyhod *********** 02 ------------------------------- */
		 
		 
		 /* ------------------------- Meyhod *********** 03 ------------------------------- */
		 
		 
		 
		 /* ------------------------- Meyhod *********** 04 ------------------------------- */
		 
		 
		 
		 /* ------------------------- Meyhod *********** 05 ------------------------------- */
	 }
}
