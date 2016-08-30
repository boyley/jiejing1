package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 字典
 * Created by Bogle on 2016/8/29.
 */
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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
