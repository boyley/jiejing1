package com.jiejing.locker.domains;

import com.jiejing.locker.defines.Const;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 箱子信息
 * Created by Bogle on 2016/8/29.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_box")
@EntityListeners(AuditingEntityListener.class)
public class Box extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false,length = 32)
    private String code;
    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;
    @Column(name = "box_size_id", nullable = false)
    private Integer boxSizeId;
    @Enumerated(EnumType.STRING)
    @Column(name = "gate_lock_state", nullable = true)
    private Const.GateLockState gateLockState;
    @Enumerated(EnumType.STRING)
    @Column(name = "deposit_state", nullable = true)
    private Const.DepositState depositState;//存物状态Y:有存物，N：无存物，ERROR：异常
    @Column(name = "description", nullable = true,length = 1000)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Const.Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
}
