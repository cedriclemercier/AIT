package com.example.HW3.cor;

public class Bath1Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 1) {
            int num = cur.getAmount() / 1;
            int remainder = cur.getAmount() % 1;
            System.out.println("Dispensing " + num + " 1 bath coin(s)");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            // go to next chain
            this.chain.dispense(cur);
        }
    }
}
