package com.example.HW3.command;

public class MageReceiver implements ActionReceiver {

    @Override
    public void attack() {
        System.out.println("Attack with magic");
    }

    @Override
    public void block() {
        System.out.println("Block with magic barrier");
    }

    @Override
    public void counter() {
        System.out.println("Counter with firewall");
    }
}
