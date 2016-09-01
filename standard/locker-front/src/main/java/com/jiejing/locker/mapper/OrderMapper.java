package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.Order;
import com.jiejing.locker.mapper.util.CabinetMapperUtil;
import com.jiejing.locker.web.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created by Bogle on 2016/9/1.
 */
@Mapper(uses = CabinetMapperUtil.class, componentModel = "spring")
public abstract class OrderMapper {


    @Mappings({
            @Mapping(source = "boxId", target = "leaseBox.boxId"),
            @Mapping(source = "checkType", target = "leaseBox.checkType")
    })
    public abstract Order orderDtoToOrder(OrderDto orderDto);
}
