package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaseInfo {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 资料类型（引用sys_dictionary）
     */
    private Integer infoType;

    /**
     * 证件类型code
     */
    private String code;

    /**
     * 资料名称
     */
    private String name;

    /**
     * 资料文件
     */
    private String infoFile;

    /**
     * 资料信息
     */
    private List<LeaseInfoExtra> leaseInfoExtras;
}