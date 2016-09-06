package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderHandle {
    /**
    * 主键
    */
    private Integer id;

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
    * 订单id
    */
    private Integer orderId;

    /**
    * 动作类型，关联sys_dictionary表
    */
    private Integer actionType;

    /**
    * 描述
    */
    private String description;


}