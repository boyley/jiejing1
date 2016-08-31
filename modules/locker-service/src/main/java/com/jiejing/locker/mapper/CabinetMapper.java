package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.repository.CabinetRepository;
import com.jiejing.locker.service.dto.CabinetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.inject.Inject;

/**
 * Created by Bogle on 2016/8/31.
 */
@Mapper(uses = CabinetMapperUtil.class, componentModel = "spring")
public abstract class CabinetMapper {

    @Inject
    private CabinetRepository cabinetRepository;

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
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "boxs", target = "boxs", qualifiedBy = CabinetMapperUtil.Fraction2.class)
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
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "boxs", target = "boxs", qualifiedBy = CabinetMapperUtil.Fraction3.class)
    })
    public abstract Cabinet cabinetDtoToCabinet(CabinetDto cabinetDto);

    public CabinetDto findOne(Integer id) {
        return this.cabinetToCabinetDto(this.cabinetRepository.findOne(id));
    }

    public CabinetDto save(CabinetDto cabinetDto) {
        return this.cabinetToCabinetDto(this.cabinetRepository.save(this.cabinetDtoToCabinet(cabinetDto)));
    }
}
