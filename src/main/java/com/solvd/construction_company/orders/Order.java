package com.solvd.construction_company.orders;

public class Order {
    //Characteristics
    private int orderID;

    private int totalPrice;

    private String clientName;

    private String clientPhone;

    private int clientID;

    private String typeOfBuilding;

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

    @Override
    public String toString() {
        return String.format("Order info: \n " +
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


}
