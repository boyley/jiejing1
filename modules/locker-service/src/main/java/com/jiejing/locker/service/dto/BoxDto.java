package com.jiejing.locker.service.dto;

import com.jiejing.locker.defines.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Created by Bogle on 2016/8/31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BoxDto implements Serializable{

    private Integer id;
    private String code;
    private Integer cabinetId;
    private Integer boxSizeId;
    private Const.GateLockState gateLockState;
    private Const.DepositState depositState;//存物状态Y:有存物，N：无存物，ERROR：异常
    private String description;
    private Const.Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
}
