package com.jiejing.locker.domains;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 订单
 * Created by Bogle on 2016/8/30.
 */
@Getter
@Setter
@Entity(name = "sys_order")
@EntityListeners(AuditingEntityListener.class)
public class Order extends AbstractAuditingEntity<Integer> {

    public enum OrderState {
        DZF("待支付"),YZF("已支付"),YQX("已取消"),YWC("已完成"),YGB("已关闭");
        private String value;
        OrderState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Column(name = "order_num", nullable = false)
    private String orderNum;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state", nullable = true)
    private OrderState orderState;//订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭

    @Column(name = "order_source", nullable = true)
    private Integer orderSource;//下单渠道

    @Column(name = "price", nullable = false)
    private BigDecimal price;//费用

    @Column(name = "pay_type", nullable = true)
    private Integer payType;//支付方式,关联sys_dictionary表
}