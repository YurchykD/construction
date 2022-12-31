package com.solvd.construction_company.client;

import com.solvd.construction_company.exception.IdException;
import com.solvd.construction_company.exception.NameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Client {
    Logger logger = LogManager.getLogger(Client.class);
    private String fullName;
    private String clientPhoneNumber;
    private int clientID;

    public Client() {
        this.fullName = "not specified";
        this.clientPhoneNumber = "+(380)0000000";
        this.clientID = 111;
    }

    public Client(String fullName, String clientPhoneNumber, int clientID) {
        this.fullName = fullName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientID = clientID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws NameException {
        if (fullName.length() > 30) {
            throw new NameException("Max length of the name is 30 symbols!");
        } else {
            this.fullName = fullName;
        }
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) throws IdException {
        if (clientID < 1 || clientID > 999) {
            throw new IdException("Wrong client ID. Write ID in a 1 - 999 range");
        } else {
            this.clientID = clientID;
        }
    }
}
