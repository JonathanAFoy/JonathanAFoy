package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String slot, String name, BigDecimal price, String type) {
        super(slot, name, price, type);
    }

    @Override
    public String getSound() {
        return "Yummy Yummy, So Sweet!";
    }
}
