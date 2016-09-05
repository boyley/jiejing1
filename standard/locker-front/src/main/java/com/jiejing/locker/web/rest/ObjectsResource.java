package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.service.ILeaseBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bogle on 2016/9/5.
 */
@RestController
@RequestMapping("api/objects")
public class ObjectsResource {

    @Autowired
    private ILeaseBoxService leaseBoxService;

    @RequestMapping(value = "/get",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoxSize(@RequestBody LeaseBox leaseBox) {
        List<LeaseBox> leaseBoxes = leaseBoxService.quXiang(leaseBox).collect(Collectors.toList());
        if (leaseBoxes.size() > 0) return new ResponseEntity<>(leaseBoxes, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
