package com.example.HW3.facade;

import java.sql.Connection;
import java.util.Date;

public class SalesReportHelper {

    public static Connection getSaleDBConnection() {
        return null;
    }

    public void generatePDFReport(Date date) {
        System.out.println("Generating sales report in PDF for " + date);
    }

    public void generateCSVReport(Date date) {
        System.out.println("Generating sales report in CSV for " + date);
    }
}

