package com.solvd.construction_company.staff;

import java.util.Objects;

public class Director extends Employee implements Processing {
    //Characteristics


    //Constructors
    public Director() {

    }

    public Director(String firstName, String lastName, int age, int employeeID) {
        super(firstName, lastName, age, employeeID);
    }

    //Methods
    public void endBuildProcess() {
        System.out.println(", your building is ready!");
    }
    @Override
    public void processOrder() {
       logger.info("This house will be cost 10 000$");
    }

    @Override
    public String toString() {
        return String.format("fist name: %s, last name: %s, director id: %d",
                getFirstName(),
                getLastName(),
                getEmployeeID());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeID() == employee.getEmployeeID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID());
    }
}
