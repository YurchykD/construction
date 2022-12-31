package com.solvd.construction_company.transport;

import java.util.Objects;

public final class Truck extends Vehicles implements Enginable {
    //Characteristics
    private int loadCapacity;

    //Constructors
    public Truck() {

    }

    public Truck(String model, int modelYear, String fuel, int wheels, int tankCapacity, int maxSpeed, String carNumber) {
        super(model, modelYear, fuel, wheels, tankCapacity, maxSpeed, carNumber);
        this.loadCapacity = loadCapacity;
    }

    //Methods
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void startEngine() {
        System.out.println("The Truck started the engine");
    }

    public void go() {
        System.out.println("The Truck is moving forward");
    }

    public void stop() {
        System.out.println("The Truck has stopped");
    }

    public void stopEngine() {
        System.out.println("The Truck stopped the engine");
    }

    public void deliverBuildingMaterials() {
        System.out.println("The Truck delivered buildings materials");
    }

    @Override
    public String toString() {
        return String.format("truck model: %s, model year: %d, truck number: %s, load capacity: %b",
                getModel(),
                getModelYear(),
                getCarNumber(),
                loadCapacity);
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
