package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cabinet {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 柜子编码
    */
    private String code;

    /**
    * 柜子名称
    */
    private String name;

    /**
    * 地址：道路/小区 编码
    */
    private Integer regionId;

    /**
    * 地理经度
    */
    private BigDecimal lon;

    /**
    * 地理纬度
    */
    private BigDecimal lat;

    /**
    * 是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
    */
    private String status;

    /**
    * 可多次使用
    */
    private Boolean multiple;

    /**
    * 是否证件验证
    */
    private Boolean voucherVerify;

    /**
    * 描述
    */
    private String description;

    /**
    * 创建人
    */
    private Integer createdBy;

    /**
    * 创建时间
    */
    private Date createdDate;

    /**
    * 最后的更新人
    */
    private Integer lastModifiedBy;

    /**
    * 最后一次更新时间
    */
    private Date lastModifiedDate;

    /**
    * 开机时间
    */
    private Date openTime;

    /**
    * 关机时间
    */
    private Date closeTime;


}