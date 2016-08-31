package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface BoxRepository extends JpaRepository<Box, Integer>, QueryDslPredicateExecutor<Box> {

//    @Query(value = "SELECT * FROM locker_box_size RIGHT JOIN (SELECT locker_box.box_size_id box_size_id FROM locker_box LEFT JOIN locker_cabinet ON  (locker_cabinet.id = locker_box.cabinet_id)  WHERE locker_cabinet.id = :cabinet_id ) AS tab ON (tab.box_size_id = locker_box_size.id)" ,nativeQuery = true)
    @Query(value = "SELECT box_size.id,box_size.`code`,box_size.`name`,box_size.description,box_size.created_by,box_size.created_date,box_size.last_modified_by,box_size.last_modified_date FROM locker_box_size box_size RIGHT JOIN ( SELECT box.box_size_id box_size_id,box.cabinet_id FROM locker_box box LEFT JOIN locker_cabinet cabinet ON cabinet.id = box.cabinet_id WHERE cabinet.id = :cabinet_id  ) AS tab ON ( tab.box_size_id = box_size.id )" ,nativeQuery = true)
    List<Box> findAll(@Param("cabinet_id") Integer cabinetId);

}
