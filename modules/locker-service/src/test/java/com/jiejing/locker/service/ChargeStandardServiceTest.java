package com.jiejing.locker.service;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.BoxChargeStandard;
import com.jiejing.locker.domains.ChargeStandard;
import com.jiejing.locker.repository.BoxChargeStandardRepository;
import com.jiejing.locker.repository.ChargeStandardRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/9/2.
 */
public class ChargeStandardServiceTest extends AbsServiceTest {

    @Autowired
    private ChargeStandardRepository chargeStandardRepository;

    @Autowired
    private BoxChargeStandardRepository boxChargeStandardRepository;

    @Test
    public void saveTest1() {
        BoxChargeStandard boxChargeStandard = new BoxChargeStandard(1,1);
        boxChargeStandardRepository.save(boxChargeStandard);
    }

    @Test
    public void findOneByBoxId() {
        printlnJson(this.chargeStandardRepository.findOneByBoxId(1));
    }

}
