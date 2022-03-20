package com.methodreference.advancedexample02;

/*
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html
      https://www.infoworld.com/article/3453296/get-started-with-method-references-in-java.html?page=2
*/
import java.util.function.Consumer;

class Superclass
{
   void print(String msg)
   {
      System.out.printf("STEP 3: Superclass print(): %s%n", msg);
   }
}

class Subclass extends Superclass
{
   Subclass()
   {
      System.out.println("STEP 2 : just entered in constructor of Subclass()....\n");
      Consumer<String> consumer = Subclass.super::print;
      consumer.accept("STEP 4 : Subclass.super::print");
      consumer = this::print;
      consumer.accept("STEP 6 : this::print");
   }

   @Override
   void print(String msg)
   {
      System.out.printf("STEP 5 : Subclass print(): %s%n", msg);
   }
}

public class MethodReferenceExample6
{
   public static void main(String[] args)
   {
      System.out.println("STEP 1 : just entered in main() of MethodReferenceExample6 class\n");
      new Subclass();
   }
}