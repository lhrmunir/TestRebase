package com.methodreference.advancedexample02;
/*
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html?page=2
*/
import java.util.function.Function;

public class MethodReferenceExample5
{
   private String name;

   MethodReferenceExample5(String name)
   {
      this.name = name;
      System.out.printf("MethodReferenceExample5(String name) called with %s%n", name);
   }

   public static void main(String[] args)
   {
      Function<String, MethodReferenceExample5> function = MethodReferenceExample5::new;

      System.out.println("\nMethodReferenceExample5::new DID BOT CALLED THE CONSTRUCTOR SO FAR ");
      System.out.println("AND OBJECT OF MethodReferenceExample5 CLASS IS NOT CREATED. ");
      System.out.println("function.apply WILL CALL THE CONSTRUCTOR AND PASS 'MUNIR AHMAD' TO CONSTRUCTOR\n");

      System.out.println(function.apply("MUNIR AHMAD"));


      System.out.println("\n");
      System.out.println("-----PLEASE NOTE------:");
      System.out.println("=======================");
      System.out.println("System.out.println INSIDE CONSTRUCTOR PRINTED 'MethodReferenceExample5(String name) called with MUNIR AHMAD'");
      System.out.println("System.out.println(function.apply(\"MUNIR AHMAD\")); WILL PRINT NAME OF NEWLY CREATED OBJECT.");


      /*
            Function<String, MethodReferenceExample5> function2 = new MethodReferenceExample5("RIAZ KHAN");

            ABOVE LINE WILL THROW FOLLOWING ERROR:
            ======================================
            Required type:    Function <java.lang.String, com.methodreference.advancedexample02.MethodReferenceExample5>
            Provided:         MethodReferenceExample5
       */
   }
}