package com.example.HW3.decorator;

public class Weapon extends CharacterDecorator {
    Character character;

    public Weapon(Character character) {
        this.character = character;
    }

    @Override
    public String getLore() {
        return character.getLore() + ", with weapon ";
    }

    @Override
    public double attack() {
        return 10 + character.attack();
    }
}
