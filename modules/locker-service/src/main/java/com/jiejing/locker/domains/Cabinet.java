package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 柜子信息表
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "locker_cabinet")
@EntityListeners(AuditingEntityListener.class)
public class Cabinet extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "region_id", nullable = false)
    private Integer regionId;//地址：道路/小区 编码
    @Column(name = "lon", nullable = true)
    private BigDecimal lon;//地理经度
    @Column(name = "lat", nullable = true)
    private BigDecimal lat;//地理纬度
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
    @Column(name = "multiple", nullable = false)
    private Boolean multiple = false;//可多次使用
    @Column(name = "voucher_verify", nullable = false)
    private Boolean voucherVerify = false;//是否证件验证
    @Column(name = "description", nullable = true)
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public Boolean getVoucherVerify() {
        return voucherVerify;
    }

    public void setVoucherVerify(Boolean voucherVerify) {
        this.voucherVerify = voucherVerify;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
