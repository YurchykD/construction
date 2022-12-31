package com.solvd.construction_company.transport;

import java.util.Objects;

public final class Crane extends Vehicles implements Enginable {
    //Characteristics
    private int craneLength;

    //Constructors
    public Crane() {

    }

    public Crane(String model, int modelYear, String fuel, int wheels, int tankCapacity, int maxSpeed, String carNumber) {
        super(model, modelYear, fuel, wheels, tankCapacity, maxSpeed, carNumber);
        this.craneLength = craneLength;
    }

    //Methods
    public int getCraneLength() {
        return craneLength;
    }

    public void setCraneLength(int craneLength) {
        this.craneLength = craneLength;
    }

    public void startEngine() {
        System.out.println("The Crane started the engine");
    }

    public void go() {
        System.out.println("The Crane is moving forward");
    }

    public void stop() {
        System.out.println("The Crane has stopped");
    }

    public void stopEngine() {
        System.out.println("The Crane stopped the engine");
    }

    public void liftBuildingMaterials() {
        System.out.println("The crane lifted the building materials");
    }

    @Override
    public String toString() {
        return String.format("crane model: %s, model year: %d, crane number: %s, crane length: %d",
                getModel(),
                getModelYear(),
                getCarNumber(),
                craneLength);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicles vehicle = (Vehicles) o;
        return getCarNumber() == vehicle.getCarNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarNumber());
    }
}