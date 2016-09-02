package com.jiejing.locker.domains;

import com.jiejing.locker.defines.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * 柜子信息表
 * Created by Bogle on 2016/8/29.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "locker_cabinet")
@EntityListeners(AuditingEntityListener.class)
public class Cabinet extends AbstractAuditingEntity<Integer> {

    @Column(name = "code", nullable = false,length = 32)
    private String code;
    @Column(name = "name", nullable = false,length = 32)
    private String name;
    @Column(name = "region_id", nullable = false)
    private Integer regionId;//地址：道路/小区 编码
    @Column(name = "lon", nullable = true,precision=10, scale=5)
    private BigDecimal lon;//地理经度
    @Column(name = "lat", nullable = true,precision=10, scale=2)
    private BigDecimal lat;//地理纬度
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Const.Status status;//是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常
    @Column(name = "multiple", nullable = false)
    private Boolean multiple = false;//可多次使用
    @Column(name = "voucher_verify", nullable = false)
    private Boolean voucherVerify = false;//是否证件验证
    @Column(name = "description", nullable = true,length = 1000)
    private String description;

    @Column(name = "open_time", nullable = false)
    private ZonedDateTime openTime = ZonedDateTime.now();//开机时间

    @Column(name = "close_time", nullable = false)
    private ZonedDateTime closeTime = ZonedDateTime.now();//关机时间

//        @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "cabinet_id", referencedColumnName = "id")
    @Transient
    private Set<Box> boxs;
}
