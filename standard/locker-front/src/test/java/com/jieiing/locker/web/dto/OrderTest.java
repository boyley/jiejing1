package com.jieiing.locker.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.domains.LeaseInfo;
import com.jiejing.locker.domains.Order;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Bogle on 2016/9/1.
 */
public class OrderTest {

    @Test
    public void orderDtoJson() {
        Order orderDto = new Order();
        orderDto.setOrderSource(1);
        orderDto.setPrice(new BigDecimal(1));
        orderDto.setPayPrice(new BigDecimal(3));

        LeaseBox leaseBoxDto = new LeaseBox();
        leaseBoxDto.setBoxId(1);
        leaseBoxDto.setCheckType(1);

        orderDto.setLeaseBox(leaseBoxDto);


        LeaseInfo leaseInfoDto1 = new LeaseInfo();
        leaseInfoDto1.setInfoType(1);
        leaseInfoDto1.setInfoContent("188888888888881");

        LeaseInfo leaseInfoDto2 = new LeaseInfo();
        leaseInfoDto2.setInfoType(2);
        leaseInfoDto2.setInfoContent("188888888888882");

        leaseBoxDto.setLeaseInfos(Arrays.asList(leaseInfoDto1, leaseInfoDto2));
        this.printlnJson(orderDto);
    }

    protected void printlnJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            mapper.writeValue(System.out, obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
