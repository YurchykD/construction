package com.solvd.construction_company.staff;

import java.util.Objects;

public class Accountant extends Employee {
    //Characteristics


    //Constructors
    public Accountant() {

    }

    public Accountant(String firstName, String lastName, int age, int employeeID) {
        super(firstName, lastName, age, employeeID);
    }

    //Methods
    @Override
    public String toString() {
        return String.format("fist name: %s, last name: %s, accountant id: %d",
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
