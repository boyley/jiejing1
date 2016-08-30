package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 租箱记录
 * Created by Bogle on 2016/8/30.
 */
@Entity(name = "locker_lease_box")
@EntityListeners(AuditingEntityListener.class)
public class LeaseBox extends AbstractAuditingEntity<Integer> {

    public enum BoxState {
        DQ("待取"),YQ("已取");
        private String value;
        BoxState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Column(name = "cabinet_id", nullable = false)
    private Integer cabinetId;

    @Column(name = "box_id", nullable = false)
    private Integer boxId;

    @Column(name = "box_size_id", nullable = false)
    private Integer boxIizeId;

    @Column(name = "cabinet_name", nullable = false)
    private String cabinetName;

    @Column(name = "cabinet_code", nullable = false)
    private String cabinetCode;

    @Column(name = "box_name", nullable = false)
    private String boxName;

    @Column(name = "box_code", nullable = false)
    private String boxCode;

    @Column(name = "box_size_name", nullable = false)
    private String boxSizeName;

    @Column(name = "box_size_code", nullable = false)
    private String boxSizeCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "charge_type", nullable = false)
    private ChargeType chargeType;//收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）

    @Column(name = "cycle_time", nullable = false)
    private Integer cycleTime;//收费周期（小时）

    @Column(name = "price", nullable = false)
    private BigDecimal price;//价格

    @Column(name = "order_id", nullable = false)
    private Integer orderId;//订单id

    @Enumerated(EnumType.STRING)
    @Column(name = "box_state", nullable = false)
    private ChargeType boxState;//箱状态DQ:待取，YQ：已取

    @Column(name = "cert_type", nullable = false)
    private Integer certType;//证件类型（引用sys_dictionary）

    @Column(name = "num", nullable = false)
    private String num;//取箱证件号

    @Column(name = "pwd", nullable = false)
    private String pwd;//取箱密码

    @Column(name = "timeout", nullable = true)
    private Integer timeout;//是否超时寄存,大于0表示超时，具体数值表示超时值

    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getBoxIizeId() {
        return boxIizeId;
    }

    public void setBoxIizeId(Integer boxIizeId) {
        this.boxIizeId = boxIizeId;
    }

    public String getCabinetName() {
        return cabinetName;
    }

    public void setCabinetName(String cabinetName) {
        this.cabinetName = cabinetName;
    }

    public String getCabinetCode() {
        return cabinetCode;
    }

    public void setCabinetCode(String cabinetCode) {
        this.cabinetCode = cabinetCode;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getBoxSizeName() {
        return boxSizeName;
    }

    public void setBoxSizeName(String boxSizeName) {
        this.boxSizeName = boxSizeName;
    }

    public String getBoxSizeCode() {
        return boxSizeCode;
    }

    public void setBoxSizeCode(String boxSizeCode) {
        this.boxSizeCode = boxSizeCode;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(Integer cycleTime) {
        this.cycleTime = cycleTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ChargeType getBoxState() {
        return boxState;
    }

    public void setBoxState(ChargeType boxState) {
        this.boxState = boxState;
    }

    public Integer getCertType() {
        return certType;
    }

    public void setCertType(Integer certType) {
        this.certType = certType;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
