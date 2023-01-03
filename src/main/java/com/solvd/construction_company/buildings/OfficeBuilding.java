package com.solvd.construction_company.buildings;

import java.util.Objects;

public class OfficeBuilding extends Building {
    //Characteristics
    private boolean withRepair;

    private static final String TYPE = "Office Building";

    //Constructors
    public OfficeBuilding() {

    }

    public OfficeBuilding(String floors, String color, boolean garage, boolean elevator, int buildingID) {
        super(floors, color, garage, elevator, buildingID);
        this.withRepair = withRepair;
    }

    //Methods
    public boolean isWithRepair() {
        return withRepair;
    }

    public void setWithRepair(boolean withRepair) {
        this.withRepair = withRepair;
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
