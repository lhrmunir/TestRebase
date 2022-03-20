package com.methodreference.advancedexample02;
/*
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html?page=2
*/
import java.util.Arrays;

import java.util.function.Consumer;

public class MethodReferenceExample1
{
   public static void main(String[] args)
   {
      System.out.println("\nDEMONSTRATION OF 3 (three) DIFFERENT USAGES OF FUNCTIONAL INTERFACE \n");

      int[] array = { 10, 2, 19, 5, 17 };

      Consumer<int[]> consumer = Arrays::sort;
      consumer.accept(array);

      for (int i = 0; i < array.length; i++)
         System.out.print(array[i] + ", ");

      System.out.println();

      int[] array2 = { 19, 5, 14, 3, 21, 4 };

      Consumer<int[]> consumer2 = (a) -> Arrays.sort(a);
      consumer2.accept(array2);

      for (int i = 0; i < array2.length; i++)
         System.out.print(array2[i] + ", ");
   }
}