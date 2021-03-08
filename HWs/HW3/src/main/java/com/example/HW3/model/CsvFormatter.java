package com.example.HW3.model;

import com.example.HW3.adapter.CsvFormattable;

public class CsvFormatter implements CsvFormattable {
    @Override
    public String formatCsvText(String text) {
        String formattedText = text.replace(".", ",");
        return formattedText;
    }
}
