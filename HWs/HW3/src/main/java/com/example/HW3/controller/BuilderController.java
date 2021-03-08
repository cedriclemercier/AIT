package com.example.HW3.controller;

import com.example.HW3.model.User;
import com.example.HW3.model.UserBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/builder")
public class BuilderController {

    @GetMapping("user1")
    public String getUser1() {
        User u = new UserBuilder()
                .setEmail("chaklam@ait.asia")
                .setName("Chaky")
                .setNationality("Hong Kong")
                .setUid(999)
                .build();
        System.out.println(u.toString());
        return "created!";
    }

    @GetMapping("userAuto")
    public String getUser2() {
        User u = User.builder()
                .email("chaklam@ait.asia")
                .name("Auto")
                .nationality("Hong Kong")
                .uid(998)
                .build();
        System.out.println(u.toString());
        return "created!";
    }
}
