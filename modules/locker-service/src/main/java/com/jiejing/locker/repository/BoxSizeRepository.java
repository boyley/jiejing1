package com.jiejing.locker.repository;

import com.jiejing.locker.domains.BoxSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by lenovo on 2016/9/3.
 */
public interface BoxSizeRepository extends JpaRepository<BoxSize, Integer> {

    @Query(nativeQuery = true,value = "SELECT id,code,name,price,description from view_box_size")
    List<BoxSize> findAll();
}
