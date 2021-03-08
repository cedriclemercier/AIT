package com.example.HW3.cor;

import java.util.Scanner;

public class DrinkDispenseChain {

    private DispenseChain c1;

    public DrinkDispenseChain() {
        this.c1 = new Bath10Dispenser();
        DispenseChain c2 = new Bath5Dispenser();
        DispenseChain c3 = new Bath2Dispenser();
        DispenseChain c4 = new Bath1Dispenser();

        // Set chain of responsibiltiy
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);

    }

    public static void main(String[] args) {
        DrinkDispenseChain dispenser = new DrinkDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense!");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            dispenser.c1.dispense(new Currency(amount));
        }
    }
}
