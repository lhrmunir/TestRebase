package com.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    static class Point {
        Double x, y;

        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String... args) {
        Point point = new Point(1.0, 2.0);

        Consumer<Point> pointPrinter1 = (p) -> System.out.printf("x = %f, y = %f\n", p.x, p.y);
        Consumer<Point> pointPrinter2 = (p) -> System.out.printf("(%f, %f)\n", p.x, p.y);

        pointPrinter1.accept(point);
        pointPrinter2.accept(point);
        
        System.out.println("========================== BELOW JAVA 8 WAY [SHORTHAND NOTATION FOR METHOD REFERENCE] ======================================");
        
        Consumer<String> sCon = s -> System.out.println(s);
        
        Consumer<String> cons = System.out::println;
                                
        cons.accept("HELLO"); // Pass "Hello" to lambda body. Print Hello to standard output.
        sCon.accept("Pakistan..."); 
        
        System.out.println("==================================== BELOW PRIOR JAVA 8 [OLD WAY] ==========================================================");
        
        // https://javarevisited.blogspot.com/2014/02/10-example-of-lambda-expressions-in-java8.html
        
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API"); 
        
        // Prior Java 8 : 
        for (String feature : features) { System.out.println(feature); } 
        
        System.out.println("========================================= BELOW JAVA 8 WAY ================================================================");
        
        // In Java 8: 
        features.forEach(n -> System.out.println(n)); 
        
        System.out.println("========================== BELOW JAVA 8 WAY [SHORTHAND NOTATION FOR METHOD REFERENCE] ======================================");
        
        // Even better use Method reference feature of Java 8 
        // method reference is denoted by :: (double colon) operator 
        features.forEach(System.out::println);
    }
}
