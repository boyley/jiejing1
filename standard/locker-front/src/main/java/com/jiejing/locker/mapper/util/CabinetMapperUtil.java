package com.jiejing.locker.mapper.util;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.LeaseInfo;
import com.jiejing.locker.mapper.BoxMapper;
import com.jiejing.locker.mapper.LeaseInfoMapper;
import com.jiejing.locker.web.dto.BoxDto;
import com.jiejing.locker.web.dto.LeaseInfoDto;
import org.mapstruct.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Set;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class CabinetMapperUtil {

    @Inject
    private BoxMapper boxMapper;

    @Inject
    private LeaseInfoMapper leaseInfoMapper;


    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Fraction1 {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Fraction2 {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Fraction4 {
    }

    @Fraction1
    public Set<BoxDto> fraction1(Set<Box> in) {
        return this.boxMapper.boxToBoxDto(in);
    }

    @Fraction2
    public Set<Box> fraction2(Set<BoxDto> in) {
        return this.boxMapper.boxDtoToBox(in);
    }

    @Fraction4
    public List<LeaseInfo> fraction4(List<LeaseInfoDto> in) {
        return this.leaseInfoMapper.leaseInfoDtoToLeaseInfo(in);
    }
}
