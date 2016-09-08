package com.jiejing.locker.web.rest;

import com.jiejing.locker.domains.Keeplive;
import com.jiejing.locker.service.IKeepliveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bogle on 2016/9/7.
 */
@RestController
@RequestMapping("api/keeplive")
public class KeepliveResource {

    @Autowired
    private IKeepliveService keepliveService;

    @RequestMapping(value = "/feedback",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> keeplive(@RequestBody List<Keeplive> keeplives) {
        int flag = keepliveService.save(keeplives);
        Map result = new HashMap<>();
        result.put("code", flag);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
