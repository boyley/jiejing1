package com.jiejing.locker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by Bogle on 2016/8/30.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public abstract class AbsServiceTest {

    ObjectMapper mapper = new ObjectMapper();

    protected void printlnJson(Object obj) {
        try {
            mapper.writeValue(System.out,obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
