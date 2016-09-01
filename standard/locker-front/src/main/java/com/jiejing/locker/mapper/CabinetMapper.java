package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.mapper.util.CabinetMapperUtil;
import com.jiejing.locker.web.dto.CabinetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by Bogle on 2016/8/31.
 */
@Mapper(uses =  CabinetMapperUtil.class, componentModel = "spring")
public abstract class CabinetMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "regionId", target = "regionId"),
            @Mapping(source = "lon", target = "lon"),
            @Mapping(source = "lat", target = "lat"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "multiple", target = "multiple"),
            @Mapping(source = "voucherVerify", target = "voucherVerify"),
            @Mapping(source = "description", target = "description")
            , @Mapping(source = "boxs", target = "boxs", qualifiedBy = CabinetMapperUtil.Fraction1.class)
    })
    public abstract CabinetDto cabinetToCabinetDto(Cabinet cabinet);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "regionId", target = "regionId"),
            @Mapping(source = "lon", target = "lon"),
            @Mapping(source = "lat", target = "lat"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "multiple", target = "multiple"),
            @Mapping(source = "voucherVerify", target = "voucherVerify"),
            @Mapping(source = "description", target = "description")
            , @Mapping(source = "boxs", target = "boxs", qualifiedBy = CabinetMapperUtil.Fraction2.class)
    })
    public abstract Cabinet cabinetDtoToCabinet(CabinetDto cabinetDto);
}
