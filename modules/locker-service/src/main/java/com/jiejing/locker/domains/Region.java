package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"createdBy","createdDate","lastModifiedBy","lastModifiedDate"})
public class Region {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 编码
    */
    private String code;

    /**
    * 节点名称
    */
    private String name;

    /**
    * 所属父节点id
    */
    private Integer parentId;

    /**
    * 访问路径
    */
    private String url;

    /**
    * 描述
    */
    private String description;

    /**
    * 创建人
    */
    private Integer createdBy;

    /**
    * 创建时间
    */
    private Date createdDate;

    /**
    * 最后的更新人
    */
    private Integer lastModifiedBy;

    /**
    * 最后一次更新时间
    */
    private Date lastModifiedDate;


}