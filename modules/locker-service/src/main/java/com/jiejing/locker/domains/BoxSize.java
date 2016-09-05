package com.jiejing.locker.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@JsonIgnoreProperties("cabinetId")
@Entity(name = "view_box_size")
public class BoxSize implements Serializable {

    @Id
    private Integer id;// 收费标准id
    private String code; // 规格编码
    private String name;// 规格名称
    private BigDecimal price;//价格
    private String description;//描述
    private Integer cabinetId;
}
