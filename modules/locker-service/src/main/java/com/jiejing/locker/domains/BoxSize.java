package com.jiejing.locker.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 箱子规格
 * Created by Bogle on 2016/8/29.
 */
@Getter
@Setter
@Entity(name = "locker_box_size")
@EntityListeners(AuditingEntityListener.class)
public class BoxSize extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;
}
