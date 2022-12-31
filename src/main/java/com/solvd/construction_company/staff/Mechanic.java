package com.solvd.construction_company.staff;

import java.util.Objects;

public class Mechanic extends Employee {
    //Characteristics
    private int yearsOfExperience;
    private String driverLicense;

    //Constructors
    public Mechanic() {
        this.yearsOfExperience = 1;
        this.driverLicense = "BE";
    }

    public Mechanic(String firstName, String lastName, int age, int employeeID) {
        super(firstName, lastName, age, employeeID);
    }

    //Methods
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return String.format("fist name: %s, last name: %s, mechanic id: %d, driver license: %s",
                getFirstName(),
                getLastName(),
                getEmployeeID(),
                driverLicense);
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
