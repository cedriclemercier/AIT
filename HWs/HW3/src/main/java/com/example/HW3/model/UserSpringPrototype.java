package com.example.HW3.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class UserSpringPrototype {
    private List<String> userList;

    public UserSpringPrototype() {
        userList = new ArrayList<String>();
    }

    public UserSpringPrototype(List<String> list) {
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
}
