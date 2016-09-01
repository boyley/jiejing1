package com.jiejing.locker.web.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Bogle on 2016/9/1.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LeaseInfoDto implements Serializable {

    private Integer infoType;//资料类型（引用sys_dictionary）,存取动作
    private String infoContent;//资料内容
}
