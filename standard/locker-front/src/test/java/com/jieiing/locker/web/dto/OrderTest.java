package com.jieiing.locker.web.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiejing.locker.web.dto.LeaseBoxDto;
import com.jiejing.locker.web.dto.LeaseInfoDto;
import com.jiejing.locker.web.dto.OrderDto;
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
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderSource(1);
        orderDto.setPrice(new BigDecimal(1));
        orderDto.setPayPrice(new BigDecimal(3));

        LeaseBoxDto leaseBoxDto = new LeaseBoxDto();
        leaseBoxDto.setBoxId(1);
        leaseBoxDto.setCheckType(1);

        orderDto.setLeaseBox(leaseBoxDto);


        LeaseInfoDto leaseInfoDto1 = new LeaseInfoDto();
        leaseInfoDto1.setInfoType(1);
        leaseInfoDto1.setInfoContent("188888888888881");

        LeaseInfoDto leaseInfoDto2 = new LeaseInfoDto();
        leaseInfoDto2.setInfoType(2);
        leaseInfoDto2.setInfoContent("188888888888882");

        leaseBoxDto.setLeaseInfos(Arrays.asList(leaseInfoDto1,leaseInfoDto2));
        this.printlnJson(orderDto);
    }

    protected void printlnJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(System.out,obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
