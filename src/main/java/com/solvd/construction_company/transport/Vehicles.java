package com.solvd.construction_company.transport;

import com.solvd.construction_company.exception.CarNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Vehicles {
    //Characteristics
    Logger logger = LogManager.getLogger(Vehicles.class);
    private String model;
    private int modelYear;
    private String fuel;
    private int wheels;
    private int tankCapacity;
    private int maxSpeed;
    private String carNumber;

    //Constructors
    public Vehicles() {
        this.model = "not specified";
        this.modelYear = 2021;
        this.fuel = "not specified";
        this.wheels = 4;
        this.tankCapacity = 60;
        this.maxSpeed = 40;
        this.carNumber = "AA0000AA";
    }

    public Vehicles(String model,
                    int modelYear,
                    String fuel,
                    int wheels,
                    int tankCapacity,
                    int maxSpeed,
                    String carNumber) {
        this.model = model;
        this.modelYear = modelYear;
        this.fuel = fuel;
        this.wheels = wheels;
        this.tankCapacity = tankCapacity;
        this.maxSpeed = maxSpeed;
        this.carNumber = carNumber;
    }

    //Methods
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) throws CarNumberException {
        this.carNumber = carNumber;
    }

    public final void beep() {
        logger.info("The vehicle beeps");
    }
}

