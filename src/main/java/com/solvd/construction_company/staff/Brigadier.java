package com.solvd.construction_company.staff;

import java.util.Objects;

public class Brigadier extends Employee {
    //Characteristics

    //Constructors
    public Brigadier() {

    }

    public Brigadier(String firstName, String lastName, int age, int employeeID) {
        super(firstName, lastName, age, employeeID);
    }

    //Methods
    @Override
    public String toString() {
        return String.format("fist name: %s, last name: %s, brigadier id: %d",
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

    public void recruiting() {
        System.out.println("Brigadier is ready.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Brigadier found workers");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
