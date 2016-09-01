package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.web.dto.BoxSizeDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Bogle on 2016/9/1.
 */
@Mapper(uses = {}, componentModel = "spring")
public abstract class BoxSizeMapper {

    public abstract BoxSizeDto boxSizeToBoxSizeDto(BoxSize boxSize);

    public abstract List<BoxSizeDto> boxSizeToBoxSizeDto(List<BoxSize> boxSizes);
}
