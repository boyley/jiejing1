package com.jiejing.locker.web.rest;

import com.jiejing.locker.mapper.OrderMapper;
import com.jiejing.locker.service.IOrderService;
import com.jiejing.locker.web.dto.OrderDto;
import com.jiejing.locker.web.rest.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Bogle on 2016/9/1.
 */
@RestController
@RequestMapping("api/order")
public class OrderResource {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoxSize(OrderDto orderDto) throws URISyntaxException {
//        orderService.save(orderMapper.orderDtoToOrder(orderDto));
        return ResponseEntity.created(new URI("/api/users/" + orderDto.getId()))
                .headers(HeaderUtil.createAlert("order.created",orderDto.getId()))
                .body(orderDto);
    }
}
