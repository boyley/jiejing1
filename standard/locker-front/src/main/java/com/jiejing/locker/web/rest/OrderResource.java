package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.Order;
import com.jiejing.locker.service.IOrderService;
import com.jiejing.locker.web.rest.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        orderService.save(order);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/order/" + order.getId()).build().toUri())
                .headers(HeaderUtil.createAlert("order.created", order.getId()))
                .body(order);
    }

    @RequestMapping(value = "/pay",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pay(@RequestBody Order order) {
        return ResponseEntity.created(UriComponentsBuilder.fromPath("http://jiejing/pay/url").build().toUri())
                .headers(HeaderUtil.createAlert("order.created", "http://jiejing/pay/url"))
                .body("{\"url\":\"http://jiejing/pay/url\"}");
    }

    @RequestMapping(value = "/{id:\\d+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pay(@PathVariable("id") Integer id) {
        return orderService.findOne(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
