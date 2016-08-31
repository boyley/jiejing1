package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.service.dto.BoxDto;
import com.jiejing.locker.service.dto.CabinetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

/**
 * Created by Bogle on 2016/8/31.
 */
@Mapper(uses = {}, componentModel = "spring")
public abstract class BoxMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "cabinetId", target = "cabinetId"),
            @Mapping(source = "boxSizeId", target = "boxSizeId"),
            @Mapping(source = "gateLockState", target = "gateLockState"),
            @Mapping(source = "depositState", target = "depositState"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "status")
    })
    public abstract BoxDto boxToBoxDto(Box box);
    public abstract Set<BoxDto> boxToBoxDto(Set<Box> boxs);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "cabinetId", target = "cabinetId"),
            @Mapping(source = "boxSizeId", target = "boxSizeId"),
            @Mapping(source = "gateLockState", target = "gateLockState"),
            @Mapping(source = "depositState", target = "depositState"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "status", target = "status")
    })
    public abstract Box boxDtoToBox(BoxDto boxDto);
    public abstract Set<Box> boxDtoToBox(Set<BoxDto> boxDtos);
}
