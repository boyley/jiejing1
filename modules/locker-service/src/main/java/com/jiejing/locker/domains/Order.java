package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNum;

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
     * 订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭
     */
    private Const.OrderState orderState;

    /**
     * 下单渠道
     */
    private Integer orderSource;

    /**
     * 费用
     */
    private BigDecimal price;

    /**
     * 支付金额
     */
    private BigDecimal payPrice;

    /**
     * 支付方式,关联sys_dictionary表
     */
    private Integer payType;

    private LeaseBox leaseBox;


}