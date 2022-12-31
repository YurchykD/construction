package com.solvd.construction_company.streams;

import com.solvd.construction_company.GenerateData;
import com.solvd.construction_company.client.Company;
import com.solvd.construction_company.client.IndividualPerson;
import com.solvd.construction_company.staff.Employee;
import com.solvd.construction_company.transport.Vehicles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

        //filter by year > 2000
        Set<Vehicles> vehiclesSet = GenerateData.generateVehicles();
        Stream<Vehicles> vehiclesStream = vehiclesSet.stream();
        Stream<Vehicles> filteredVehiclesStream = vehiclesStream.filter(x -> x.getModelYear() > 2000);
        filteredVehiclesStream.forEach(x -> logger.info("vehicles, model year > 2000: " + x));

        //find first with full name
        List<IndividualPerson> personsList = GenerateData.generateIndividualPersons();
        personsList.stream()
                .findFirst()
                .stream().collect(Collectors.toList())
                .forEach(x -> logger.info("first person in the List: " + x));

        //sorted ASC by name
        List<IndividualPerson> sortedPersonsList = GenerateData.generateIndividualPersons();
        sortedPersonsList.stream().
                sorted(Comparator.comparing(person -> person.getFullName()))
                .collect(Collectors.toList())
                .forEach(x -> logger.info("sorted ASC by name: " + x.getFullName()));

        //toUpperCase using map
        List<Company> companyList = GenerateData.generateCompanies();
        companyList.stream()
                .map(x -> x.getFullName().toUpperCase())
                .forEach(x -> logger.info("Company name to UpperCase" + x));

        //show phone numbers of all clients using flat map
        Stream.of(personsList, companyList).flatMap(x -> x.stream())
                .filter(x -> x.getClientPhoneNumber().equals(x.getClientPhoneNumber()))
                .forEach(x -> logger.info("phone number of client: " + x.getClientPhoneNumber()));

        //show min and max age of employees
        TreeMap<String, Employee> employeeMap = GenerateData.generateEmployees();
        logger.info("employee with min age" + employeeMap.values().stream()
                .min(Comparator.comparing(Employee::getAge)).get());
        logger.info("employee with max age" + employeeMap.values().stream()
                .max(Comparator.comparing(Employee::getAge)).get());
    }
}
