package com.jiejing.locker.domains;

import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 账号信息
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "locker_account")
public class Account implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Override
    public Integer getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
