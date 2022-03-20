package com.patterns.tutorialspoint.structural.composite;

/*
Step 2
        Use the Employee class to create and print employee hierarchy.

        CompositePatternDemo.java
*/
public class CompositePatternDemo {
    public static void main(String[] args) {

        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        // print all employees of the organization
        System.out.println("going to print CEO >>>>> CEO = ;" + CEO + ";");
        // System.out.println(CEO);

        // for (Employee headEmployee : CEO.getSubordinates()) {
        CEO.getSubordinates().stream().forEach(headEmployee -> {
            System.out.println("going to print headEmployee >>>>> headEmployee = ;" + headEmployee + ";");
            // System.out.println(headEmployee);

            // for (Employee employee : headEmployee.getSubordinates()) {
            headEmployee.getSubordinates().forEach(employee -> {

                System.out.println("going to print employee >>>>> employee = ;" + employee + ";");
                // System.out.println(employee);
            });
        });
    }
}