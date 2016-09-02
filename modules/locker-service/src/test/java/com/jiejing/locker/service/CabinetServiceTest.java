package com.jiejing.locker.service;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {

    @Autowired
    public ICabinetService cabinetService;

    @Test
    public void save() throws IOException {
        Cabinet cabinet = new Cabinet();
        cabinet.setCode("code");
        cabinet.setDescription("description");
        cabinet.setName("name");
        cabinet.setLat(new BigDecimal(3L));
        cabinet.setLon(new BigDecimal(3L));
        cabinet.setRegionId(1);
        cabinet.setStatus(Const.Status.ENABLE);

        Box box = new Box();
        box.setCode("code");
        box.setDescription("description");
        box.setCabinetId(3);

        box.setGateLockState(Const.GateLockState.CLOSE);
        box.setDepositState(Const.DepositState.Y);
        box.setStatus(Const.Status.ENABLE);
        Set<Box> boxs = new HashSet<>();
        boxs.add(box);
        cabinet.setBoxs(boxs);

        mapper.writeValue(System.out, this.cabinetService.save(cabinet));
    }

    @Test
    public void findBoxSize() {
        Optional<List<BoxSize>> list =  this.cabinetService.findBoxSize(1);
        printlnJson(list);
    }
}
