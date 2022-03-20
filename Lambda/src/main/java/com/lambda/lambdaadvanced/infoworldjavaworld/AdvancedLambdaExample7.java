package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
public class AdvancedLambdaExample7
{
   public static void main(String[] args)
   {
      new AdvancedLambdaExample7().doWork();
   }

   public void doWork()
   {
      System.out.printf("this = %s%n", this);
      Runnable r = new Runnable()
      {
         @Override
         public void run()
         {
            System.out.printf("this = %s%n", this);
         }
      };
      new Thread(r).start();
      new Thread(() -> System.out.printf("this = %s%n", this)).start();
   }
}