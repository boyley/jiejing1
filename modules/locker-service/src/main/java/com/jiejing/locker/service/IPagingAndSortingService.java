package com.jiejing.locker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by Bogle on 2016/8/30.
 */
public interface IPagingAndSortingService<T, ID extends Serializable> extends ICurdService<T, ID> {

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}
