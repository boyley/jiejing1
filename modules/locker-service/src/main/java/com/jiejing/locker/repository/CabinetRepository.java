package com.jiejing.locker.repository;

import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EntityResult;
import java.util.List;
import java.util.Optional;

/**
 * Created by Bogle on 2016/8/29.
 */
public interface CabinetRepository extends JpaRepository<Cabinet, Integer> {

    /**
     * 根据id获取柜子信息
     *
     * @param id
     * @return
     */
    Optional<Cabinet> findOneById(Integer id);

    /**
     * 柜子箱子规格列表
     *
     * @param id
     * @return
     */
//    @Query(nativeQuery = true,value = "select distinct locker_charge_standard.id, sys_dictionary.`code`, sys_dictionary.`name`, locker_charge_standard.price, sys_dictionary.description from locker_box_charge_standard INNER JOIN locker_box ON locker_box.id = locker_box_charge_standard.box_id INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id INNER JOIN locker_charge_standard on locker_charge_standard.id = locker_box_charge_standard.charge_standard_id INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id  WHERE locker_box.cabinet_id=:id")
    @Query(nativeQuery = false, value = "SELECT  new com.jiejing.locker.domains.BoxSize ( cs.id, dir.code, dir.name, cs.price, dir.description ) FROM com.jiejing.locker.domains.BoxChargeStandard bcs, com.jiejing.locker.domains.Box box, com.jiejing.locker.domains.Cabinet cabinet, com.jiejing.locker.domains.ChargeStandard cs, com.jiejing.locker.domains.Dictionary dir  WHERE box.id = bcs.boxId AND cabinet.id = box.cabinetId AND cs.id = bcs.chargeStandardId AND dir.id = box.boxSizeId and box.cabinetId=:id group by cs.id")
    List<BoxSize> findBoxSize(@Param("id") Integer id);
}
