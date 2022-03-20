package com.stream.best_eherrera.streams;

// https://ocpj8.javastudyguide.com/ch12.html
// Demonstrate Lazy Operation and Short Circuiting

import java.util.stream.Stream;

public class LazyOperationDemo_01 
{

	public static void main(String[] args) 
	{
		/*
		 	Lazy operations
		 	================
			Intermediate operations are deferred until a terminal operation is invoked. 
			The reason is that intermediate operations can usually be merged or optimized 
			by a terminal operation.
		*/
		
		// Let's take for example this stream pipeline:
		
		Stream.of("sun", "pool", "beach", "kid", "island", "sea", "sand")
	    .map(str -> str.length())
	    .forEach(System.out::println);
		
		System.out.println("==================================================================================");
		
		Stream.of("sun", "pool", "beach", "kid", "island", "sea", "sand")
		    .map(str -> str.length())
		    .filter(i -> i > 3)
		    .limit(2)
		    .forEach(System.out::println);
		
		/*
		 	Here's what it does:
			============================
				o  It generates a stream of strings,
				o  Then convert the stream to a stream of ints (representing the length of each string)
				o  Then it filters the lengths greater than three,
				o  Then it grabs the first two elements of the stream and
				o  Finally, prints those two elements.
				o  And you may think the map operation is applied to all seven elements, 
				   then the filter operation again to all seven, then it picks the first two, 
				   and finally it prints the values.
				
			**	But this is not how it works. If we modify the lambda expressions of map and filter to print a message:

	    */
		
		Stream.of("sun", "pool", "beach", "kid", "island", "sea", "sand")
	    .map(str -> {
	        System.out.println("Mapping: " + str);
	        return str.length();
	    })
	    .filter(i -> {
	        System.out.println("Filtering: " + i);
	        return i > 3;
	    })
	    .limit(2)
	    .forEach(x -> System.out.println("x = " + x));
		

		/*
		 		From this example, we can see the stream didn't apply all the operations on the pipeline to all elements, 
		 		only until if it finds the elements needed to return a result (due to the limit(2) operation). 
		 		This is called short-circuiting.

				Short-circuit operations cause intermediate operations to be processed until a result can be produced.
				
				From this example, we can see the stream didn't apply all the operations on the pipeline to all elements, 
				only until if it finds the elements needed to return a result (due to the limit(2) operation). This is called short-circuiting.

				Short-circuit operations cause intermediate operations to be processed until a result can be produced.
				
				You can see short-circuiting as a subclassification. There's only one short-circuit intermediate operation, while the rest are terminal:
				
				INTERMEDIATE SHORT CIRCUITING OPERATION
				==========================================
						Stream<T> limit(long maxSize)

						(Because it doesn't need to process all the elements of the stream to create a stream of a given size)

				TERMINAL SHORT CIRCUITING OPERATION
				==========================================
						boolean anyMatch(Predicate<? super T> predicate)
						boolean allMatch(Predicate<? super T> predicate)
						boolean noneMatch(Predicate<? super T> predicate)
						Optional<T> findFirst()
						Optional<T> findAny()

						(Because as soon as you find a matching element, there's no need to continuing processing the stream)
		 */
	}

}
