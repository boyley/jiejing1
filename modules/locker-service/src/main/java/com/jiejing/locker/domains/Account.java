package com.jiejing.locker.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 账号信息
 * Created by Bogle on 2016/8/29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_account")
public class Account implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "country_code", nullable = false,length = 10)
    private String countryCode; // 国家代码

    @Column(name = "phone_no", nullable = false,length = 32)
    private String phoneNo;

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
