package com.jiejing.locker.web.rest;

import com.jiejing.locker.mapper.BoxSizeMapper;
import com.jiejing.locker.service.IBoxSizeService;
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
@RequestMapping("api/boxSize")
public class BoxSizeResource {

    @Autowired
    private IBoxSizeService boxSizeService;

    @Autowired
    private BoxSizeMapper boxSizeMapper;


    /**
     * 根据箱子id获取箱子信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoxSize(@PathVariable("id") Integer id) {
        return boxSizeService.findOne(id)
                .map(e -> new ResponseEntity<>(boxSizeMapper.boxSizeToBoxSizeDto(e), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 获取柜子的箱子规格列表
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/cabinet/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCabinetBoxSize(@PathVariable("id") Integer id) {
        return boxSizeService.findAll(id)
                .map(e -> new ResponseEntity<>(boxSizeMapper.boxSizeToBoxSizeDto(e), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
