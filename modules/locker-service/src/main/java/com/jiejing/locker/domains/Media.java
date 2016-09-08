package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Media {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 标题
    */
    private String title;

    /**
    * 内容
    */
    private String content;

    /**
    * 跳转目标
    */
    private String targetUrl;

    /**
    * 广告链接
    */
    private String url;

    /**
    * 停留时间(单位秒)
    */
    private Integer time;

    /**
    * 排序(越大越前)
    */
    private Integer seq;

    /**
    * 开始时间
    */
    private ZonedDateTime startTime;

    /**
    * 结束时间
    */
    private ZonedDateTime endTime;

    /**
    * 文件类型
    */
    private String media;

    /**
    * 创建人
    */
    private Integer createdBy;

    /**
    * 创建时间
    */
    private ZonedDateTime createdDate;

    /**
    * 最后的更新人
    */
    private Integer lastModifiedBy;

    /**
    * 最后一次更新时间
    */
    private ZonedDateTime lastModifiedDate;

    /**
    * 是否可用
    */
    private Boolean enable;
}