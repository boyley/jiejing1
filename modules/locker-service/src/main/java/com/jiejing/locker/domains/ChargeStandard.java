package com.jiejing.locker.domains;

import com.jiejing.locker.defines.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 收费标准
 * Created by Bogle on 2016/8/29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_charge_standard")
@EntityListeners(AuditingEntityListener.class)
public class ChargeStandard extends AbstractAuditingEntity<Integer> {

    @Column(name = "price", nullable = false,precision=9, scale=2)
    private BigDecimal price;//价格

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private Const.ChargeType chargeType;//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）

    @Column(name = "cycle_time", nullable = false)
    private Integer cycleTime;//收费周期（小时）

    @Column(name = "description", nullable = true,length = 1000)
    private String description;

    @Column(name = "default_box_size", nullable = false)
    private Integer defaultBoxSize;
}
