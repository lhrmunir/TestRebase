package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
public class AdvancedLambdaExample5
{
   public static void main(String[] args)
   {
      int limit = 10;
      Runnable r = () -> {
                           // =======> int limit = 5;           // THIS VARIABLE IS ALREADY DEFINED IN OUTER SCOPE
                                                                // ERROR MESSAGE : Variable 'limit' is already defined in the scope
                           for (int i = 0; i < limit; i++)
                              System.out.println(i);
                         };
   }
}