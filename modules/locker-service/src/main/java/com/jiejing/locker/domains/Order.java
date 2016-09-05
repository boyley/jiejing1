package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 订单
 * Created by Bogle on 2016/8/30.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "sys_order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"payPrice","retreatrice","createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
public class Order extends AbstractAuditingEntity<Integer> {


    @Column(name = "order_num", nullable = false,length = 32)
    private String orderNum;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state", nullable = true)
    private Const.OrderState orderState;//订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭

    @Column(name = "order_source", nullable = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer orderSource;//下单渠道

    @Column(name = "price", nullable = false,precision=9, scale=2)
    private BigDecimal price;//费用

    @Column(name = "pay_price", nullable = false,precision=9, scale=2)
    private BigDecimal payPrice;//支付费用

    @Column(name = "retreat_price", nullable = true, precision = 9, scale = 2)
    private BigDecimal retreatrice;//找补费用

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "pay_type", nullable = true)
    private Integer payType;//支付方式,关联sys_dictionary表

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String payCode;//支付方式

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LeaseBox leaseBox;
}
