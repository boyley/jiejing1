package com.jiejing.locker.repository;

import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query(nativeQuery = false, value = "SELECT  new com.jiejing.locker.domains.BoxSize ( bs.id,bs.code,bs.name,bs.price,bs.description ,bs.cabinetId) FROM com.jiejing.locker.domains.BoxSize bs where bs.cabinetId=:cabinetId" )
//    @Query(name = "SELECT new com.jiejing.locker.domains.BoxSize(id,code,name,price,description) FROM  com.jiejing.locker.domains.BoxSize", nativeQuery = false)
    List<BoxSize> findBoxSize(@Param("cabinetId") Integer id);
}
