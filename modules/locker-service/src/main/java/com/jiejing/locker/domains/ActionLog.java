package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActionLog {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 操作类型,CX:存箱，QX:取箱
    */
    private Const.OptType optType;

    /**
    * 租箱/取箱id
    */
    private Integer leaseId;

    /**
    * 资料id
    */
    private Integer leaseInfoId;


}