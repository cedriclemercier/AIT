package com.example.HW3;

import com.example.HW3.model.UserPrototype;
import com.example.HW3.model.UserSpringPrototype;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrototypeTest {

    @Autowired
    UserSpringPrototype usp1;

    @Autowired
    UserSpringPrototype usp2;

    @Test
    // testing traditional way!
    void contextLoads() {
        UserPrototype up = new UserPrototype();
        up.loadData();

        try {
            UserPrototype up1 = (UserPrototype) up.clone();
            UserPrototype up2 = (UserPrototype) up.clone();
            Assertions.assertSame(up1, up2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    void contextLoads2() {
        usp1.loadData();
        usp2.loadData();
        Assertions.assertSame(usp1, usp2);
    }
}
