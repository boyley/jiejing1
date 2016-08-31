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


}
