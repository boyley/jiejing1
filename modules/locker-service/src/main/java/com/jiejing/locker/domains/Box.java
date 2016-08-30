package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 箱子信息
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "locker_box")
@EntityListeners(AuditingEntityListener.class)
public class Box extends AbstractAuditingEntity<Integer> {

    public enum GateLockState {
        OPEN("打开"), CLOSE("禁用"), ERROR("异常");
        private String value;

        GateLockState(String value) {
            this.value = value;
        }
    }

    public enum DepositState {
        Y("有存物"), N("无存物"), ERROR("异常");
        private String value;

        DepositState(String value) {
            this.value = value;
        }
    }

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;
    @Column(name = "box_size_id", nullable = false)
    private Integer boxSizeId;
    @Enumerated(EnumType.STRING)
    @Column(name = "gate_lock_state", nullable = true)
    private GateLockState gateLockState;
    @Enumerated(EnumType.STRING)
    @Column(name = "deposit_state", nullable = true)
    private DepositState depositState;//存物状态Y:有存物，N：无存物，ERROR：异常
    @Column(name = "description", nullable = true)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public GateLockState getGateLockState() {
        return gateLockState;
    }

    public void setGateLockState(GateLockState gateLockState) {
        this.gateLockState = gateLockState;
    }

    public DepositState getDepositState() {
        return depositState;
    }

    public void setDepositState(DepositState depositState) {
        this.depositState = depositState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
