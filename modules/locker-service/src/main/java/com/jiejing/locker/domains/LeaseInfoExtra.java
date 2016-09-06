package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaseInfoExtra {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 资料证件
    */
    private Integer leaseInfoId;

    /**
    * 属性名称
    */
    private String name;

    /**
    * 属性值
    */
    private String value;


}