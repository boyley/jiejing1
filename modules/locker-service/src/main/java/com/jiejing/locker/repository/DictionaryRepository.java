package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bogle on 2016/8/29.
 */
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
}