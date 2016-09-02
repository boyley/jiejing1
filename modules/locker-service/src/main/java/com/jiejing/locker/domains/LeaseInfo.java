package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 订单
 * Created by Bogle on 2016/8/30.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_lease_info")
@EntityListeners(AuditingEntityListener.class)
public class LeaseInfo implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "info_type", nullable = false)
    private Integer infoType;//资料类型（引用sys_dictionary）,存取动作

    @Column(name = "code", nullable = false,length = 32)
    private String code;

    @Column(name = "name", nullable = false, length = 30)
    private String name;//资料名称

    @Column(name = "info_content", nullable = false, length = 1000)
    private String infoContent;//资料内容

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "info_file", nullable = false, length = 1000)
    private String infoile;//资料文件

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
