package com.jiejing.locker.service;

import com.jiejing.locker.domains.Account;
import com.jiejing.locker.domains.User;
import com.jiejing.locker.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/30.
 */
public class UserServiceTest extends AbsServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User();
        Account account = new Account();
        account.setPhoneNo("1888888888");


        user.setAccount(account);
        user.setName("name");
        user.setCreatedDate(ZonedDateTime.now());
        user.setLastModifiedDate(ZonedDateTime.now());
        user.setSex(User.Sex.M);
        this.userRepository.save(user);
    }
}
