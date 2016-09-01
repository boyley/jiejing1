package com.jiejing.locker.web.dto;

import com.jiejing.locker.defines.Const;
import lombok.*;

import java.io.Serializable;

/**
 * Created by Bogle on 2016/8/31.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BoxDto implements Serializable {

    private Integer id;
    private String code;
    private Integer cabinetId;
    private Integer boxSizeId;
    private Const.GateLockState gateLockState;
    private Const.DepositState depositState;//存物状态Y:有存物，N：无存物，ERROR：异常
    private String description;
    private Const.Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
}
