package com.jiejing.locker.domains;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/8/29.
 */
@Entity(name = "locker_cabinet")
@EntityListeners(AuditingEntityListener.class)
public class Cabinet extends AbstractAuditingEntity<Integer> {

    public enum Status {
        ENABLE("启用"), DISENABLE("禁用"), ERROR("异常");
        private String value;

        Status(String value) {
            this.value = value;
        }
    }

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "region_id", nullable = false)
    private Integer regionId;
    @Column(name = "lon", nullable = true)
    private BigDecimal lon;
    @Column(name = "lat", nullable = true)
    private BigDecimal lat;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "multiple", nullable = false)
    private Boolean multiple = false;
    @Column(name = "voucher_verify", nullable = false)
    private Boolean voucherVerify = false;
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
