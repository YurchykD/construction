package com.solvd.construction_company.staff;

import java.util.Objects;

public class Handyman extends Employee {
    //Characteristics
    private String instrument;
    private int yearsOfExperience;

    //Constructors
    public Handyman() {
        this.instrument = "Hammer";
        this.yearsOfExperience = 2;
    }

    public Handyman(String firstName, String lastName, int age, int employeeID) {
        super(firstName, lastName, age, employeeID);
    }

    //Methods
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return String.format("fist name: %s, last name: %s, handyman id: %d, instrument: %s",
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
