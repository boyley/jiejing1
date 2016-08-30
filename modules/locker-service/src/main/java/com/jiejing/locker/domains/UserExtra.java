package com.jiejing.locker.domains;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * 用户其他信息
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "sys_user_extra")
public class UserExtra implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "cert_type", referencedColumnName = "id", nullable = false)
    private Dictionary certType;//证件类型（引用sys_dictionary）

    @Column(name = "num", nullable = false)
    private String num;//证件号

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    @Override
    public Integer getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Dictionary getCertType() {
        return certType;
    }

    public void setCertType(Dictionary certType) {
        this.certType = certType;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
