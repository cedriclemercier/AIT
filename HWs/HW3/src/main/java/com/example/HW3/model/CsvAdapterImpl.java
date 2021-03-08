package com.example.HW3.model;

import com.example.HW3.adapter.CsvFormattable;
import com.example.HW3.adapter.TextFormattable;

public class CsvAdapterImpl implements TextFormattable {
    CsvFormattable csvFormatter;

    public CsvAdapterImpl(CsvFormattable csvFormatter) {
        this.csvFormatter = csvFormatter;
    }

    @Override
    public String formatText(String text) {
        String formattedText = csvFormatter.formatCsvText(text);
        return formattedText;
    }
}
