package com.techelevator;

import java.math.BigDecimal;

public class Munchy extends Item {

    public Munchy(String slot, String name, BigDecimal price, String type) {
        super(slot, name, price, type);
    }
    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
