package com.jiejing.locker.web.rest;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.service.ICabinetService;
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
@RequestMapping("api/cabinet")
public class CabinetResource {

    @Autowired
    private ICabinetService cabinetService;


    @RequestMapping(value = "/boxSize/{id:\\d+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBoxSize(@PathVariable("id") Integer id) {
        return cabinetService.findBoxSize(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/{id:\\d+}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCabinet(@PathVariable("id") Integer id) {
        return cabinetService.findOne(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Cabinet cabinet) {
        cabinet.setStatus(Const.Status.ENABLE);// 状态启用
        cabinet.setVoucherVerify(true);// 是否证件验证
        cabinet.setMultiple(false);//可多次使用
        cabinet.getBoxs().stream().forEach(e -> {
            e.setStatus(Const.Status.ENABLE);//是否禁用: ENABLE:启用
            e.setGateLockState(Const.GateLockState.CLOSE);//门锁状态;OPEN:打开，CLOSE:关闭，ERROR：异常
            e.setDepositState(Const.DepositState.N);//存物状态Y:有存物，N：无存物，ERROR：异常,ZY:占用
        });
        this.cabinetService.save(cabinet);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/api/cabinet/" + cabinet.getId()).build().toUri())
                .headers(HeaderUtil.createAlert("order.created", cabinet.getId()))
                .body(cabinet);
    }


}
