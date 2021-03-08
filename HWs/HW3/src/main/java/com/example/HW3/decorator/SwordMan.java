package com.example.HW3.decorator;

public class SwordMan extends Character {

    public SwordMan() {
        lore = "SwordMan";
    }

    @Override
    public double attack() {
        return 15.0;
    }
}
