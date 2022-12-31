package com.solvd.construction_company.lambda;

import com.solvd.construction_company.GenerateData;
import com.solvd.construction_company.buildings.Building;
import com.solvd.construction_company.orders.Price;
import com.solvd.construction_company.staff.Calculate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

        Map<String, Building> listOfBuilding = GenerateData.generateBuildings();

        Calculate officePrice = () -> listOfBuilding.get("Office").getFloors() * Price.OFFICE_BUILDING.getBasePrice();
        logger.info("full Price of Office Building: " + officePrice.сalculatePrice());

        Calculate apartmentPrice = () -> listOfBuilding.get("Office").getFloors() * Price.APARTMENT_BUILDING.getBasePrice();
        logger.info("full Price of Apartment Building: " + apartmentPrice.сalculatePrice());

        Calculate housePrice = () -> listOfBuilding.get("Office").getFloors() * Price.DETACHED_HOUSE.getBasePrice();
        logger.info("full Price of  Detached House: " + housePrice.сalculatePrice());
    }
}
