package com.jiejing.locker.service;

import com.jiejing.locker.domains.Dictionary;
import com.jiejing.locker.repository.DictionaryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/29.
 */
public class DictionaryServiceTest extends AbsServiceTest {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Test
    public void insertTest() {
        Dictionary dictionary = new Dictionary();
        dictionary.setCreatedBy(1);
        dictionary.setCreatedDate(ZonedDateTime.now());
        dictionary.setLastModifiedBy(1);
        dictionary.setLastModifiedDate(ZonedDateTime.now());

        dictionary.setCode("code");
        dictionary.setDescription("description");
        dictionary.setName("name");
        dictionary.setValueType("integer");
        dictionary.setValue("1");

        dictionaryRepository.save(dictionary);
    }

    @Test
    public void findOneTest() {
        System.out.println(dictionaryRepository.findOne(3).getCode());
        ;
    }
}
