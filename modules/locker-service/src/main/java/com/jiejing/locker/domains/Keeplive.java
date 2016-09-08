package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiejing.locker.defines.Const;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Keeplive {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 类型,CABINET:柜子，BOX:箱子
     */
    private Const.ObjectType type;

    /**
     * 柜子/箱子id
     */
    private Integer objectId;

    /**
     * 检测时间
     */
    private ZonedDateTime createdDate;

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 轮询时间
     */
    private ZonedDateTime keepliveTime;

}