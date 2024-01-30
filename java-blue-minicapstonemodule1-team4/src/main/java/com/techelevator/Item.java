package com.techelevator;

import java.math.BigDecimal;

public abstract class Item { //Abstract class can contain methods that are inherited. More powerful type of interface.

    public String slot;
    public String name;
    public BigDecimal price;
    public String type;
    public int quantity = 5;


    public Item(String slot, String name, BigDecimal price, String type) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }


    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getSound();





}

