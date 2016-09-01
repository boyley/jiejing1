package com.jiejing.locker.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * 用户其他信息
 * Created by Bogle on 2016/8/29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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

    @Column(name = "num", nullable = false,length = 200)
    private String num;//证件号

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    @Column(name = "url", nullable = false,length = 1000)
    private String url;


    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
