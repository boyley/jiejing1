package com.jiejing.locker.mapper;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.service.dto.BoxDto;
import org.mapstruct.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class CabinetMapperUtil {

    @Inject
    private BoxMapper boxMapper;

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Fraction2 {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Fraction3 {
    }

    @Fraction2
    public Set<BoxDto> fraction2(Set<Box> in) {
        return this.boxMapper.boxToBoxDto(in);
    }

    @Fraction3
    public Set<Box> fraction3(Set<BoxDto> in) {
        return this.boxMapper.boxDtoToBox(in);
    }
}
