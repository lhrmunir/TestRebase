package com.comparator;
/*
    https://www.baeldung.com/java-8-sort-lambda
    https://www.callicoder.com/java-comparable-comparator/
*/
import com.comparable.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorCallicoderEx1
{
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
        employees.add(new Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));
        employees.add(new Employee(15, "Fifteen", 134000.00, LocalDate.of(2008, 9, 28)));
        employees.add(new Employee(99, "Ninety Nine", 134000.00, LocalDate.of(2005, 9, 28)));

        System.out.println("Employees : " + employees);

        // Sort employees by Name
        Comparator<Employee> employeeNameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };

        /*
        The above Comparator can also be written using lambda expression like so =>
        employeeNameComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());

        Which can be shortened even further using Java 8 Comparator default method
        employeeNameComparator = Comparator.comparing(Employee::getName)
        */

        Collections.sort(employees, employeeNameComparator);
        System.out.println("\nEmployees (Sorted by Name) : " + employees);

        // Sort employees by Salary
        Comparator<Employee> employeeSalaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1.getSalary() < e2.getSalary()) {
                    return -1;
                } else if (e1.getSalary() > e2.getSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };

        Collections.sort(employees, employeeSalaryComparator);
        System.out.println("\nEmployees (Sorted by Salary) : " + employees);

        // Sort employees by JoiningDate
        Comparator<Employee> employeeJoiningDateComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getJoiningDate().compareTo(e2.getJoiningDate());
            }
        };

        Collections.sort(employees, employeeJoiningDateComparator);
        System.out.println("\nEmployees (Sorted by JoiningDate) : " + employees);
    }
}