package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/29.
 */
@Mapper
public interface DictionaryRepository  {

    Dictionary findOneById(Integer id);

    Dictionary findOneByCode(String code);
}
