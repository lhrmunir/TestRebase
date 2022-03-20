package com.methodreference.advancedexample02;
/*
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html?page=2
*/
import java.util.function.Supplier;

public class MethodReferenceExample2
{
   public static void main(String[] args)
   {
      String s = "The quick brown fox jumped over the lazy dog";

      print(s::length);

      print(() -> s.length());

      print(new Supplier<Integer>() {
                     @Override
                     public Integer get()
                     {
                        return s.length() / 4; // closes over s
                     }
      });
   }

   public static void print(Supplier<Integer> supplier)
   {
      System.out.println("inside print() : supplier.get() = " + supplier.get());
   }
}