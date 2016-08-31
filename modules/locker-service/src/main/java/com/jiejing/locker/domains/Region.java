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
 * 区域信息
 * Created by Bogle on 2016/8/29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "sys_region")
@EntityListeners(AuditingEntityListener.class)
public class Region extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "parent_id", nullable = false)
    private Integer parentId;//所属父节点id

    @Column(name = "url", nullable = true)
    private String url;

    @Column(name = "description", nullable = true)
    private String description;
}
