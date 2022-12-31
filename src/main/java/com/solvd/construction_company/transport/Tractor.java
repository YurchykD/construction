package com.solvd.construction_company.transport;

import java.util.Objects;

public final class Tractor extends Vehicles implements Enginable {
    //Characteristics
    private boolean withTrailer;

    //Constructors
    public Tractor() {

    }

    public Tractor(boolean withTrailer) {
        this.withTrailer = withTrailer;
    }

    public Tractor(String model,
                   int modelYear,
                   String fuel,
                   int wheels,
                   int tankCapacity,
                   int maxSpeed,
                   String carNumber) {
        super(model, modelYear, fuel, wheels, tankCapacity, maxSpeed, carNumber);
        this.withTrailer = withTrailer;
    }

    //Methods
    public boolean isWithTrailer() {
        return withTrailer;
    }

    public void setWithTrailer(boolean withTrailer) {
        this.withTrailer = withTrailer;
    }

    public void startEngine() {
        System.out.println("The Tractor started the engine");
    }

    public void go() {
        System.out.println("The Tractor is moving forward");
    }

    public void stop() {
        System.out.println("The Tractor has stopped");
    }

    public void stopEngine() {
        System.out.println("The Tractor stopped the engine");
    }

    public void excavate() {
        System.out.println("The Tractor excavated a hole");
    }

    @Override
    public String toString() {
        return String.format("tractor model: %s, model year: %d, tractor number: %s, with trailer: %b",
                getModel(),
                getModelYear(),
                getCarNumber(),
                withTrailer);
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
