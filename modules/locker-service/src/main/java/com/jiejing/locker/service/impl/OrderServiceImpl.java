package com.jiejing.locker.service.impl;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.LeaseBox;
import com.jiejing.locker.domains.Order;
import com.jiejing.locker.repository.OrderRepository;
import com.jiejing.locker.service.IBoxService;
import com.jiejing.locker.service.ILeaseBoxService;
import com.jiejing.locker.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IBoxService boxService;
    @Autowired
    private ILeaseBoxService leaseBoxService;

    @Autowired
    private OrderRepository orderRepository;
    /**
     * 下单
     *
     * @param order
     * @return
     */
    @Override
    public Order save(final Order order) {
        LeaseBox leaseBox = order.getLeaseBox();
        if(leaseBox == null) throw new RuntimeException("无存箱记录");
        boxService.findOne(leaseBox.getBoxId()).ifPresent(box -> {
            if(box.getStatus() == Const.Status.ENABLE) throw new RuntimeException("禁用箱子");
            if(box.getStatus() == Const.Status.ERROR) throw new RuntimeException("异常箱子");
            if(box.getDepositState() == Const.DepositState.Y) throw new RuntimeException("使用中");
            if(box.getDepositState() == Const.DepositState.ERROR) throw new RuntimeException("异常箱子");
            order.setOrderState(Const.OrderState.DZF);
            order.setOrderNum(orderNum());
            this.orderRepository.save(order);
            leaseBox.setOrderId(order.getId());
            this.leaseBoxService.save(leaseBox);
        });
        return order;
    }

    private String orderNum() {
        return String.valueOf(System.currentTimeMillis());
    }
}
