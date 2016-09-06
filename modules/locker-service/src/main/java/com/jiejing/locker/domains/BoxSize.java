package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoxSize {
    private Integer id;

    private Integer cabinetId;

    private Integer boxSizeId;

    private String code;

    private String name;

    private BigDecimal price;

    private String description;

    private boolean enable;//是否有可用的箱子

}