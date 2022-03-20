package com.stream.best_eherrera.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://ocpj8.javastudyguide.com/ch16.html
// ------ or -----------------------
// file:///D:/L.E.A.R.N/J.A.V.A_8/ocpj8-book-master/ocpj8-book-master/ch16.html

public class Computer implements Comparable<Computer> {
    private String brand;
    private int id;

    public Computer(String brand, int id) {
        this.brand = brand;
        this.id = id;
    }

    // Let's compare first by brand and then by id
    public int compareTo(Computer other) {
        // Reusing the implementation of String
        int result = this.brand.compareTo(other.brand);

        // If the objects are equal, compare by id
        if(result == 0) {
            // Let's do the comparison "manually"
            // instead of using Integer.valueOf(this.id).compareTo(other.id)
            // or Integer.compare(this.id, other.id)
            if(this.id > other.id) result = 1;
            else if( this.id < other.id) result = -1;
            // else result = 0;
        }
        return result;
    }

    // equals and compareTo must be consistent
    // to avoid errors in some cases
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Computer)) return false;
        return this.brand.equals(((Computer) other).brand)
            && this.id == ((Computer) other).id;
    }

    public static void main(String[] args) 
    {
        Computer c1 = new Computer("Lenovo", 1);
        Computer c2 = new Computer("Apple", 2);
        Computer c3 = new Computer("Dell", 3);
        Computer c4 = new Computer("Lenovo", 2);

        // Some comparisons
        System.out.println(c1.compareTo(c1)); // c1 == c1
        System.out.println(c1.compareTo(c2)); // c1 > c2
        System.out.println(c2.compareTo(c1)); // c2 < c1
        System.out.println(c1.compareTo(c4)); // c1 < c2
        System.out.println(c1.equals(c4)); // c1 != c2

        // Creating a list and sorting it
        List<Computer> list = Arrays.asList(c1, c2, c3, c4);
        Collections.sort(list);
        
        list.forEach(
           c -> System.out.format("%s-%d\n",c.brand,c.id)
        );
    }
}
