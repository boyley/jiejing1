package com.jiejing.locker.domains;

import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@Entity(name = "locker_account")
public class Account implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
