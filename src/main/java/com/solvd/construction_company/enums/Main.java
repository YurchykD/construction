package com.solvd.construction_company.enums;

import com.solvd.construction_company.orders.Price;
import com.solvd.construction_company.staff.Salary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

        Price price = Price.APARTMENT_BUILDING;

        switch (price) {
            case APARTMENT_BUILDING:
                logger.info(Price.APARTMENT_BUILDING.getBasePrice());
                break;
            case DETACHED_HOUSE:
                logger.info(Price.DETACHED_HOUSE.getBasePrice());
                break;
            case OFFICE_BUILDING:
                logger.info(Price.OFFICE_BUILDING.getBasePrice());
                break;
            default:
                logger.info("We don't build this");
        }

        Salary salary = Salary.ACCOUNTANT;

        switch (salary) {
            case ACCOUNTANT:
                logger.info("Accountant salary is 2000$");
                break;
            case BRICKLAYER:
                logger.info("Bricklayer salary is 800$");
                break;
            case BRIGADIER:
                logger.info("Brigadier salary is 1500$");
                break;
            case DIRECTOR:
                logger.info("Director salary is 3000$");
                break;
            case HANDYMAN:
                logger.info("Handyman salary is 600$");
                break;
            case MECHANIC:
                logger.info("Mechanic salary is 1200$");
                break;
            default:
                logger.info("Sorry, you don't work here");
                break;
        }
    }
}
