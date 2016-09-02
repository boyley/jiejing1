package com.jiejing.locker.repository;

import com.jiejing.locker.domains.ChargeStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface ChargeStandardRepository extends JpaRepository<ChargeStandard, Integer> {

    @Query(nativeQuery = true,value = "select locker_charge_standard.* from locker_charge_standard LEFT JOIN locker_box_charge_standard ON locker_box_charge_standard.charge_standard_id=locker_charge_standard.id WHERE locker_box_charge_standard.box_id=?1 ORDER BY locker_box_charge_standard.created_date DESC LIMIT 1")
    Optional<ChargeStandard> findOneByBoxId(Integer id);

    /**
     * 根据规格得到默认的收费标准
     * @param id
     * @return
     */
    Optional<ChargeStandard> findOneByDefaultBoxSize(Integer id);
}
