package com.jiejing.locker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiejing.locker.defines.Const;
import com.jiejing.locker.mapper.CabinetMapper;
import com.jiejing.locker.service.dto.BoxDto;
import com.jiejing.locker.service.dto.CabinetDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CabinetMapper cabinetMapper;

    @Autowired
    public ICabinetService cabinetService;

    @Test
    public void save() throws IOException {
        CabinetDto cabinet = new CabinetDto();
        cabinet.setCode("code");
        cabinet.setDescription("description");
        cabinet.setName("name");
        cabinet.setLat(new BigDecimal(3L));
        cabinet.setLon(new BigDecimal(3L));
        cabinet.setRegionId(1);
        cabinet.setStatus(Const.Status.ENABLE);

        BoxDto box = new BoxDto();
        box.setCode("code");
        box.setDescription("description");
        box.setCabinetId(3);
        box.setBoxSizeId(1);

        box.setGateLockState(Const.GateLockState.CLOSE);
        box.setDepositState(Const.DepositState.Y);
        box.setStatus(Const.Status.ENABLE);
        Set<BoxDto> boxDtos = new HashSet<>();
        boxDtos.add(box);
        cabinet.setBoxs(boxDtos);

        mapper.writeValue(System.out, this.cabinetService.save(this.cabinetMapper.cabinetDtoToCabinet(cabinet)));
    }

    @Test
    public void findOne() throws IOException {
        CabinetDto cabinetDto = this.cabinetMapper.cabinetToCabinetDto(this.cabinetService.findOne(3));
        mapper.writeValue(System.out, cabinetDto);
    }
}
