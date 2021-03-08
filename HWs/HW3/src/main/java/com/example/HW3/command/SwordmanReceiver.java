package com.example.HW3.command;

public class SwordmanReceiver implements ActionReceiver {
    @Override
    public void attack() {
        System.out.println("Attack with sword");
    }

    @Override
    public void block() {
        System.out.println("Block with shield");
    }

    @Override
    public void counter() {
        System.out.println("Counter with sword trick");
    }
}
