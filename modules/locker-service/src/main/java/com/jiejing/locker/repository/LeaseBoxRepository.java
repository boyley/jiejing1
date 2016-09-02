package com.jiejing.locker.repository;

import com.jiejing.locker.domains.LeaseBox;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface LeaseBoxRepository extends JpaRepository<LeaseBox, Integer> {
}
