package com.jiejing.locker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/8/31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CabinetDto implements Serializable {

    private String code;
    private String name;
    private Integer regionId;//地址：道路/小区 编码
    private BigDecimal lon;//地理经度
    private BigDecimal lat;//地理纬度
    private String status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
    private Boolean multiple = false;//可多次使用
    private Boolean voucherVerify = false;//是否证件验证
    private String description;


}
