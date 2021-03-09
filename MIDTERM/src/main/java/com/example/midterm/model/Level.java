package com.example.midterm.model;

public enum Level {
    C1(Values.C1), C2(Values.C2), C3(Values.C3);

    private Level (String val) {
        // force equality between name of enum instance and value of constant
        if (!this.name().equals(val)) {
            throw new IllegalArgumentException("Incorrect use of ELanguage");
        }
    }

    public static class Values{
        public static final String C1 = "C1";
        public static final String C2 = "C2";
        public static final String C3 = "C3";
    }
}
