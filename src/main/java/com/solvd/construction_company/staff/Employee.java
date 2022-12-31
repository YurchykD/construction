package com.solvd.construction_company.staff;

import com.solvd.construction_company.exception.AgeException;
import com.solvd.construction_company.exception.IdException;
import com.solvd.construction_company.exception.NameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Employee {
    Logger logger = LogManager.getLogger(Employee.class);
    //Characteristics
    private String firstName;
    private String lastName;
    private int age;
    private int employeeID;

    //Constructors
    public Employee() {
        this.firstName = "not specified";
        this.lastName = "not specified";
        this.age = 0;
        this.employeeID = 001;
    }

    public Employee(String firstName, String lastName, int age, int employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.employeeID = employeeID;
    }

    //Methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws NameException {
        if (firstName.length() > 30) {
            throw new NameException("Max length of the first name is 30 symbols!");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws NameException {
        if (lastName.length() > 30) {
            throw new NameException("Max length of the last name is 30 symbols!");
        } else {
            this.lastName = lastName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age < 0 || age > 120) {
            throw new AgeException();
        } else {
            this.age = age;
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) throws IdException {
        if (employeeID < 1 || employeeID > 999) {
            throw new IdException("Wrong employee ID. Write ID in a 1 - 999 range");
        } else {
            this.employeeID = employeeID;
        }
    }
}
