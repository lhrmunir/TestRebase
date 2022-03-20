package com.functionalinterface;

import java.util.function.Consumer;

// https://www.geeksforgeeks.org/functional-interfaces-java/

class GreatOldNewCompare 
{ 
    public static void main(String args[]) 
    { 
    	/*
  			TO USE THE " Runnable ", implementation of run() abstract method implementation MUST BE PROVIDED, 
  			OTHERWISE WILL THROW ERROR : [Cannot instantiate type Runnable because implementation of abstract run() is not provided.]
    	*/
    	
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
        
        // DEMO --- OF --- SHORTHAND ---- NOTATION ---------
		// Demonstratione Implementation of functional interface using lambda expressions 
		// lambda expression to create the object 
        new Thread(()-> 
        {
    	   System.out.println("New thread created. Using Lambda [JAVA 8 WAY]");
    	}).start(); 
        
        System.out.println("-------------------------------------------------------------------------------------------------");
        
        // Anonymous Runnable
     		Runnable r1 = new Runnable() {
     			@Override
     			public void run() {
     				System.out.println("Hello world one!");
     			}
     		};

     		// Lambda Runnable
     		Runnable r2 = () -> System.out.println("Hello world two ONLY!. Will be shown only if r2.run(); is called....");
     		
     		Runnable r2a = () ->  { System.out.println("Hello world two A!. CURLY BRACKETS ARE OPTIONAL WHEN ONLY ONE STATEMENT.... Will be shown only if r2a.run(); is called...."); }; 

     		// Lambda Runnable with block
     		Runnable r3 = () -> {
     			int i;
     			for (i = 0; i < 3; i++)
     				System.out.println("Hello world three!");

     		};

     		// Run em!
     		r1.run();
     		r2.run();
     		r2a.run();
     		r3.run();
     		
     		System.out.println("-------------------------------------------------------------------------------------------------");
     		
     		 System.out.println("Inside : " + Thread.currentThread().getName());

             System.out.println("Creating Runnable...");
             /*
              		FOLLOWING LINE WILL THROW ERROR : [Cannot instantiate type Runnable because implementation of abstract run() is not provided.]
               
              */
             // Runnable r4 = new Runnable();
             
             

             System.out.println("Creating Thread...");
             // Thread thread = new Thread(r4);

             System.out.println("Starting Thread...");
             // thread.start();
             
             System.out.println("-------------------------------------------------------------------------------------------------");
             
             
             /* --------------------- MUST ----- READ ---------- BELOW -------- CODE ---------------------------------------------
              * 
              * Passing parameter AAA and BBB to run() method of runnable3 as below 
              * commented code throws following compilation ERROR.
              * 
              * This demonstrates how we pass paramter to functional interface
              * 
                ************************************************************
                * 	Lambda expression's signature does not match the      * 
                *	signature of the functional interface method run()    *
                ************************************************************
               
             */
             /*
     			        final Runnable runnable3 = (String AAA, int BBB) -> {
     			        		System.out.println("Runnable two A" + AA);
     			        		System.out.println("Runnable two B" + BB);
     			        		System.out.println("Runnable two C");
     			        };
     			        
     			        runnable3.run();
     		*/
             
             Consumer<String> sCon = s -> System.out.println(s);
             
             Consumer<String> cons = System.out::println;
                                     
             cons.accept("HELLO"); // Pass "Hello" to lambda body. Print Hello to standard output.
             sCon.accept("Pakistan..."); 
    } 
    
    /* -- bELOW @Override run() method was required if implements Runnable like in old fashioned programs
			    @Override
			    public void run() {
			        System.out.println("Inside : " + Thread.currentThread().getName());
			    }
    */
    

    
} 