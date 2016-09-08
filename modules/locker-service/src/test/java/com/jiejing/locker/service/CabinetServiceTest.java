package com.jiejing.locker.service;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.repository.CabinetRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {


    @Autowired
    private CabinetRepository cabinetRepository;


    @Autowired
    private ILeaseBoxService leaseBoxService;

    @Test
    public void boxSize() {
        printlnJson(this.cabinetRepository.findBoxSize(1));
    }

    @Test
    public void leaseBox() {
        LeaseBox leaseBox = new LeaseBox();
        leaseBox.setCabinetId(1);
//        leaseBox.setCheckCode("SFZ");
        printlnJson(leaseBoxService.quXiang(leaseBox).toArray());
    }

    @Test
    public void upload() {
        Cabinet cabinet = new Cabinet();
        cabinet.setLat(new BigDecimal(333));
        cabinet.setName("柜子名称");
        cabinet.setCloseTime(LocalTime.now());
        cabinet.setOpenTime(LocalTime.now());
        cabinet.setMultiple(true);
        cabinet.setVoucherVerify(true);
        cabinet.setCode("编码");
        cabinet.setRegionId(2);

        Box box1 = new Box();
        box1.setCode("编码1");
        box1.setName("名称1");
        box1.setBoxSizeCode("Small");

        Box box2 = new Box();
        box2.setCode("编码2");
        box2.setName("名称3");
        box2.setBoxSizeCode("Medium");

        Box box3 = new Box();
        box3.setCode("编码3");
        box3.setName("名称3");
        box3.setBoxSizeCode("Large");

        Box box4 = new Box();
        box4.setCode("编码4");
        box4.setName("名称4");
        box4.setBoxSizeCode("XLarge");

        List<Box> list = new ArrayList<>();
        list.add(box1);
        list.add(box2);
        list.add(box3);
        list.add(box4);
        cabinet.setBoxs(list);

        printlnJson(cabinet);
    }

    @Test
    public void findBoxSize() {
        printlnJson(cabinetRepository.findBoxSize(1));
    }
}
