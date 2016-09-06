package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 国家代码
    */
    private String countryCode;

    /**
    * 手机号
    */
    private String phoneNo;
}