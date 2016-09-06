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

    @Autowired
    private ILeaseInfoExtraService leaseInfoExtraService;

    @Override
    public Optional<Order> findOne(Integer id) {
        return Optional.ofNullable(orderRepository.findOneById(id));
    }

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
        Optional<Box> optional = Optional.ofNullable(boxService.findOneEnableBox(leaseBox.getBoxSizeId()));
        if (optional.isPresent()) {
            return optional.map(e -> {
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
                orderRepository.save(order);
                order.setOrderNum(this.orderNum(order.getId())); //生成订单号
                orderRepository.update(order);
                leaseBox.setOrderId(order.getId());
                return e;
            }).map(e -> {
                // 箱子处理
                if (e.getStatus() == Const.Status.DISENABLE) throw new RuntimeException("禁用箱子");
                if (e.getStatus() == Const.Status.ERROR) throw new RuntimeException("异常箱子");
                if (e.getDepositState() == Const.DepositState.Y || e.getDepositState() == Const.DepositState.ZY)
                    throw new RuntimeException("使用中");
                if (e.getDepositState() == Const.DepositState.ERROR) throw new RuntimeException("异常箱子");
                e.setDepositState(Const.DepositState.ZY); // 箱子状态为占用状态
                this.boxService.update(e);
                leaseBox.setBoxCode(e.getCode());//箱子编码
                leaseBox.setBoxName(e.getName());// 箱子code
                leaseBox.setBoxId(e.getId());//
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
                leaseBox.setBoxState(Const.BoxState.ZY);//状态待取
                leaseBox.setBoxName(e.getName());
                this.leaseBoxService.save(leaseBox);
                return e;
            }).map(e -> {
                // 资料处理
                List<ActionLog> actionLogs = leaseInfos.stream().map(leaseInfo -> {
                    Dictionary param = dictionaryService.findOneByCode(leaseInfo.getCode()).orElseThrow(() -> new RuntimeException("证件类型不存在"));
                    if (!INFO_TYPE_CODE.equals(param.getParentCode())) throw new RuntimeException("不支持的资料类型");
                    leaseInfo.setName(param.getName());
                    leaseInfo.setCode(param.getCode());
                    leaseInfo.setInfoType(param.getId());
                    leaseInfoService.save(leaseInfo);
                    leaseInfo.getLeaseInfoExtras().stream().forEach(leaseInfoExtra -> {
                       leaseInfoExtra.setLeaseInfoId(leaseInfo.getId());
                    });

                    this.leaseInfoExtraService.saveList(leaseInfo.getLeaseInfoExtras());

                    return new ActionLog(null, Const.OptType.CX, leaseBox.getId(), leaseInfo.getId());
                }).collect(Collectors.toList());

                actionLogService.save(actionLogs);


                e.setDepositState(Const.DepositState.Y);
                return order;
            });
        }
        throw new RuntimeException("无可用的箱子");
    }


    private String orderNum(Integer id) {
        return String.valueOf(System.currentTimeMillis());
    }
}
