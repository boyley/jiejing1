package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Box {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 箱子名称
    */
    private String name;

    /**
    * 箱子编号
    */
    private String code;

    /**
    * 柜子外键
    */
    private Integer cabinetId;

    /**
    * 箱子规格外键
    */
    private Integer boxSizeId;

    private String boxSizeCode;

    /**
    * 门锁状态;OPEN:打开，CLOSE:关闭，ERROR：异常
    */
    private Const.GateLockState gateLockState;

    /**
    * 存物状态Y:有存物，N：无存物，ERROR：异常,ZY:占用
    */
    private Const.DepositState depositState;

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
    * 描述
    */
    private String description;

    /**
    * 是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
    */
    private Const.Status status;

}