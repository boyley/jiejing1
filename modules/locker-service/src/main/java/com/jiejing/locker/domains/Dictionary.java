package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dictionary {
    /**
    * 主键
    */
    private Integer id;

    /**
    * 字典编码
    */
    private String code;

    /**
    * 字典名称
    */
    private String name;

    /**
    * 字典值类型
    */
    private String valueType;

    /**
    * 字典值
    */
    private String value;

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

    /**
    * 父节点id
    */
    private Integer parentId;

    /**
    * 父节点code
    */
    private String parentCode;

    /**
    * 是否可编辑
    */
    private Boolean editable;

}