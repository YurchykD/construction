package com.solvd.construction_company;

import com.solvd.construction_company.buildings.ApartmentBuilding;
import com.solvd.construction_company.buildings.DetachedHouse;
import com.solvd.construction_company.buildings.OfficeBuilding;
import com.solvd.construction_company.client.IndividualPerson;
import com.solvd.construction_company.exception.FloorException;
import com.solvd.construction_company.exception.IdException;
import com.solvd.construction_company.exception.NameException;
import com.solvd.construction_company.exception.PhoneNumberException;
import com.solvd.construction_company.orders.Order;
import com.solvd.construction_company.orders.Price;
import com.solvd.construction_company.staff.*;
import com.solvd.construction_company.threads.ThreadExample;
import com.solvd.construction_company.transport.Crane;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class ConstructionCompany {
    public static void start() {
        Logger logger = LogManager.getLogger(ConstructionCompany.class);

        Scanner scanner = new Scanner(System.in);

        Thread tSleep = new ThreadExample();
        tSleep.start();

        Order order = new Order(1, 1);

        logger.info("Program is started");

        System.out.println("Hello, welcome in our Construction company!");
        
        tSleep.run();

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

        tSleep.run();

        System.out.println("Thank you, " + person.getFullName());

        tSleep.run();

        //Asking for phone number
        boolean phoneIsValid = false;

        do {
            System.out.println("What is your phone number?");

            String phone = scanner.nextLine();
            try {
                person.setClientPhoneNumber(phone);
                if (person.getClientPhoneNumber().length() < 15) {
                    throw new PhoneNumberException("Phone number must be 15 characters long. Letters not allowed. In this format: +(###)#########");
                }

                if (NumberUtils.isNumber(person.getClientPhoneNumber())) {
                    throw new PhoneNumberException("Phone number must be 15 characters long. Letters not allowed. In this format: +(###)#########");
                }

                if (person.getClientPhoneNumber().charAt(1) != '(' || person.getClientPhoneNumber().charAt(5) != ')' || person.getClientPhoneNumber().charAt(0) != '+') {
                    throw new PhoneNumberException("Phone number must be 15 characters long. Letters not allowed. In this format: +(###)#########");
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
        tSleep.run();

        System.out.println("Our company can build 3 types of building");

        tSleep.run();

        System.out.println("I will show you:");

        tSleep.run();

        System.out.println(
                "1) " + ApartmentBuilding.getTYPE() + "\n"
                        + "2) " + DetachedHouse.getTYPE() + "\n"
                        + "3) " + OfficeBuilding.getTYPE());

        tSleep.run();

        //Asking of building and showing price
        ApartmentBuilding apartment = null;
        DetachedHouse house = null;
        OfficeBuilding office = null;

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

        tSleep.run();

        System.out.println("It will look like this:");

        tSleep.run();

        switch (building) {
            case "1":
                apartment = new ApartmentBuilding("5", "gray", false, true, 1);
                System.out.println(apartment);
                break;
            case "2":
                house = new DetachedHouse("1", "gray", true, false, 2);
                System.out.println(house);
                break;
            case "3":
                office = new OfficeBuilding("9", "gray", true, true, 3);
                System.out.println(office);
                break;
            default:
                logger.error("We don't build this. Choose the type of the building by tapping the number 1-3");
        }

        tSleep.run();

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

                    tSleep.run();

                    System.out.println("This work required 1 Brigadier, 5 Handyman's, 5 Bricklayers and 2 Mechanics");

                    tSleep.run();

                    System.out.println("Also 1 Crane and 2 Tractors");

                    Brigadier brigadier1 = new Brigadier("John", "Snow", 35, 1);

                    tSleep.run();

                    brigadier1.recruiting();

                    Handyman handyman1 = new Handyman("Carl", "Johnson", 24, 2);

                    System.out.println("Handyman's are working...");

                    tSleep.run();

                    Mechanic mechanic1 = new Mechanic("Paolo", "Contao", 33, 3);

                    System.out.println("Mechanic's are working...");

                    tSleep.run();

                    Crane crane1 = new Crane();

                    crane1.liftBuildingMaterials();

                    tSleep.run();

                    Bricklayer bricklayer1 = new Bricklayer("Tom", "Jerry", 18, 4);

                    bricklayer1.buildWall();

                    Director director1 = new Director();

                    System.out.print(order.getClientName());

                    director1.endBuildProcess();

                    break;
                case "2":
                    isChosed = true;

                    boolean isValid = false;
                    do {
                        System.out.println("Change configuration: " + "\n"
                                + "1) " + "Change floors" + "\n"
                                + "2) " + "Change color" + "\n"
                                + "3) " + "Change garage" + "\n"
                                + "4) " + "Change elevator" + "\n"
                                + "5) " + "Apply changes and start building process" + "\n");

                        String change = scanner.nextLine();

                        switch (change) {
                            case "1":
                                boolean isFloor = false;
                                do {
                                    if (order.getTypeOfBuilding().equals("Apartment building")) {
                                        System.out.println("Set how much floors do you want in your Apartment building" + "\n"
                                                + "Min - 5 floors. Max - 33 floors" + "\n"
                                                + "After fifth floor each floor will be cost extra 1000$");
                                        String floor = scanner.nextLine();
                                        try {
                                            apartment.setFloors(floor);
                                            if (!StringUtils.isNumeric(floor)
                                                    || (Integer.parseInt(floor) < 5
                                                    || Integer.parseInt(floor) > 33)) {
                                                throw new FloorException("Only digits. Choose 5-33 floors");
                                            } else {
                                                isFloor = true;
                                                order.setFloors(apartment.getFloors());
                                                System.out.println("Changes applied");
                                                order.setTotalPrice((Price.APARTMENT_BUILDING.getBasePrice() - 5000)
                                                        + Integer.parseInt(apartment.getFloors()) * 1000);
                                                System.out.println("Total price now: " + order.getTotalPrice());
                                            }
                                        } catch (FloorException e) {
                                            logger.error(e);
                                        }
                                    }

                                    if (order.getTypeOfBuilding().equals("Detached house")) {
                                        System.out.println("Set how much floors do you want in your Detached house" + "\n"
                                                + "Min - 1 floors. Max - 3 floors" + "\n"
                                                + "After first floor each floor will be cost extra 1000$");
                                        String floor = scanner.nextLine();
                                        try {
                                            house.setFloors(floor);
                                            if (!StringUtils.isNumeric(floor)
                                                    || (Integer.parseInt(floor) < 1
                                                    || Integer.parseInt(floor) > 3)) {
                                                throw new FloorException("Only digits. Choose 1-3 floors");
                                            } else {
                                                isFloor = true;
                                                order.setFloors(house.getFloors());
                                                System.out.println("Changes applied");
                                                order.setTotalPrice((Price.DETACHED_HOUSE.getBasePrice() - 1000)
                                                        + Integer.parseInt(house.getFloors()) * 1000);
                                                System.out.println("Total price now: " + order.getTotalPrice());
                                            }
                                        } catch (FloorException e) {
                                            logger.error(e);
                                        }
                                    }

                                    if (order.getTypeOfBuilding().equals("Office building")) {
                                        System.out.println("Set how much floors do you want in your Office building" + "\n"
                                                + "Min - 9 floors. Max - 64 floors" + "\n"
                                                + "After nine floor each floor will be cost extra 1000$");
                                        String floor = scanner.nextLine();
                                        try {
                                            office.setFloors(floor);
                                            if (!StringUtils.isNumeric(floor)
                                                    || (Integer.parseInt(floor) < 9
                                                    || Integer.parseInt(floor) > 64)) {
                                                throw new FloorException("Only digits. Choose 9 - 64 floors.");
                                            } else {
                                                isFloor = true;
                                                order.setFloors(office.getFloors());
                                                System.out.println("Changes applied");
                                                order.setTotalPrice((Price.OFFICE_BUILDING.getBasePrice() - 9000)
                                                        + Integer.parseInt(office.getFloors()) * 1000);
                                                System.out.println("Total price now: " + order.getTotalPrice());
                                            }
                                        } catch (FloorException e) {
                                            logger.error(e);
                                        }
                                    }
                                } while (!isFloor);
                                break;
                            case "2":

                                boolean isColor = false;
                                do {
                                    System.out.println("Change color: " + "\n"
                                            + "1) " + "Black walls" + "\n"
                                            + "2) " + "Yellow walls" + "\n"
                                            + "3) " + "Gray walls" + "\n"
                                            + "4) " + "White walls " + "\n");

                                    String color = scanner.nextLine();

                                    switch (color) {
                                        case "1":
                                            order.setColor("black");
                                            System.out.println("New color applied");
                                            isColor = true;
                                            break;
                                        case "2":
                                            order.setColor("yellow");
                                            System.out.println("New color applied");
                                            isColor = true;
                                            break;
                                        case "3":
                                            order.setColor("gray");
                                            System.out.println("New color applied");
                                            isColor = true;
                                            break;
                                        case "4":
                                            order.setColor("white");
                                            System.out.println("New color applied");
                                            isColor = true;
                                            break;
                                        default:
                                            logger.error("Choose one of the 1-4 options");
                                    }
                                } while (!isColor);

                                if (order.getTypeOfBuilding().equals("Apartment building")) {
                                    assert apartment != null;
                                    apartment.setColor(order.getColor());
                                }

                                if (order.getTypeOfBuilding().equals("Detached house")) {
                                    assert house != null;
                                    house.setColor(order.getColor());
                                }

                                if (order.getTypeOfBuilding().equals("Office building")) {
                                    assert office != null;
                                    office.setColor(order.getColor());
                                }

                                break;
                            case "3":
                                boolean isGarage = false;
                                do {
                                    System.out.println("Change garage: " + "\n"
                                            + "1) " + "With garage" + "\n"
                                            + "2) " + "Without garage" + "\n");

                                    String garage = scanner.nextLine();

                                    switch (garage) {
                                        case "1":
                                            order.setGarage(true);
                                            System.out.println("Changes applied");
                                            isGarage = true;
                                            break;
                                        case "2":
                                            order.setGarage(false);
                                            System.out.println("Changes applied");
                                            isGarage = true;
                                            break;
                                        default:
                                            logger.error("Choose one of the 1-2 options");
                                    }
                                } while (!isGarage);

                                if (order.getTypeOfBuilding().equals("Apartment building")) {
                                    assert apartment != null;
                                    apartment.setGarage(order.isGarage());
                                }

                                if (order.getTypeOfBuilding().equals("Detached house")) {
                                    assert house != null;
                                    house.setGarage(order.isGarage());
                                }

                                if (order.getTypeOfBuilding().equals("Office building")) {
                                    assert office != null;
                                    office.setGarage(order.isGarage());
                                }

                                break;
                            case "4":
                                boolean isElevator = false;
                                do {
                                    System.out.println("Change elevator: " + "\n"
                                            + "1) " + "With elevator" + "\n"
                                            + "2) " + "Without elevator" + "\n");

                                    String elevator = scanner.nextLine();

                                    switch (elevator) {
                                        case "1":
                                            if (order.getTypeOfBuilding().equals("Detached house")) {
                                                System.out.println("Sorry, but in Detached house we cannot build an elevator");
                                                isElevator = true;
                                            } else {
                                                order.setElevator(true);
                                                System.out.println("Changes applied");
                                                isElevator = true;
                                            }
                                            break;
                                        case "2":
                                            if (order.getTypeOfBuilding().equals("Detached house")) {
                                                System.out.println("Yes, Detached house is already without an elevator");
                                                isElevator = true;
                                            } else {
                                                order.setElevator(false);
                                                System.out.println("Changes applied");
                                                isElevator = true;
                                            }
                                            break;
                                        default:
                                            logger.error("Choose one of the 1-2 options");
                                    }
                                } while (!isElevator);

                                if (order.getTypeOfBuilding().equals("Apartment building")) {
                                    assert apartment != null;
                                    apartment.setElevator(order.isElevator());
                                }

                                if (order.getTypeOfBuilding().equals("Detached house")) {
                                    assert house != null;
                                    house.setElevator(order.isElevator());
                                }

                                if (order.getTypeOfBuilding().equals("Office building")) {
                                    assert office != null;
                                    office.setElevator(order.isElevator());
                                }
                                break;
                            case "5":
                                System.out.println("Changes applied");
                                tSleep.run();
                                System.out.println("All right! All right!");

                                tSleep.run();

                                if (Integer.parseInt(order.getFloors()) > Integer.parseInt("20")) {
                                    System.out.println("This work required 2 Brigadiers, 15 Handyman's, 10 Bricklayers and 4 Mechanics");
                                } else {
                                    System.out.println("This work required 1 Brigadier, 5 Handyman's, 5 Bricklayers and 2 Mechanics");
                                }

                                tSleep.run();

                                if (Integer.parseInt(order.getFloors()) > Integer.parseInt("20")) {
                                    System.out.println("Also 3 Crane and 5 Tractors");
                                } else {
                                    System.out.println("Also 1 Crane and 2 Tractors");
                                }

                                Brigadier brigadier2 = new Brigadier("Terry", "Smitt", 25, 4);

                                tSleep.run();

                                brigadier2.recruiting();
                                Handyman handyman2 = new Handyman("Van", "Rock", 34, 5);
                                System.out.println("Handyman's are working...");

                                tSleep.run();

                                Mechanic mechanic2 = new Mechanic("Tomacto", "Huanes", 43, 6);
                                System.out.println("Mechanic's are working...");

                                tSleep.run();

                                Crane crane2 = new Crane();
                                crane2.liftBuildingMaterials();

                                tSleep.run();

                                Bricklayer bricklayer2 = new Bricklayer("Jerry", "Adams", 28, 6);
                                bricklayer2.buildWall();
                                Director director2 = new Director();
                                System.out.print(order.getClientName());
                                director2.endBuildProcess();
                                isValid = true;
                                break;
                            default:
                                logger.error("Choose one of the 1-5 options");
                        }
                    } while (!isValid);

                    break;
                default:
                    logger.error("Choose 1 or 2");
            }
        } while (!isChosed);

        //print Order info
        System.out.println("Do you need order receipt?");

        tSleep.run();

        boolean isChecked = false;
        do {
            System.out.println("1) Yes\n" + "2) No\n");

            String orderReceipt = scanner.nextLine();

            switch (orderReceipt) {
                case "1":
                    isChecked = true;
                    System.out.println(order);

                    if (order.getTypeOfBuilding().equals("Apartment building")) {
                        System.out.println(apartment);
                    }

                    if (order.getTypeOfBuilding().equals("Detached house")) {
                        System.out.println(house);
                    }

                    if (order.getTypeOfBuilding().equals("Office building")) {
                        System.out.println(office);
                    }
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