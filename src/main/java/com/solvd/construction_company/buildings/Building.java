package com.solvd.construction_company.buildings;

import com.solvd.construction_company.exception.IdException;

public abstract class Building {
    //Characteristics
    private String floors;
    private String color;
    private boolean garage;
    private boolean elevator;
    private int buildingID;

    //Constructors
    public Building() {
        this.floors = "2";
        this.color = "gray";
        this.garage = true;
        this.elevator = false;
        this.buildingID = 1;
    }

    public Building(String floors, String color, boolean garage, boolean elevator, int buildingID) {
        this.floors = floors;
        this.color = color;
        this.garage = garage;
        this.elevator = elevator;
        this.buildingID = buildingID;
    }

    //Methods
    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) throws IdException {
        if (buildingID < 1 || buildingID > 999) {
            throw new IdException("Wrong building ID. Write ID in a 1 - 999 range");
        } else {
            this.buildingID = buildingID;
        }
    }
}
