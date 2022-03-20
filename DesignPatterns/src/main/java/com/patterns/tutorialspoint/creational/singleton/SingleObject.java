package com.patterns.tutorialspoint.creational.singleton;

/*
        Step 1:
        ========
        Create a Singleton Class.
*/
public class SingleObject {

    // create an object of SingleObject
    private static SingleObject instance = new SingleObject();

    /* ------------------------------------------------------------------------------------
            MAKE THE CONSTRUCTOR() PRIVATE SO THAT THIS CLASS CAN NOT BE  INSTANTIATED
       ------------------------------------------------------------------------------------
    */
    private SingleObject(){}

    // Get the only object available
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
