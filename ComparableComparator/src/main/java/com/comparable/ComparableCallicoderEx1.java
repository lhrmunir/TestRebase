package com.comparable;

/*
    https://www.baeldung.com/java-8-sort-lambda
    https://www.callicoder.com/java-comparable-comparator/
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableCallicoderEx1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
        employees.add(new Employee(15, "Fifteen", 134000.00, LocalDate.of(2017, 9, 28)));
        employees.add(new Employee(99, "Ninety Nine", 134000.00, LocalDate.of(2017, 9, 28)));

        System.out.println("Employees (Before Sorting) : " + employees);

        // This will use the `compareTo()` method of the `Employee` class to compare two employees and sort them.
        Collections.sort(employees);

        System.out.println("\nEmployees (After Sorting) : " + employees);
    }
}
