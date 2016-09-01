package com.jiejing.locker.web.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by Bogle on 2016/9/1.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BoxSizeDto implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private String description;
}
