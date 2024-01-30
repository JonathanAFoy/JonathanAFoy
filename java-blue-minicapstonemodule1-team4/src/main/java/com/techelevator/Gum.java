package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {

    public Gum(String slot, String name, BigDecimal price, String type) {
        super(slot, name, price, type);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum";
    }
}
