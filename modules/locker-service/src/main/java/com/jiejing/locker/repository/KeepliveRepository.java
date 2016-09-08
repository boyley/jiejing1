package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Keeplive;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Bogle on 2016/9/7.
 */
@Mapper
public interface KeepliveRepository {
    int save(Keeplive keeplive);

    int saveList(List<Keeplive> keeplives);
}
