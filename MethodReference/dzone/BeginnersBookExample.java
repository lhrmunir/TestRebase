package com.methodreference.dzone;

@FunctionalInterface 
interface MyInterface{  
    void display();  
}  
public class BeginnersBookExample {  
    public void myMethod(){  
	System.out.println("Instance Method");  
    }  
    public static void main(String[] args) {  
    	BeginnersBookExample obj = new BeginnersBookExample();   
	// Method reference using the object of the class
	MyInterface ref = obj::myMethod;  
	// Calling the method of functional interface  
	ref.display();  
    }  
}
