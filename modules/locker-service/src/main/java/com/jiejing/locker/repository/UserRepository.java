package com.jiejing.locker.repository;

import com.jiejing.locker.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
