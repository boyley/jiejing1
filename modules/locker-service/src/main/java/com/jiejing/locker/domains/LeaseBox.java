package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * 租箱记录
 * Created by Bogle on 2016/8/30.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_lease_box")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate","price","orderId","boxState"})
public class LeaseBox extends AbstractAuditingEntity<Integer> {

    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;

    @Column(name = "box_id", nullable = false)
    private Integer boxId;

    @Column(name = "box_size_id", nullable = false)
    private Integer boxSizeId;

    @Column(name = "charge_standard_id", nullable = false)
    private Integer chargeStandardId;

    @Column(name = "cabinet_name", nullable = false, length = 32)
    private String cabinetName;

    @Column(name = "cabinet_code", nullable = false, length = 32)
    private String cabinetCode;

    @Column(name = "box_name", nullable = false, length = 32)
    private String boxName;

    @Column(name = "box_code", nullable = false, length = 32)
    private String boxCode;

    @Column(name = "box_size_name", nullable = false, length = 32)
    private String boxSizeName;

    @Column(name = "box_size_code", nullable = false, length = 32)
    private String boxSizeCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private Const.ChargeType chargeType;//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）

    @Column(name = "cycle_time", nullable = false)
    private Integer cycleTime;//收费周期（小时）

    @Column(name = "price", nullable = false, precision = 9, scale = 2)
    private BigDecimal price;//价格

    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "box_state", nullable = false)
    private Const.BoxState boxState;//箱状态DQ:待取，YQ：已取

    @Column(name = "check_type", nullable = false)
    private Integer checkType;//校验模式（引用sys_dictionary）

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "timeout", nullable = true)
    private Integer timeout;//是否超时寄存,大于0表示超时，具体数值表示超时值

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "fetch_time", nullable = true)
    private ZonedDateTime fetchime;//取箱时间

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "retreat_id", nullable = true)
    private Integer retreatd;//补单id

    @Transient
    private List<LeaseInfo> leaseInfos;//存储资料
}
