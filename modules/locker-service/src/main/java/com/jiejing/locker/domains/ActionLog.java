package com.jiejing.locker.domains;

import com.jiejing.locker.defines.Const;
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
public class ActionLog implements Persistable<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "opt_type", nullable = false)
    private Const.OptType optType;//操作类型,CX:存箱，QX:取箱

    @Column(name = "lease_id", nullable = true)
    private Integer leaseId;//存箱记录id

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.getId() == null;
    }
}
