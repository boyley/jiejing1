package com.jiejing.locker.service.impl;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.*;
import com.jiejing.locker.repository.OrderRepository;
import com.jiejing.locker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Value("${jiejing.boxSizeCode}")
    String BOX_SIZE_CODE = "box_size";
    @Value("${jiejing.infoTypeCode}")
    String INFO_TYPE_CODE = "Info_type";

    @Autowired
    private IBoxService boxService;
    @Autowired
    private ILeaseBoxService leaseBoxService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ICabinetService cabinetService;

    @Autowired
    private IDictionaryService dictionaryService;

    @Autowired
    private IChargeStandardService chargeStandardService;

    @Autowired
    private ILeaseInfoService leaseInfoService;

    @Autowired
    private IActionLogService actionLogService;

    /**
     * 下单
     *
     * @param order
     * @return
     */
    @Override
    @Transactional
    public Optional<Order> save(final Order order) {
        LeaseBox leaseBox = order.getLeaseBox();
        if (leaseBox == null) throw new RuntimeException("无存箱记录");
        List<LeaseInfo> leaseInfos = leaseBox.getLeaseInfos();
        if (CollectionUtils.isEmpty(leaseInfos)) throw new RuntimeException("没提供资料信息");
        //箱子资料信息
        return boxService.findOne(leaseBox.getBoxId()).map(e -> {
            // 计费标准
            ChargeStandard param = chargeStandardService.findOneByBoxId(e.getId()).orElseGet(() -> chargeStandardService.findOneByDefaultBoxSize(e.getBoxSizeId()).orElseThrow(() -> new RuntimeException("收费规则不存在")));
            leaseBox.setChargeStandardId(param.getId());// 收费标准id
            leaseBox.setPrice(param.getPrice());// 收费标准价格
            leaseBox.setChargeType(param.getChargeType());//收费方式
            leaseBox.setCycleTime(param.getCycleTime());// 收费周期
            order.setPrice(param.getPrice());
            return e;
        }).map(e -> {
            // 订单处理
            order.setOrderState(Const.OrderState.DZF);// 订单状态：DZF:待支付
            if (order.getPayPrice().compareTo(order.getPrice()) < 0) throw new RuntimeException("支付金额不足");
            order.setRetreatrice(order.getPayPrice().subtract(order.getPrice()));//计算找补金额
            orderRepository.save(order);
            order.setOrderNum(this.orderNum(order.getId())); //生成订单号
            leaseBox.setOrderId(order.getId());
            return e;
        }).map(e -> {
            // 箱子处理
            if (e.getStatus() == Const.Status.DISENABLE) throw new RuntimeException("禁用箱子");
            if (e.getStatus() == Const.Status.ERROR) throw new RuntimeException("异常箱子");
            if (e.getDepositState() == Const.DepositState.Y) throw new RuntimeException("使用中");
            if (e.getDepositState() == Const.DepositState.ERROR) throw new RuntimeException("异常箱子");
            leaseBox.setBoxCode(e.getCode());//箱子编码
            leaseBox.setBoxName(e.getName());// 箱子code
            return e;
        }).map(e -> {
            // 柜子处理
            leaseBox.setCabinetId(e.getCabinetId());//柜子id
            Cabinet param = this.cabinetService.findOne(e.getCabinetId()).orElseThrow(() -> new RuntimeException("柜子不存在"));
            leaseBox.setCabinetCode(param.getCode());
            leaseBox.setCabinetName(param.getName());
            return e;
        }).map(e -> {
            // 箱子规格处理
            leaseBox.setBoxSizeId(e.getBoxSizeId());// 规格id
            Dictionary param = dictionaryService.findOne(e.getBoxSizeId()).orElseThrow(() -> new RuntimeException("箱子规格不存在"));
            if (!BOX_SIZE_CODE.equals(param.getParentCode())) throw new RuntimeException("不存在的规格id");
            leaseBox.setBoxSizeName(param.getName());
            leaseBox.setBoxSizeCode(param.getCode());
            return e;
        }).map(e -> {
            // 系列化存储记录
            leaseBox.setBoxState(Const.BoxState.DQ);//状态待取
            leaseBox.setBoxName(e.getName());
            this.leaseBoxService.save(leaseBox);
            return e;
        }).map(e -> {
            // 资料处理
            List<ActionLog> actionLogs = leaseInfos.stream().map(leaseInfo -> {
                Dictionary param = dictionaryService.findOne(leaseInfo.getInfoType()).orElseThrow(() -> new RuntimeException("证件类型不存在"));
                if (!INFO_TYPE_CODE.equals(param.getParentCode())) throw new RuntimeException("不支持的资料类型");
                leaseInfo.setName(param.getName());
                leaseInfo.setCode(param.getCode());
                leaseInfoService.save(leaseInfo);
                return new ActionLog(null, Const.OptType.CX, leaseBox.getId(), leaseInfo.getId());
            }).collect(Collectors.toList());
            actionLogService.save(actionLogs);
            e.setDepositState(Const.DepositState.Y);
            return order;
        });
    }

    private String orderNum(Integer id) {
        return String.valueOf(System.currentTimeMillis());
    }
}
