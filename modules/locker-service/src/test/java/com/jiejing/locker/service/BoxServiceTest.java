package com.jiejing.locker.service;

import com.jiejing.locker.domains.QBox;
import com.jiejing.locker.repository.BoxRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.SystemProfileValueSource;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/30.
 */
public class BoxServiceTest extends AbsServiceTest {

    @Autowired
    private BoxRepository boxRepository;

    @Test
    public void findOneTest() {
        QBox qBox = QBox.box;
        Predicate predicate = qBox.id.eq(1);

        this.boxRepository.findOne(predicate);
    }
}
