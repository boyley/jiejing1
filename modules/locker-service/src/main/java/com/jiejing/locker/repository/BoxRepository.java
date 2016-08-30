package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Box;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface BoxRepository extends JpaRepository<Box, Integer> {
}
