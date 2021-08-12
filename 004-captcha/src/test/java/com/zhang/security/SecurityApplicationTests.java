package com.zhang.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() {
        int i=1;
        i = i++;
        System.out.println(i);
    }

}
