package com.jiejing.locker.domains;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * 箱子信息
 * Created by Bogle on 2016/8/29.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_box_charge_standard")
@EntityListeners(AuditingEntityListener.class)
public class BoxChargeStandard extends AbstractAuditingEntity<Integer> {

    @Column(name = "box_id", nullable = false)
    private Integer boxId;

    @Column(name = "charge_standard_id", nullable = false)
    private Integer chargeStandardId;
}
