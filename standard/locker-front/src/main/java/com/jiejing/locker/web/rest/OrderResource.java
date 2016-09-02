package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.Order;
import com.jiejing.locker.service.IOrderService;
import com.jiejing.locker.web.rest.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Bogle on 2016/9/1.
 */
@RestController
@RequestMapping("api/order")
public class OrderResource {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoxSize(@RequestBody Order order) {
        return orderService.save(order).map(e -> {
            return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/order/" + e.getId()).build().toUri())
                    .headers(HeaderUtil.createAlert("order.created", e.getId()))
                    .body(order);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
