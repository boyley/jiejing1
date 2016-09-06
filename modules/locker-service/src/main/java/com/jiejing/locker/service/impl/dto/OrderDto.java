package com.jiejing.locker.service.impl.dto;

import com.jiejing.locker.domains.LeaseBox;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/9/6.
 */
@Data
public class OrderDto implements Serializable {

    /**
     * orderSource:下单渠道
     * boxSizeId:规格id
     * checkType: 存储模式
     */
    private Integer orderSource, boxSizeId, checkType;

    /**
     * code: 证件类型code
     * infoContent: 证件内容（标准json格式）
     */
    private String code, infoContent;
    /**
     * 费用
     */
    private BigDecimal price;

    private LeaseBox leaseBox;
}
