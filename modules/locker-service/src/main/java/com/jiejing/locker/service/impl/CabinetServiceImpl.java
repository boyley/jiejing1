package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.repository.CabinetRepository;
import com.jiejing.locker.service.IBoxService;
import com.jiejing.locker.service.ICabinetService;
import com.jiejing.locker.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class CabinetServiceImpl implements ICabinetService {

    @Autowired
    private CabinetRepository cabinetRepository;

    @Autowired
    private IBoxService boxService;

    @Autowired
    private IRegionService regionService;

    /**
     * 保存柜子信息
     * 1. 查询柜子地理位置是否存在
     * 2. 保存柜子
     * 3. 关联箱子的柜子id
     *
     * @param cabinet
     * @return
     */
    @Override
    public Cabinet save(Cabinet cabinet) {
        // 查询柜子地理位置是否正确
        Integer regionId = cabinet.getRegionId();
        if (regionService.exists(regionId)) {
            throw new RuntimeException("地理位置id：" + regionId + "不存在");
        }
        cabinet = this.cabinetRepository.save(cabinet);
        // 箱子关联柜子id
        if (cabinet.getBoxs() != null) {
            for (Box box : cabinet.getBoxs()) {
                box.setCabinetId(cabinet.getId());
            }
        }
        this.boxService.save(cabinet.getBoxs());
        return cabinet;
    }

    @Override
    public Optional<Cabinet> findOne(Integer id) {
        return this.cabinetRepository.findOneById(id);
    }

    @Override
    public Optional<List<BoxSize>> findBoxSize(int id) {
//        return Optional.ofNullable(cabinetRepository.findBoxSize(id));
        return null;
    }
}
