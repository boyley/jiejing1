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
@Entity(name = "locker_fetch_box")
@EntityListeners(AuditingEntityListener.class)
public class FetchBox extends AbstractAuditingEntity<Integer> {


    @Column(name = "lease_box_id", nullable = false)
    private Integer leaseBoxId;//租箱记录id

    @Column(name = "order_id", nullable = true)
    private Integer orderId;//补单id
}
