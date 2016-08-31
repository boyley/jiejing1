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
 * 租箱记录
 * Created by Bogle on 2016/8/30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_lease_box")
@EntityListeners(AuditingEntityListener.class)
public class LeaseBox extends AbstractAuditingEntity<Integer> {

    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;

    @Column(name = "box_id", nullable = false)
    private Integer boxId;

    @Column(name = "box_size_id", nullable = false)
    private Integer boxIizeId;

    @Column(name = "cabinet_name", nullable = false)
    private String cabinetName;

    @Column(name = "cabinet_code", nullable = false)
    private String cabinetCode;

    @Column(name = "box_name", nullable = false)
    private String boxName;

    @Column(name = "box_code", nullable = false)
    private String boxCode;

    @Column(name = "box_size_name", nullable = false)
    private String boxSizeName;

    @Column(name = "box_size_code", nullable = false)
    private String boxSizeCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private Const.ChargeType chargeType;//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）

    @Column(name = "cycle_time", nullable = false)
    private Integer cycleTime;//收费周期（小时）

    @Column(name = "price", nullable = false)
    private BigDecimal price;//价格

    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "box_state", nullable = false)
    private Const.BoxState boxState;//箱状态DQ:待取，YQ：已取

    @Column(name = "cert_type", nullable = false)
    private Integer certType;//证件类型（引用sys_dictionary）

    @Column(name = "num", nullable = false)
    private String num;//取箱证件号

    @Column(name = "pwd", nullable = false)
    private String pwd;//取箱密码

    @Column(name = "timeout", nullable = true)
    private Integer timeout;//是否超时寄存,大于0表示超时，具体数值表示超时值
}
