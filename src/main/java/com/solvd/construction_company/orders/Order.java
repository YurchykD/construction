package com.solvd.construction_company.orders;

public class Order {
    //Characteristics
    private int orderID;

    private int totalPrice;

    private String clientName;

    private String clientPhone;

    private int clientID;

    private String typeOfBuilding;

    private String color;
    private boolean isElevator;
    private boolean isGarage;
    private String floors;

    //Constructors
    public Order(int orderID, int clientID) {
        this.orderID = orderID;
        this.clientID = clientID;
    }

    //Methods
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public void setTypeOfBuilding(String typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Order info: \n" +
                        " person name: %s \n" +
                        " client phone number: %s \n" +
                        " client ID: %d \n" +
                        " order ID: %d \n" +
                        " building type: %s \n" +
                        " total price: %d",
                getClientName(),
                getClientPhone(),
                getClientID(),
                getOrderID(),
                getTypeOfBuilding(),
                getTotalPrice());
    };

    public void createNewOrder() {

    }

    private void getOrderInfo() {
        System.out.println("order ID: " + orderID);
    }

    public boolean isElevator() {
        return isElevator;
    }

    public void setElevator(boolean elevator) {
        isElevator = elevator;
    }

    public boolean isGarage() {
        return isGarage;
    }

    public void setGarage(boolean garage) {
        isGarage = garage;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }
}
