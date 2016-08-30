package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "locker_charge_standard")
@EntityListeners(AuditingEntityListener.class)
public class ChargeStandard extends AbstractAuditingEntity<Integer> {

    public enum ChargeType {
        TIME_HOUR("时间节点"), TIME_CYCLE("时间段收费");
        private String value;

        ChargeType(String value) {
            this.value = value;
        }
    }


    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;

    @Column(name = "box_size_id", nullable = false)
    private Integer boxSizeId;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private ChargeType chargeType;

    @Column(name = "description", nullable = true)
    private String description;

    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Integer getBoxSizeId() {
        return boxSizeId;
    }

    public void setBoxSizeId(Integer boxSizeId) {
        this.boxSizeId = boxSizeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
