package com.jiejing.locker.repository;

import com.jiejing.locker.domains.Media;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Bogle on 2016/9/7.
 */
@Mapper
public interface MediaRepository {

    List<Media> findAll();
}
