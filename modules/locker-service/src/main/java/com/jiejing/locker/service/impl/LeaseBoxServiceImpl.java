package com.jiejing.locker.service.impl;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.repository.LeaseBoxRepository;
import com.jiejing.locker.service.ILeaseBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class LeaseBoxServiceImpl implements ILeaseBoxService {

    @Autowired
    private LeaseBoxRepository leaseBoxRepository;


    @Override
    public LeaseBox save(LeaseBox leaseBox) {
        return leaseBoxRepository.save(leaseBox);
    }

    @Override
    public Stream<LeaseBox> quXiang(LeaseBox leaseBox) {
        return leaseBoxRepository.findAll(leaseBox.getCabinetId(), leaseBox.getCheckCode()).map(e -> {
            Const.ChargeType chargeType = e.getChargeType();//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）
            Integer cycleTime = e.getCycleTime(); //收费周期（小时）
            LocalDateTime lastModifiedDate = e.getLastModifiedDate().toLocalDateTime();//订单完成时间
            if (chargeType == Const.ChargeType.TIME_HOUR) {
                //时间节点,如每天24:00结算
            } else if (chargeType == Const.ChargeType.TIME_CYCLE) {
                // 时间段收费 如每3小时收费一次费
            }
            return e;
        });
    }
}
