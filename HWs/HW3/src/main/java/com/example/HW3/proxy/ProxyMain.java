package com.example.HW3.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProxyMain {
    public static void main(String[] args) {
        CommandAccess access = new CommandAccessProxy("Chaklam", "something");
        try {
            Process p = access.runServer("cmd /c dir");
            printResult(p);
        } catch (Exception e) {
            System.out.println("Exception message::" + e.getMessage());
        }
    }

    static void printResult(Process p) {
        String line;
        BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

        try {
            while ((line = bri.readLine()) != null) {
                System.out.println(line);
            }
            bri.close();
            p.waitFor();
            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
