package com.ralphapress2019code.chapter12;
import java.util.stream.Stream;
public class Sect8_Ex1 
{
    public static void main(String[] args)
    {
        Stream.of(1, 2, 3, 4, 5)                      // Stream(Integer)
              .reduce( (x,y) -> x * y)                // Optional(Integer)
              .ifPresent(x -> System.out.println(x)); // Prints 120

        Double x = Stream.of(1.0, 2.1, 3.3, 4.1, 5.2)                      // Stream(Integer)
                .reduce(0.0, Double::sum); // Prints 120

        System.out.println(Stream.of(1.0, 2.1, 3.3, 4.1, 5.2)                      // Stream(Integer)
                .reduce(0.0, Double::sum));

        System.out.println(Stream.of(1.0, 2.1, 3.3, 4.1, 5.2)                      // Stream(Integer)
                .reduce(0.0, Double::max));

        System.out.println(Stream.of(1.0, 2.1, 3.3, 4.1, 5.2)                      // Stream(Integer)
                .reduce(0.0, Double::min));

        Stream.of(1.0, 2.1, 3.3, 4.1, 5.2)                      // Stream(Integer)
                .reduce((q, p) -> q * 2)
                .ifPresent(x2 -> System.out.println(x2)); // Prints 120;

        Stream.of(1.0, 2.1, 3.3, 4.1, 5.2)                      // Stream(Integer)
                .reduce((q, p) -> p * 2)
                .ifPresent(x2 -> System.out.println(x2)); // Prints 120;

    }
}