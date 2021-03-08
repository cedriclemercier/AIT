package com.example.HW3.model;

import com.example.HW3.adapter.TextFormattable;

public class NewLineFormatter implements TextFormattable {
    @Override
    public String formatText(String text) {
        String formattedText = text.replace(".", "\n");
        return formattedText;
    }
}
