package com.solvd.construction_company.exception;

import com.solvd.construction_company.client.Company;
import com.solvd.construction_company.staff.Director;
import com.solvd.construction_company.transport.Tractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        Director director = new Director();
        try {
            director.setAge(-18);
        } catch (AgeException e) {
            logger.error("Wrong age! Write age in 0-120 range");
        }

        Tractor tractor = new Tractor();
        try {
            tractor.setCarNumber("AA123AAA");
            if (tractor.getCarNumber().length() < 8) {
                throw new CarNumberException("Wrong car number! Write car number in this format: AA0000AA");
            }
            if (!Character.isLetter(tractor.getCarNumber().charAt(0))
                    || !Character.isLetter(tractor.getCarNumber().charAt(1))
                    || !Character.isLetter(tractor.getCarNumber().charAt(6))
                    || !Character.isLetter(tractor.getCarNumber().charAt(7))) {
                throw new CarNumberException("Wrong car number! Must be 4 letters. Write car number in this format: AA0000AA");
            }
            if (!Character.isDigit(tractor.getCarNumber().charAt(2))
                    || !Character.isDigit(tractor.getCarNumber().charAt(3))
                    || !Character.isDigit(tractor.getCarNumber().charAt(4))
                    || !Character.isDigit(tractor.getCarNumber().charAt(5))) {
                throw new CarNumberException("Wrong car number! Must be 4 digits. Write car number in this format: AA0000AA");
            }
        } catch (CarNumberException e) {
            logger.error(e);
        }

        try {
            director.setEmployeeID(1001);
        } catch (IdException e) {
            e.printStackTrace();
        }

        Company company = new Company();

        try {
            company.setFullName("CompanyWithNameMoreThan30Characters");
        } catch (NameException n) {
            n.printStackTrace();
        }

        try {
            company.setClientID(111);
        } catch (IdException id) {
            id.printStackTrace();
        }

        company.makeBuildingOrder();

    }
}
