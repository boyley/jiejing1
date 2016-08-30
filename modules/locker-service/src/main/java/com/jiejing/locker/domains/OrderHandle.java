package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 订单处理
 * Created by Bogle on 2016/8/30.
 */
@Entity(name = "locker_order_handle")
@EntityListeners(AuditingEntityListener.class)
public class OrderHandle extends AbstractAuditingEntity<Integer> {


    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

    @Column(name = "action_type", nullable = false)
    private Integer actionType;//动作类型，关联sys_dictionary表

    @Column(name = "description", nullable = true)
    private String description;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
