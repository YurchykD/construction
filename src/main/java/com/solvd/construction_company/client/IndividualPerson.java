package com.solvd.construction_company.client;

import com.solvd.construction_company.exception.IdException;

import java.util.Objects;

public class IndividualPerson extends Client implements Ordering{
    //Characteristics
    private int personID;

    //Constructors
    public IndividualPerson() {

    }

    public IndividualPerson(String fullName, String clientPhoneNumber, int clientID) {
        super(fullName, clientPhoneNumber, clientID);
        this.personID = personID;
    }

    //Methods
    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) throws IdException {
        if (personID < 1 || personID > 999) {
            throw new IdException("Wrong person ID. Write ID in a 1 - 999 range");
        } else {
            this.personID = personID;
        }
    }

    public void makeBuildingOrder() {
        logger.info("I want house for my family");
    }

    @Override
    public String toString() {
        return String.format("individual person name: %s, person phone number: %s, client ID: %d",
                getFullName(),
                getClientPhoneNumber(),
                getClientID());
    };

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
