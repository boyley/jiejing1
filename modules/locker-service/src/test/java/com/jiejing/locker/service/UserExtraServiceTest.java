package com.jiejing.locker.service;

import com.jiejing.locker.domains.Dictionary;
import com.jiejing.locker.domains.UserExtra;
import com.jiejing.locker.repository.UserExtraRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/30.
 */
public class UserExtraServiceTest extends AbsServiceTest {

    @Autowired
    private UserExtraRepository userExtraRepository;

    @Test
    public void saveTest() {
        UserExtra userExtra = new UserExtra();
        userExtra.setCreatedDate(ZonedDateTime.now());
        userExtra.setLastModifiedDate(ZonedDateTime.now());
        userExtra.setUserId(1);
        userExtra.setNo("number");
        Dictionary dictionary = new Dictionary();
        dictionary.setId(3);
        userExtra.setDictionary(dictionary);

        this.userExtraRepository.save(userExtra);
    }
}
