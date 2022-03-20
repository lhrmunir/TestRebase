package com.lambda.kraskovskilambda;

import com.lambda.functional.Converter; // from package com.functionainterface.kraskovskiinterfaces.functional;

public class LambdaExpressionsExample {

    public static void main(String... args) {
        withCustomInterface();
        withRunnable();
    }

    private static void withCustomInterface() {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

        Expression expr = methodReference();
        System.out.println(sum(nums, expr));
        System.out.println(sum(nums, ExpressionHelper::isEven));
    }

    private static int sum(int[] numbers, Expression expression) {
        int result = 0;
        for (int i : numbers) {
            if (expression.isEqual(i))
                result += i;
        }
        return result;
    }

    private static Expression methodReference() {
        // Standart lambda expression.
        Expression expressionOld = number -> ExpressionHelper.isPositive(number);
        // method reference.
        Expression expressionNew = ExpressionHelper::isPositive;
        Converter<String, Integer> converter = String::length;
        return expressionNew;
    }

    private static void withRunnable() {
        // Old Runnable
        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable one");
            }
        };
        // Lambda Runnable - Single statement
        final Runnable runnable2 = () -> System.out.println("Runnable two");
        
        // Lambda Runnable - Multiple statements
        /*
         * Passing parameter AAA and BBB to run() method of runnable3 as below 
         * commented code throws following compilation ERROR.
         * 
         * This demonstrates how we pass paramter to functional interface
         * 
           ************************************************************
           * 	Lambda expression's signature does not match the      * 
           *	signature of the functional interface method run()    *
           ************************************************************
          
        */
        /*
			        final Runnable runnable3 = (String AAA, int BBB) -> {
			        		System.out.println("Runnable two A" + AA);
			        		System.out.println("Runnable two B" + BB);
			        		System.out.println("Runnable two C");
			        };
			        
			        runnable3.run();
		*/
        runnable1.run();
        runnable2.run();

    }
}
