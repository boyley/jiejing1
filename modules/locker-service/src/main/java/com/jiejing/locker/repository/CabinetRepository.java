package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
