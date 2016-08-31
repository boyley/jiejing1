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
 * 订单
 * Created by Bogle on 2016/8/30.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_fetch_box")
@EntityListeners(AuditingEntityListener.class)
public class FetchBox extends AbstractAuditingEntity<Integer> {


    @Column(name = "lease_box_id", nullable = false)
    private Integer leaseBoxId;//租箱记录id

    @Column(name = "order_id", nullable = true)
    private Integer orderId;//补单id
}
