package com.jiejing.locker.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 字典
 * Created by Bogle on 2016/8/29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "sys_dictionary")
@EntityListeners(AuditingEntityListener.class)
public class Dictionary extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false,length = 32)
    private String code;
    @Column(name = "name", nullable = false,length = 32)
    private String name;
    @Column(name = "value_type", nullable = false,length = 32)
    private String valueType;//字典值类型
    @Column(name = "value", nullable = false)
    private String value;//字典值
    @Column(name = "description", nullable = false,length = 1000)
    private String description;

    @Column(name = "parent_id", nullable = true)
    private Integer parentId;//父节点id
}
