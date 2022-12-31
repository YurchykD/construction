package com.solvd.construction_company.orders;

public enum Price {
    APARTMENT_BUILDING(20000),
    DETACHED_HOUSE(15000),
    OFFICE_BUILDING(30000);

    final int basePrice;

    Price(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }
}

