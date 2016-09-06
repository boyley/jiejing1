package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 账号id
    */
    private Integer accountId;

    /**
    * 姓名
    */
    private String name;

    /**
    * male 雄性,female 雌性,null:未知
    */
    private String sex;

    /**
    * 创建时间
    */
    private Date createdDate;

    /**
    * 最后一次更新时间
    */
    private Date lastModifiedDate;


}