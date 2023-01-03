package com.solvd.construction_company;

import com.solvd.construction_company.buildings.ApartmentBuilding;
import com.solvd.construction_company.buildings.Building;
import com.solvd.construction_company.buildings.DetachedHouse;
import com.solvd.construction_company.buildings.OfficeBuilding;
import com.solvd.construction_company.client.Company;
import com.solvd.construction_company.client.IndividualPerson;
import com.solvd.construction_company.staff.*;
import com.solvd.construction_company.transport.Crane;
import com.solvd.construction_company.transport.Tractor;
import com.solvd.construction_company.transport.Truck;
import com.solvd.construction_company.transport.Vehicles;

import java.util.*;

public class GenerateData {
    public static List<Company> generateCompanies() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Tesla Company", "+(380)502342323", 7));
        companies.add(new Company("You Tube Company", "+(380)992343434", 8));
        companies.add(new Company("Apple Company", "+(380)672343434", 9));
        companies.add(new Company("Windows Company", "+(380)912343434", 10));
        companies.add(new Company("Pixar Company", "+(380)782343434", 11));
        companies.add(new Company("LG Company", "+(380)973452334", 12));
        return companies;
    }

    public static List<IndividualPerson> generateIndividualPersons() {
        List<IndividualPerson> persons = new LinkedList<>();
        persons.add(new IndividualPerson("Taras Shevchenko", "+(380)991232323", 1));
        persons.add(new IndividualPerson("Lesya Ukrainka", "+(380)671232323", 2));
        persons.add(new IndividualPerson("Ivan Franko", "+(380)681232323", 3));
        persons.add(new IndividualPerson("Grygoriy Skovoroda", "+(380)9312323", 4));
        persons.add(new IndividualPerson("Vasyl Stus", "+(380)9112323", 5));
        persons.add(new IndividualPerson("Lina Kostenko", "+(380)5012323", 6));
        return persons;
    }

    public static Set<Vehicles> generateVehicles() {
        Set<Vehicles> vehicle = new HashSet<>();
        vehicle.add(new Tractor("Tornado", 1999, "Gas", 4, 60, 40, "AA1234AA"));
        vehicle.add(new Crane("Cat", 2020, "Gas", 6, 80, 15, "AA1034AA"));
        vehicle.add(new Tractor("Apache", 2004, "Gas", 4, 60, 50, "AA0234AA"));
        vehicle.add(new Truck("Honda", 2015, "Gasoline", 8, 50, 130, "AA1204AA"));
        vehicle.add(new Crane("Cat", 2021, "Gas", 6, 60, 20, "AA1834AA"));
        vehicle.add(new Truck("Opel", 1996, "Gasoline", 8, 60, 120, "AA1236AA"));
        return vehicle;
    }

    public static TreeMap<String, Employee> generateEmployees() {
        TreeMap<String, Employee> employee = new TreeMap();
        employee.putIfAbsent("Acc", new Accountant("John", "Snow", 18, 1));
        employee.putIfAbsent("Brick", new Bricklayer("John", "Sina", 25, 2));
        employee.putIfAbsent("Brig", new Brigadier("Homer", "Simpson", 45, 3));
        employee.putIfAbsent("Dir", new Director("Peter", "Griffin", 34, 4));
        employee.putIfAbsent("Handy", new Handyman("Dmytro", "Gordon", 21, 5));
        employee.putIfAbsent("Mech", new Mechanic("Vin", "Diesel", 26, 6));
        return employee;
    }

    public static HashMap<String, Building> generateBuildings() {
        HashMap<String, Building> building = new HashMap<>();
        building.putIfAbsent("Apart", new ApartmentBuilding("30", "gray", false, true, 1));
        building.putIfAbsent("Detach", new DetachedHouse("2", "yellow", true, false, 2));
        building.putIfAbsent("Office", new OfficeBuilding("10", "white", true, true, 3));
        return building;
    }
}
