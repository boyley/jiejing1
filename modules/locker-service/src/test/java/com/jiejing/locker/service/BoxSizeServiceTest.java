package com.jiejing.locker.service;

import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.repository.BoxSizeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/30.
 */
public class BoxSizeServiceTest extends AbsServiceTest {

    @Autowired
    private BoxSizeRepository boxSizeRepository;

    @Test
    public void saveTest() {
        BoxSize boxSize = new BoxSize();
        boxSize.setCreatedBy(1);
        boxSize.setCreatedDate(ZonedDateTime.now());
        boxSize.setLastModifiedBy(1);
        boxSize.setLastModifiedDate(ZonedDateTime.now());

        boxSize.setCode("code");
        boxSize.setName("name");
        boxSize.setDescription("description");

        this.boxSizeRepository.save(boxSize);
    }
}
