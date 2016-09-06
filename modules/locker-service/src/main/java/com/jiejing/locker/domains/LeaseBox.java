package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaseBox {
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
     * 存储柜id
     */
    private Integer cabinetId;

    /**
     * 存储箱id
     */
    private Integer boxId;

    /**
     * 存储箱规格id
     */
    private Integer boxSizeId;

    /**
     * 计费标准id
     */
    private Integer chargeStandardId;

    /**
     * 存储柜名称
     */
    private String cabinetName;

    /**
     * 存储柜编码
     */
    private String cabinetCode;

    /**
     * 存储箱名称
     */
    private String boxName;

    /**
     * 存储箱名称
     */
    private String boxCode;

    /**
     * 存储箱规格名称
     */
    private String boxSizeName;

    /**
     * 存储箱规格编码
     */
    private String boxSizeCode;

    /**
     * 收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）
     */
    private Const.ChargeType chargeType;

    /**
     * 收费周期（小时）
     */
    private Integer cycleTime;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 箱状态DQ:待取，YQ：已取,ZY:占用
     */
    private Const.BoxState boxState;

    /**
     * 校验模式（引用sys_dictionary）
     */
    private Integer checkType;

    private String checkCode;//取件方式

    /**
     * 是否超时寄存,大于0表示超时，具体数值表示超时值
     */
    private Integer timeout;

    /**
     * 取箱时间
     */
    private Date fetchTime;

    /**
     * 补单id
     */
    private Integer retreatId;

    private List<LeaseInfo> leaseInfos;//存储资料
}