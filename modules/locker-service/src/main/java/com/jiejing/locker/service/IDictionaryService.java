package com.jiejing.locker.service;

import com.jiejing.locker.domains.Dictionary;

import java.util.Optional;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface IDictionaryService {

    Optional<Dictionary> findOne(Integer id);
}
