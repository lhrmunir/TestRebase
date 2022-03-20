package com.methodreference.advancedArpitMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortByColorCodeMain {

    public static void main(String[] args) {
        // Sort list of colors by name

        List<Color> listOfColors = getListOfColors();
        System.out.println("==========================");
        System.out.println("Using Lambda expressions");
        System.out.println("==========================");

        // Using lambda expressions
        List<String> sortedListOfColorNames = listOfColors.stream()
                .map(c -> c.getName())
                .sorted((c1, c2) -> c1.compareTo(c2))
                .collect(Collectors.toList());

        sortedListOfColorNames.forEach(System.out::println);
        System.out.println("==========================");
        System.out.println("Using Method reference");
        System.out.println("==========================");

        // Using MethodReference
        List<String> sortedListOfColorNamesMR = listOfColors.stream()
                .map(Color::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        sortedListOfColorNamesMR.forEach(System.out::println);

    }

    public static List<Color> getListOfColors() {

        List<Color> listOfColors = new ArrayList<>();

        Color red = new Color("Red", "#FF0000");
        Color blue = new Color("Blue", "0000FF");
        Color white = new Color("White", "#FFFFFF");
        Color green = new Color("Green", "#008000");

        listOfColors.add(red);
        listOfColors.add(blue);
        listOfColors.add(white);
        listOfColors.add(green);

        return listOfColors;
    }

}
