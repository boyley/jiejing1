package com.jiejing.locker.service;

import com.jiejing.locker.domains.ChargeStandard;
import com.jiejing.locker.repository.ChargeStandardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/30.
 */
public class ChargeStandardServiceTest extends AbsServiceTest {
    @Autowired
    private ChargeStandardRepository chargeStandardRepository;

    @Test
    public void saveTest() {
        ChargeStandard chargeStandard = new ChargeStandard();
        chargeStandard.setCreatedBy(1);
        chargeStandard.setCreatedDate(ZonedDateTime.now());
        chargeStandard.setLastModifiedBy(1);
        chargeStandard.setLastModifiedDate(ZonedDateTime.now());

        chargeStandard.setDescription("description");

        chargeStandard.setCabinetId(1);
        chargeStandard.setBoxSizeId(1);
        chargeStandard.setPrice(new BigDecimal(3));
        chargeStandard.setChargeType(ChargeStandard.ChargeType.TIME_CYCLE);

        this.chargeStandardRepository.save(chargeStandard);
    }
}
