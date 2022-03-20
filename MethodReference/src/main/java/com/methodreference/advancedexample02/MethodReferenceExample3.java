package com.methodreference.advancedexample02;
/*
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html?page=2
*/
import java.util.function.Function;

public class MethodReferenceExample3
{
   public static void main(String[] args)
   {
       System.out.println("\nDEMONSTRATION OF 3 (three) DIFFERENT USAGES OF FUNCTIONAL INTERFACE \n");

       print(String::toLowerCase, "1st METHOD : CONVERTED TO LOWERCASE USING METHOD REFERENCE");    // USING METHOD REFERENCE
       print(s -> s.toLowerCase(), "2nd METHOD : CONVERTED TO LOWERCASE USING LAMBDA");             // USING LAMBDA

        print(new Function<String, String>() {
                  @Override
                  public String apply(String s) // receives argument in parameter s;
                  {                             // doesn't need to close over s
                     return s.toLowerCase();
                  }
               },
              "3rd METHOD : CONVERTED TO LOWERCASE USING INNER CLASS");
   }

   public static void print(Function<String, String> function, String s)
   {
      System.out.println(function.apply(s));
   }
}