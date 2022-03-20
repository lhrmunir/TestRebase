package com.assortedgood.example1;

public class BeforeAndAfterJava8 {

    public static MyInterface myInterface = (p1, p2) -> { System.out.println("inside myInterface" + p2 + p1); return p2 + p1; };

    public static void main(String [] a)
    {
        // System.out.println(myInterface(2, 7));

        // System.out.println(myInterface.doSomething(2, " Apples"));

        new Thread(() -> myInterface.doSomething(10, " . . . Apples . . . ")).start();

        // For example, you can create a new thread very quickly:
        new Thread(() -> myInterface.doSomething(20, " . . . Apples . . . ")).start();

        // And use the method reference syntax to make it even cleaner:
 /*  ERROR */       // new Thread(() -> MyInterface::doSomething(2, " . . . Apples . . . ")).start();

        // Without lambda expressions, these last two examples would look like:
        /*
                    Syntax
                                @FunctionalInterface
                                public interface Runnable {
                                 void run();
                                }
         */
        Runnable r1 = new Runnable() {
            @Override
            public void run() { // anonymous class
                myInterface.doSomething(30, " . . . from Anonymous Inner Class : Runnable - run() . . . ");
            }
        };

        Runnable r2 = () -> {   // lambda expression
            myInterface.doSomething(40, " . . . from Runnable - Lambda  . . . ");
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
