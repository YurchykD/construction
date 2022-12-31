package com.solvd.construction_company;

import com.solvd.construction_company.buildings.ApartmentBuilding;
import com.solvd.construction_company.buildings.DetachedHouse;
import com.solvd.construction_company.buildings.OfficeBuilding;
import com.solvd.construction_company.client.IndividualPerson;
import com.solvd.construction_company.exception.IdException;
import com.solvd.construction_company.exception.NameException;
import com.solvd.construction_company.exception.PhoneNumberException;
import com.solvd.construction_company.orders.Order;
import com.solvd.construction_company.orders.Price;
import com.solvd.construction_company.staff.*;
import com.solvd.construction_company.transport.Crane;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class ConstructionCompany {
    public static void start() {
        Logger logger = LogManager.getLogger(ConstructionCompany.class);

        Scanner scanner = new Scanner(System.in);

        Order order = new Order(1, 1);

        logger.info("Program is started");

        System.out.println("Hello, welcome in our Construction company!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Asking for name
        IndividualPerson person = new IndividualPerson();
        try {
            person.setClientID(order.getClientID());
        } catch (IdException e) {
            throw new RuntimeException(e);
        }

        boolean nameIsValid = false;
        do {
            System.out.println("What is your name?");

            String name = scanner.nextLine();

            try {
                person.setFullName(name);
                if (StringUtils.isNumeric(person.getFullName()) || person.getFullName().length() > 30 || person.getFullName().length() < 1) {
                    throw new NameException("Max length is 30 symbols! Only letters allowed! Name cannot be empty");
                } else {
                    nameIsValid = true;
                }
            } catch (NameException e) {
                logger.error(e);
            }
            order.setClientName(person.getFullName());
        } while (!nameIsValid);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thank you, " + person.getFullName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Asking for phone number
        boolean phoneIsValid = false;

        do {
            System.out.println("What is your phone number?");

            String phone = scanner.nextLine();
            try {
                person.setClientPhoneNumber(phone);
                if (person.getClientPhoneNumber().length() < 15) {
                    throw new PhoneNumberException("Phone number must be 15 characters long and in this format: +(###)#########");
                }

                if (person.getClientPhoneNumber().charAt(1) != '(' || person.getClientPhoneNumber().charAt(5) != ')' || person.getClientPhoneNumber().charAt(0) != '+') {
                    throw new PhoneNumberException("Phone number must be 15 characters long and in this format: +(###)#########");
                } else {
                    phoneIsValid = true;
                }
            } catch (PhoneNumberException e) {
                logger.error(e);
            }
            order.setClientPhone(person.getClientPhoneNumber());

        } while (!phoneIsValid);

        System.out.println("Thank you, i wrote down your phone number");

        //Showing building
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Our company can build 3 types of building");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("I will show you:");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                "1) " + ApartmentBuilding.getTYPE() + "\n"
                        + "2) " + DetachedHouse.getTYPE() + "\n"
                        + "3) " + OfficeBuilding.getTYPE());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Asking of building and showing price
        boolean typeIsValid = false;
        String building;
        do {
            System.out.println("What type of building would you like to build?");

            building = scanner.nextLine();

            switch (building) {
                case "1":
                    System.out.println("Ok, The base price of Apartment building is: " + Price.APARTMENT_BUILDING.getBasePrice() + "$");
                    order.setTypeOfBuilding("Apartment building");
                    order.setTotalPrice(Price.APARTMENT_BUILDING.getBasePrice());
                    typeIsValid = true;
                    break;
                case "2":
                    System.out.println("Ok, The base price of Detached house is: " + Price.DETACHED_HOUSE.getBasePrice() + "$");
                    order.setTypeOfBuilding("Detached house");
                    order.setTotalPrice(Price.DETACHED_HOUSE.getBasePrice());
                    typeIsValid = true;
                    break;
                case "3":
                    System.out.println("Ok, The base price of Office building is: " + Price.OFFICE_BUILDING.getBasePrice() + "$");
                    order.setTypeOfBuilding("Office building");
                    order.setTotalPrice(Price.OFFICE_BUILDING.getBasePrice());
                    typeIsValid = true;
                    break;
                default:
                    logger.error("We don't build this. Choose the type of the building by tapping the number 1-3");
            }
        } while (!typeIsValid);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("It will look like this:");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        switch (building) {
            case "1":
                ApartmentBuilding apartment = new ApartmentBuilding(5, "gray", false, true, 1);
                System.out.println(apartment);
                break;
            case "2":
                DetachedHouse house = new DetachedHouse(2, "white", true, false, 2);
                System.out.println(house);
                break;
            case "3":
                OfficeBuilding office = new OfficeBuilding(9, "gray", true, true, 3);
                System.out.println(office);
                break;
            default:
                logger.error("We don't build this. Choose the type of the building by tapping the number 1-3");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Configuration and building
        boolean isChosed = false;

        do {

            System.out.println("1) " + "Proceed with this configuration" + "\n"
                    + "2) " + "Change configuration" + "\n");

            String configuration = scanner.nextLine();
            switch (configuration) {
                case "1":
                    isChosed = true;

                    System.out.println("All right! All right!");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("This work required 1 Brigadier, 5 Handyman's, 5 Bricklayers and 2 Mechanics");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Also 1 Crane and 2 Tractors");

                    Brigadier brigadier1 = new Brigadier("John", "Snow", 35, 1);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    brigadier1.recruiting();

                    Handyman handyman1 = new Handyman("Carl", "Johnson", 24, 2);

                    System.out.println("Handyman's are working...");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Mechanic mechanic1 = new Mechanic("Paolo", "Contao", 33, 3);

                    System.out.println("Mechanic's are working...");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Crane crane1 = new Crane();

                    crane1.liftBuildingMaterials();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Bricklayer bricklayer1 = new Bricklayer("Tom", "Jerry", 18, 4);

                    bricklayer1.buildWall();

                    Director director1 = new Director();

                    System.out.print(order.getClientName());

                    director1.endBuildProcess();

                    break;
                case "2":
                    isChosed = true;

                    break;
                default:
                    logger.error("Choose 1 or 2");
            }
        } while (!isChosed);

        //print Order info
        System.out.println("Do you need order receipt?");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

            boolean isChecked = false;
        do {
            System.out.println("1) Yes\n" + "2) No\n");

            String orderReceipt = scanner.nextLine();

            switch (orderReceipt) {
                case "1":
                    isChecked = true;
                    System.out.println(order);
                    break;
                case "2":
                    isChecked = true;
                    System.out.println("Ok, take care! Good bye");
                    break;
                default:
                    logger.error("Choose 1 or 2");
            }
        } while (!isChecked);


        logger.info("Program is ended");

    }
}