package com.jiejing.locker.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Created by Bogle on 2016/8/29.
 */
@Getter
@Setter
@Entity(name = "sys_user")
public class User implements Persistable<Integer> {

    public enum Sex {
        F("女"), M("男"), N("未知");
        private String value;

        Sex(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @Column(name = "name", nullable = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = true)
    private Sex sex;

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
