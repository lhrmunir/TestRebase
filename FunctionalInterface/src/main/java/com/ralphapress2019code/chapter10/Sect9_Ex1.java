package com.ralphapress2019code.chapter10;
import static com.ralphapress2019code.chapter10.Sect1_Ex1.removeVowels;
import java.util.*;
public class Sect9_Ex1 
{
    public static void main(String[] args)
    {
        Comparator<String> byConsonants = (x,y) ->
                removeVowels(x).compareTo(removeVowels(y));

        TreeMap<String,String> pets = new TreeMap<>(byConsonants);

        pets.put("gerbil", "small cute rodents");
        pets.put("guinea pig", "rodents, not pigs");
        pets.put("cat", "have nine lives");
        pets.put("chicken", "more populous than people");

        pets.forEach((x,y) -> System.out.println(x + ", " + y));
    }
}
