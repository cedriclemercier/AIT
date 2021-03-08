package com.example.HW3.decorator;

public abstract class Character {
    String lore;
    public String getLore() {
        return lore;
    }

    public abstract double attack();
}
