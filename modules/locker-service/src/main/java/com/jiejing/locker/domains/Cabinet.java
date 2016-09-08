package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

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
     * 地址：道路/小区 编码
     */
    private Region region;

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
    private Const.Status status;

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
    private ZonedDateTime createdDate;

    /**
    * 最后的更新人
    */
    private Integer lastModifiedBy;

    /**
    * 最后一次更新时间
    */
    private ZonedDateTime lastModifiedDate;

    /**
    * 开机时间
    */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime openTime;

    /**
    * 关机时间
    */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime closeTime;

    /**
     * 箱子列表
     */
    private List<Box> boxs;

}