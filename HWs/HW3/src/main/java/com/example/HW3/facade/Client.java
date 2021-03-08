package com.example.HW3.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        // Generate sales pdf report and logistics csv report using facade
        Facade.generateReport(Facade.Types.SALE, Facade.ReportTypes.PDF, date);
        Facade.generateReport(Facade.Types.LOGISTIC, Facade.ReportTypes.CSV, date);
    }
}
