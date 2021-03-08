package com.example.HW3.command;

public class Factory {
    public static ActionReceiver getCharacterClass(String characterClass) {
        if (characterClass.contains("Mage")) {
            return new MageReceiver();
        } else {
            return new SwordmanReceiver();
        }
    }
}
