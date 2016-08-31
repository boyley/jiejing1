package com.jiejing.locker.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 订单处理
 * Created by Bogle on 2016/8/30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_order_handle")
@EntityListeners(AuditingEntityListener.class)
public class OrderHandle extends AbstractAuditingEntity<Integer> {


    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

    @Column(name = "action_type", nullable = false)
    private Integer actionType;//动作类型，关联sys_dictionary表

    @Column(name = "description", nullable = true)
    private String description;


}
