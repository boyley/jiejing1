package com.jiejing.locker.service;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.repository.BoxSizeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Bogle on 2016/8/31.
 */
public class CabinetServiceTest extends AbsServiceTest {


    @Autowired
    private BoxSizeRepository boxSizeRepository;


    @Test
    public void findabc() {
        printlnJson(boxSizeRepository.findAll());
    }
}
