package com.example.HW3.decorator;

public class Armor extends CharacterDecorator {
    Character character;

    public Armor(Character character) {
        this.character = character;
    }

    @Override
    public String getLore() {
        return character.getLore() + ", with armor ";
    }

    @Override
    public double attack() {
        return 2 + character.attack();
    }
}
