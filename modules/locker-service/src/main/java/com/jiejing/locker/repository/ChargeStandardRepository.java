package com.jiejing.locker.repository;

import com.jiejing.locker.domains.ChargeStandard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/30.
 */
@Mapper
public interface ChargeStandardRepository{

    @Select(value = "select locker_charge_standard.id, locker_charge_standard.price, locker_charge_standard.charge_type chargeType, locker_charge_standard.description, locker_charge_standard.default_box_size defaultBoxSize from locker_charge_standard LEFT JOIN locker_box_charge_standard ON locker_box_charge_standard.charge_standard_id=locker_charge_standard.id WHERE locker_box_charge_standard.box_id=#{boxId,jdbcType=INTEGER} ORDER BY locker_box_charge_standard.created_date DESC LIMIT 1")
    ChargeStandard findOneByBoxId(@Param("boxId") Integer id);

    /**
     * 根据规格得到默认的收费标准
     *
     * @param id
     * @return
     */
    @Select(value = "select locker_charge_standard.id, locker_charge_standard.price, locker_charge_standard.charge_type chargeType, locker_charge_standard.description, locker_charge_standard.default_box_size defaultBoxSize from locker_charge_standard WHERE default_box_size=#{boxSize,jdbcType=INTEGER} ORDER BY created_date DESC LIMIT 1")
    ChargeStandard findOneByDefaultBoxSize(@Param("boxSize") Integer id);
}
