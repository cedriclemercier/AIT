package com.example.HW3.proxy;

public class CommandAccessImpl implements CommandAccess {

    @Override
    public Process runServer(String cmd) throws Exception {
        Process p = Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
        return p;
    }
}
