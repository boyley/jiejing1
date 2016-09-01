package com.jiejing.locker.web.rest;

import com.jiejing.locker.service.ICabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bogle on 2016/9/1.
 */
@RestController
@RequestMapping("api/cabinet")
public class CabinetResource {

    @Autowired
    private ICabinetService cabinetService;

    @RequestMapping(value = "/{id:\\d+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCabinetBoxSize(@PathVariable("id") Integer id) {
        return cabinetService.findOne(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
