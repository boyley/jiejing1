package com.jiejing.locker.service;

import com.jiejing.locker.domains.Keeplive;

import java.util.List;

/**
 * Created by Bogle on 2016/9/7.
 */
public interface IKeepliveService {
    int save(Keeplive keeplive);

    int save(List<Keeplive> keeplives);
}
