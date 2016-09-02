package com.jiejing.locker.repository;

import com.jiejing.locker.domains.LeaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface LeaseInfoRespository extends JpaRepository<LeaseInfo, Integer> {
}
