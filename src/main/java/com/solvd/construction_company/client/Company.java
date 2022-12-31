package com.solvd.construction_company.client;

import com.solvd.construction_company.exception.IdException;

import java.util.Objects;

public class Company extends Client implements Ordering {
    //Characteristics
    private int companyID;

    //Constructors
    public Company() {

    }

    public Company(String fullName, String clientPhoneNumber, int clientID) {
        super(fullName, clientPhoneNumber, clientID);
        this.companyID = companyID;
    }

    //Methods
    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) throws IdException {
        if (companyID < 1 || companyID > 999) {
            throw new IdException("Wrong company ID. Write ID in a 1 - 999 range");
        } else {
            this.companyID = companyID;
        }
    }

    public void makeBuildingOrder() {
        logger.info("I want house");
    }

    @Override
    public String toString() {
        return String.format("company name: %s, company phone number: %s, client ID: %d, company ID id: %d",
                getFullName(),
                getClientPhoneNumber(),
                getClientID(),
                getCompanyID());
    }

    ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getClientID() == client.getClientID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientID());
    }
}
