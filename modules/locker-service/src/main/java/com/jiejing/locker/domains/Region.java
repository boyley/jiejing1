package com.jiejing.locker.domains;

import com.sun.istack.internal.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "locker_region")
@EntityListeners(AuditingEntityListener.class)
public class Region extends AbstractAuditingEntity<Integer> {

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = true)
    private String name;

    @NotNull
    @Column(name = "parent_id", nullable = false)
    private Integer parentId;

    @Column(name = "url", nullable = true)
    private String url;

    @Column(name = "description", nullable = true)
    private String description;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
