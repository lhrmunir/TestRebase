package com.functionalinterface.fiConsumer.foreach;

// http://www.codersdesks.com/java-8-feature-for-each-method/
	
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/*
		Java 8 forEach method in java.lang.Iterable Interface.
		The implementation of forEach method in Iterable interface is:

								default void forEach(Consumer<? super T> action) {
								        Objects.requireNonNull(action);
								        for (T t : this) {
								            action.accept(t);
								        }
								    }

		Whenever we needs to traverse over a collection we have to create an Iterator 
		to iterate over the collection and then we can have our business logic inside a 
		loop for each of the elements inside the collection. 
		
		We may greeted with ConcurrentModificationException if it is not implemented properly.
*/

public class ForEachManyWaysDemo01 {

	public static void main(String[] args) 
	{
		List<String> data = new ArrayList<>();
		data.add("New Delhi");
		data.add("New York");
		data.add("Mumbai");
		data.add("London");
		
		/* =============================================================================
		 					DEMO WITHOUT FOREACH USAGE
		  ============================================================================== */
				Iterator<String> itr = data.iterator();
				while(itr.hasNext())
				{   
				    System.out.println("DEMO WITHOUT FOREACH USAGE : " + itr.next());
				       //data.remove(itr.next()); // this line can introduce you to java.util.ConcurrentModificationException.
				}
		
				System.out.println("\n");
		/* =============================================================================
			DEMO WITH FOREACH USAGE
		============================================================================== */		
	
				data.forEach(new Consumer<String>() {
					 
				    @Override
				    public void accept(String t) {
				         
				        System.out.println("DEMO WITH FOREACH USAGE : " + t);
				    }
				     
				});
		
				System.out.println("\n");
		/* =============================================================================
				DEMO WITHOUT FOREACH USING CLASS IMPLEMENTS CONSUMER INTERFACE
			============================================================================== */			
		
				CityConsumer cityConsumer = new CityConsumer();
				data.forEach(cityConsumer);
	}
}
