package com.jiejing.locker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiejing.locker.service.dto.CabinetDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {

    ObjectMapper mapper = new ObjectMapper();

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
        cabinet.setStatus("ENABLE");
        mapper.writeValue(System.out,this.cabinetService.save(cabinet));
    }
}
