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
 * 订单
 * Created by Bogle on 2016/8/30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "sys_order")
@EntityListeners(AuditingEntityListener.class)
public class Order extends AbstractAuditingEntity<Integer> {



    @Column(name = "order_num", nullable = false)
    private String orderNum;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state", nullable = true)
    private Const.OrderState orderState;//订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭

    @Column(name = "order_source", nullable = true)
    private Integer orderSource;//下单渠道

    @Column(name = "price", nullable = false)
    private BigDecimal price;//费用

    @Column(name = "pay_type", nullable = true)
    private Integer payType;//支付方式,关联sys_dictionary表
}
