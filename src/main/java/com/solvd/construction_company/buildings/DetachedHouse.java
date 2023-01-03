package com.solvd.construction_company.buildings;

import java.util.Objects;

public class DetachedHouse extends Building {
    //Characteristics
    private boolean backyard;
    private static final String TYPE = "Detached House";

    //Constructors
    public DetachedHouse() {

    }

    public DetachedHouse(String floors, String color, boolean garage, boolean elevator, int buildingID) {
        super(floors,
                color,
                garage,
                elevator,
                buildingID);
        this.backyard = backyard;
    }

    //Methods
    public boolean isBackyard() {
        return backyard;
    }

    public void setBackyard(boolean backyard) {
        this.backyard = backyard;
    }

    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return String.format("Configuration: \n" +
                        " floors: %s \n" +
                        " color: %s \n" +
                        " garage: %b \n" +
                        " elevator: %b \n" +
                        " building ID: %d",
                getFloors(),
                getColor(),
                isGarage(),
                isElevator(),
                getBuildingID());
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return getBuildingID() == building.getBuildingID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuildingID());
    }
}
