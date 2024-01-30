package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

    public Drink(String slot, String name, BigDecimal price, String type) {
        super(slot, name, price, type);
    }
    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
