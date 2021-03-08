package com.example.HW3.decorator;

public class Mage extends Character {
    public Mage() {
        lore = "Mage";
    }

    @Override
    public double attack() {
        return 12.5;
    }
}
