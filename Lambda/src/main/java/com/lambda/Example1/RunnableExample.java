package com.lambda.Example1;

public class RunnableExample 
{
	public static void main(String[] args) 
	{
        // create anonymous inner class object 
        new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                System.out.println("New thread created : [OLD WAY : Prior Java 8]"); 
            } 
        }).start(); 
		
        System.out.println("-------------------------------------------------------------------------------------------------");
		// Demonstratione Implementation of functional interface using lambda expressions 
		// lambda expression to create the object 
        new Thread(()-> 
        {
    	   System.out.println("New thread created. Using Lambda [JAVA 8 WAY]");
    	}).start(); 
        
        System.out.println("-------------------------------------------------------------------------------------------------");
        
		System.out.println("=== RunnableTest ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		// Lambda Runnable with block
		Runnable r3 = () -> {
			int i;
			for (i = 0; i < 3; i++)
				System.out.println("Hello world three!");

		};

		// Run em!
		r1.run();
		r2.run();
		r3.run();

	}
}
