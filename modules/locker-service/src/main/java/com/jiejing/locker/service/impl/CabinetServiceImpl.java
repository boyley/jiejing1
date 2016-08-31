package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.Box;
import com.jiejing.locker.domains.Cabinet;
import com.jiejing.locker.repository.CabinetRepository;
import com.jiejing.locker.service.IBoxSizeService;
import com.jiejing.locker.service.ICabinetService;
import com.jiejing.locker.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bogle on 2016/8/31.
 */
@Service
public class CabinetServiceImpl implements ICabinetService {

    @Autowired
    private CabinetRepository cabinetRepository;

    @Autowired
    private IBoxSizeService boxSizeService;

    @Autowired
    private IRegionService regionService;

    /**
     * 保存柜子信息
     * 1. 查询柜子地理位置是否存在
     * 2. 查询箱子规格是否录入
     * 3. 保存柜子
     * 4. 关联箱子的柜子id
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
        // 查询箱子规格信息是否正确
        if (cabinet.getBoxs() != null) {
            for (Box box : cabinet.getBoxs()) {
                if (!this.boxSizeService.exists(box.getId())) {
                    throw new RuntimeException("规格id:" + box.getId() + "不存在，请联系管理员");
                }
            }
        }
        cabinet = this.cabinetRepository.save(cabinet);
        // 箱子关联柜子id
        if (cabinet.getBoxs() != null) {
            for (Box box : cabinet.getBoxs()) {
                box.setCabinetId(cabinet.getId());
            }
        }
        this.boxSizeService.save(cabinet.getBoxs());
        return cabinet;
    }

    @Override
    public Cabinet findOne(Integer id) {
        return this.cabinetRepository.findOne(id);
    }
}
