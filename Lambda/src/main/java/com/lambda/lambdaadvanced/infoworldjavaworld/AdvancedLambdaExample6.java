package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
public class AdvancedLambdaExample6
{
   public static void main(String[] args)
   {
      int limit = 10;
      Runnable r = () -> {
                           // ====== > limit = 5;               // ERROR MESSAGE : Variable used in lambda expression should be final or effectively final

                           for (int i = 0; i < limit; i++)
                              System.out.println(i);
                         };
   }
}