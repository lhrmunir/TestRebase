package com.methodreference.advancedexample02;
/*
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html?page=2
*/

import java.util.function.Supplier;

public class MethodReferenceExample4
{
   public static void main(String[] args)
   {
      Supplier<MethodReferenceExample4> supplier = MethodReferenceExample4::new;


      System.out.println("\nMethodReferenceExample4::new DID BOT CALLED THE CONSTRUCTOR SO FAR ");
      System.out.println("AND OBJECT OF MethodReferenceExample4 CLASS IS NOT CREATED. ");
      System.out.println("supplier.get() WILL CALL THE CONSTRUCTOR AND \n");
      System.out.println("WILL PRINT NAME OF NEWLY CREATED OBJECT");


      System.out.println(supplier.get());
   }
}