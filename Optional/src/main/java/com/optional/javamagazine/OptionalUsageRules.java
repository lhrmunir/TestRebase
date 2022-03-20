package com.optional.javamagazine;

import java.util.Optional;

/*
    https://blogs.oracle.com/javamagazine/post/12-recipes-for-using-the-optional-class-as-its-meant-to-be-used
 */
public class OptionalUsageRules {

    public static void main (String [] args) {

        OptionalUsageRules optionalRules = new OptionalUsageRules();

        Employee emp1 = new Employee();
        emp1.setId(12);

        System.out.println("Hey I am here in main() : emp1.getId() = " + emp1.getId());

        optionalRules.getEmployee(5);


    }


    public Optional<Employee> getEmployee(int id)
    {
        /*  --------------------------------------------------------------------------------------------
         *                   RULE 1: Never assign null to an optional variable.
         *  ------------------------------------------------------------------------------------------- */
        // Optional<Employee> employee = null; // MUST NOT BE USED. MUST BE USED AS BELOW

        Optional<Employee> employee = Optional.empty();

        /*  --------------------------------------------------------------------------------------------
         *                   RULE 2: Don’t call get() directly.
         *  ------------------------------------------------------------------------------------------- */
        // Optional<Employee> employee2 = Optional.ofNullable( . . . );
        Optional<Employee> employee2 = HRService.getEmployee2();  // employee2 have Optional.empty(); here
                                                                     // because HRService.getEmployee2() returns Optional.empty(); here


        // Employee myEmployee = employee2.get();   // THROWS : Exception in thread "main" java.util.NoSuchElementException: No value present
                                                 //             because employee2 have Optional.empty(); here so will check using .isPresent firstly

        if (employee2.isPresent()) {
            Employee myEmployee = employee2.get();
            System.out.println("employee2.get() returned value = myEmployee = " + myEmployee);
        } else {
            System.out.println("employee2.get() returned empty value");
        }





        return employee;
    }


    /*  --------------------------------------------------------------------------------------------
     *               RULE 7: How can I throw explicit exceptions when no value is present?
     *  ------------------------------------------------------------------------------------------- */

    /*
            If you recall, recipe #5 used the method orElseThrow(Supplier<? extends X> exceptionSupplier),
            which is an elegant alternative to isPresent() and get() pairs. Therefore, try to avoid this:
     */

    // @GetMapping("/employees/{id}")
    // public Employee getEmployee(@PathVariable("id") String id) {
    public Employee getEmployee(String id) {
        Optional<Employee> foundEmployee = HrRepository.findByEmployeeId(id);
        if(foundEmployee.isPresent())
            return foundEmployee.get();
        else
            throw new NotFoundException("Employee not found with id " + id);
    }

    /*
            The orElseThrow() method simply throws the explicit exception you pass to it if there is no value
            present with the Optional. So, let’s change the previous method to be more elegant, like this:
    */
    // @GetMapping("/employees/{id}")
    // public Employee getEmployee(@PathVariable("id") String id) {
    public Employee getEmployee(String id) {
        return HrRepository
                .findByEmployeeId(id)
                .orElseThrow(
                        () -> new NotFoundException("Employee not found with id " + id));
    }


    public String fetchJobStatus(int jobId)
    {
        /*  --------------------------------------------------------------------------------------------
         *                   RULE 12: Don’t overuse Optional.
         *  ------------------------------------------------------------------------------------------- */
        String status = null; // fetch declared job status by id

        // return Optional.ofNullable(status).orElse("Not started yet.");

        return status == null ? "Not started yet." : status;
    }

    /* ------------------------- public static class Employee ----------------------------------- */
    public static class Employee {
        int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
    /* ------------------------- public static class HRService ----------------------------------- */
    public static class HRService {

        private static Employee employee;
        private static Optional<Employee> employee2;

        public static Optional<Employee> getEmployee2()
        {
            return Optional.empty();        // empty() is returned instead of null
        }

        public void setEmployee2(Optional<Employee> employee2) {
            this.employee2 = employee2;
        }

        public static Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

    }
}


