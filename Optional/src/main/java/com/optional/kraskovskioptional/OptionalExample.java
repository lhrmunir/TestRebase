package com.optional.kraskovskioptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
		https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
		
*/
public class OptionalExample 
{

    public static void main(String... args) 
    {
        optionalTypes();
        ifPresent();
        get();
        withFilter();
        withMap();
        orElse();
        orElseThrow();
     // isPresent();   // Produce NullPointerException PROGRAMATICALLY
    }

    private static void optionalTypes() 
    {
        // Empty Optional container
        Optional<String> empty = Optional.empty();
        // System.out.println("[ learning optionalTypes() ] : Optional.empty().get() = " + empty.get()); // will throw Exception in thread "main" java.util.NoSuchElementException: No value present
        
        
        // Of some value, can't be null!
        Optional<String> of = Optional.of("pakistan");
        System.out.println("[ learning optionalTypes() ] : Optional.of(\"pakistan\") = " + of);
        System.out.println("[ learning optionalTypes() ] : of.ofNullable(of) = " + of.ofNullable(of));
        
        // Of any value, can be null
        Optional<String> ofNullable = Optional.ofNullable(null);
        
        System.out.println("[ learning optionalTypes() ] : Optional.ofNullable(\"japan\") = " + Optional.ofNullable("japan"));
        System.out.println("[ learning optionalTypes() ] : Optional.ofNullable(of) = " + Optional.ofNullable(of));
        System.out.println("[ learning optionalTypes() ] : Optional.ofNullable(null) = " + Optional.ofNullable(null));
        
    }

    private static void isPresent() 
    {
        System.out.println("[ learning isPresent() ] : " + Optional.of("string").isPresent());
        System.out.println("[ learning isPresent() ] : " + Optional.of(null).isPresent()); //Produce NullPointerException
        System.out.println("[ learning isPresent() ] : " + Optional.ofNullable(null).isPresent());
    }

    private static void ifPresent() 
    {
        Optional<String> value1 = Optional.of("pakistan");
        value1.ifPresent(s -> System.out.println("[ learning ifPresent() ] : " + value1.isPresent()));
        
        // dish.ifPresent(d -> System.out.println(d.getName()));
        value1.ifPresent(s -> System.out.println("[ learning ifPresent() ] : " + s.toUpperCase()));
        //
        
        // Optional<String> value2 = Optional.of(null); // will throw NullPointerException
    }

    private static void orElse() 
    {
        String nullValue = null;
        String value = Optional.ofNullable(nullValue).orElse("string");
        System.out.println("[ learning orElse() ] : " + value);
    }

    private static void orElseThrow() 
    {
        String nullValue = null;
        Optional.ofNullable(nullValue).orElseThrow(IllegalStateException::new);
    }

    private static void get() 
    {
        Optional<String> value = Optional.of("string");
        String result = value.get();
    }

    private static void withFilter() 
    {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        
        System.out.println("[ learning withFilter() ] : " + is2016);
        
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        
        System.out.println("[ learning withFilter() ] : " + is2017);

        System.out.println("[ learning withFilter() ] : " + priceIsInRange(new Modem(10.5)));
    }

    private static boolean priceIsInRange(Modem modem2) 
    {
        return Optional.ofNullable(modem2)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

    private static void withMap() 
    {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional
                .map(List::size)
                .orElse(0);
        
        System.out.println("[ learning withMap() ] : " + size);

        /////////////////////////////////////////////

        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
        
        System.out.println("[ learning withMap() ] : " + correctPassword);

        correctPassword = passOpt
                .map(String::trim)
                .filter(pass -> pass.equals("password"))
                .isPresent();
        
        System.out.println("[ learning withMap() ] : " + (correctPassword));
    }
}