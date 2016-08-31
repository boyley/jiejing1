package com.jiejing.locker.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 字典
 * Created by Bogle on 2016/8/29.
 */
@Getter
@Setter
@Entity(name = "sys_dictionary")
@EntityListeners(AuditingEntityListener.class)
public class Dictionary extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "value_type", nullable = false)
    private String valueType;//字典值类型
    @Column(name = "value", nullable = false)
    private String value;//字典值
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "parent_id", nullable = true)
    private Integer parentId;//父节点id
}
