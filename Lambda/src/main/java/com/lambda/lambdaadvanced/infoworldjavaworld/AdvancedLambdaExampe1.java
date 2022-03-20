package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
public class AdvancedLambdaExampe1
{
   public static void main(String[] args)
   {
      new Thread(() -> System.out.println("Hello")).start();
   }
}