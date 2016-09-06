package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChargeStandard {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 价格
    */
    private BigDecimal price;

    /**
    * 收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）
    */
    private Const.ChargeType chargeType;

    /**
    * 收费周期（小时）
    */
    private Integer cycleTime;

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
    * 默认收费规格
    */
    private Integer defaultBoxSize;

}