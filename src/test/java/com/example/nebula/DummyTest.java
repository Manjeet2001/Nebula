package com.example.nebula;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DummyTest {
    @Test
    void Addition(){
        int i = 1 + 1;
        assert i==2;
        assert i*i == 4;
        assertTrue(i==2);
        //assertEquals(3, i*i);
    }
}
