package com.example.HW3.model;

public class Admin implements Role {

    private String name;

    public Admin() {
        super();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public void checkAccess() {
        System.out.println("Granted access level: Admin");
    }
}
