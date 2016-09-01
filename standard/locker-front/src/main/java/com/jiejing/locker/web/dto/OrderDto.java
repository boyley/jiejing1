package com.jiejing.locker.web.dto;

import com.jiejing.locker.defines.Const;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Bogle on 2016/9/1.
 */

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderDto implements Serializable {

    private Integer id;

    private String orderNum;//订单id

    private Const.OrderState orderState;//订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭

    private Integer orderSource;//下单渠道

    private BigDecimal price;//费用

    private BigDecimal payPrice;//支付费用

    private BigDecimal retreatrice;//找补费用

    private Integer payType;//支付方式,关联sys_dictionary表

    private Integer boxId; //箱子id

    private Integer checkType;//校验模式（引用sys_dictionary）

//    private List<LeaseInfoDto> leaseInfos;//存储资料


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Const.OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(Const.OrderState orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getRetreatrice() {
        return retreatrice;
    }

    public void setRetreatrice(BigDecimal retreatrice) {
        this.retreatrice = retreatrice;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }
}
