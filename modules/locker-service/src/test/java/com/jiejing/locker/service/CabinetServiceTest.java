package com.jiejing.locker.service;

import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.repository.CabinetRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/29.
 */
public class CabinetServiceTest extends AbsServiceTest {

    @Autowired
    private CabinetRepository cabinetRepository;

    @Test
    public void saveTest() {
        Cabinet cabinet = new Cabinet();

        cabinet.setCreatedBy(1);
        cabinet.setCreatedDate(ZonedDateTime.now());
        cabinet.setLastModifiedBy(1);
        cabinet.setLastModifiedDate(ZonedDateTime.now());

        cabinet.setCode("code");
        cabinet.setDescription("description");
        cabinet.setName("name");
        cabinet.setLat(new BigDecimal(3L));
        cabinet.setLon(new BigDecimal(3L));
        cabinet.setRegionId(1);
        cabinet.setStatus(Cabinet.Status.ENABLE);

        this.cabinetRepository.save(cabinet);
    }
}
