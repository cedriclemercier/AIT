package com.example.HW3.model;

import java.util.ArrayList;
import java.util.List;

public class UserPrototype implements Cloneable {
    private List<String> userList;

    public UserPrototype() {
        userList = new ArrayList<String>();
    }

    public UserPrototype(List<String> list) {
        this.userList = list;
    }

    public void loadData() {
        userList.add("Pankaj");
        userList.add("Raj");
        userList.add("David");
        userList.add("Lisa");
    }

    public List<String> getUserList() {
        return userList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        for (String s: this.getUserList()) {
            temp.add(s);
        }
        return new UserPrototype(temp);
    }
}
