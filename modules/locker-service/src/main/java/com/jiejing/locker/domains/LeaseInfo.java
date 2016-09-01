package com.jiejing.locker.domains;

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
@Entity(name = "action_log")
@EntityListeners(AuditingEntityListener.class)
public class LeaseInfo implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "action_id", nullable = false)
    private Integer actionId;//操作记录id

    @Column(name = "info_type", nullable = false)
    private Integer infoType;//操作记录id

    @Column(name = "name", nullable = false, length = 30)
    private Integer name;//资料名称

    @Column(name = "info_content", nullable = false, length = 1000)
    private Integer info_Content;//资料内容

    @Column(name = "info_file", nullable = false, length = 1000)
    private Integer infoile;//资料文件

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}