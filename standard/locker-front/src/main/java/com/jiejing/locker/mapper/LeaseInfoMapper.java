package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.LeaseInfo;
import com.jiejing.locker.web.dto.LeaseInfoDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Bogle on 2016/9/1.
 */
@Mapper(uses = {}, componentModel = "spring")
public abstract class LeaseInfoMapper {

    public abstract LeaseInfo leaseInfoDtoToLeaseInfo(LeaseInfoDto leaseInfoDto);

    public abstract List<LeaseInfo> leaseInfoDtoToLeaseInfo(List<LeaseInfoDto> leaseInfoDtos);
}
