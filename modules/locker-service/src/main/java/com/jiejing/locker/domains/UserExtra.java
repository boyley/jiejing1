package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserExtra {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 证件类型（引用sys_dictionary）
     */
    private Integer certType;

    /**
     * 证件号
     */
    private String num;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 最后一次更新时间
     */
    private Date lastModifiedDate;

    /**
     * 图片url
     */
    private String url;


}