package com.jiejing.locker.domains;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Bogle on 2016/9/2.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BoxSize implements Serializable {

    private Integer id;// 收费标准id
    private String code; // 规格编码
    private String name;// 规格名称
    private BigDecimal price;//价格
    private String description;//描述
}
