package com.jiejing.locker.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * 用户其他信息
 * Created by Bogle on 2016/8/29.
 */
@Getter
@Setter
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
    public boolean isNew() {
        return this.getId() == null;
    }
}
