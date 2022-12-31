package com.solvd.construction_company.staff;

import java.util.Objects;

public class Bricklayer extends Employee implements Build {
    //Characteristics
    private String instrument;

    //Constructors
    public Bricklayer() {
        this.instrument = "trowel";
    }

    public Bricklayer(String firstName, String lastName, int age, int employeeID) {
        super(firstName, lastName, age, employeeID);
    }

    //Methods
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public void buildWall() {
        System.out.println("The walls are building...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The walls are built!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("fist name: %s, last name: %s, bricklayer id: %d, instrument: %s",
                getFirstName(),
                getLastName(),
                getEmployeeID(),
                instrument);
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
