package com.lambda.lambdaadvanced.infoworldjavaworld;
/*
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=2
        https://www.infoworld.com/article/3452018/get-started-with-lambda-expressions.html?page=3
*/
import java.awt.AWTException;

import java.io.IOException;

@FunctionalInterface
interface Work
{
   void doSomething() throws IOException, AWTException;
}

public class AdvancedLambdaExample8
{
   public static void main(String[] args) throws AWTException, IOException
   {
      Work work = () -> { throw new IOException(); };
      work.doSomething();
      work = () -> { throw new AWTException(""); };
   }
}