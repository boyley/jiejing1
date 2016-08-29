package com.jiejing.locker.service;

import com.jiejing.locker.SampleApplicationTest;
import com.jiejing.locker.domains.Region;
import com.jiejing.locker.repository.RegionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleApplicationTest.class)
public class RegionServiceTest {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    public void insertTest() {
        Region region = new Region();
        region.setCreatedBy(1);
        region.setCreatedDate(ZonedDateTime.now());
        region.setLastModifiedBy(1);
        region.setLastModifiedDate(ZonedDateTime.now());

        region.setName("name");
        region.setDescription("description");
        region.setCode("code");
        region.setParentId(0);
        region.setUrl("url");
        regionRepository.save(region);

    }
}
