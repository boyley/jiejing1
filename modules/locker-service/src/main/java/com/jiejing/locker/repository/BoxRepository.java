package com.jiejing.locker.repository;

import com.jiejing.locker.defines.Const;
import com.jiejing.locker.domains.Box;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * Created by Bogle on 2016/8/30.
 */
@Mapper
public interface BoxRepository {
    Optional<Box> findOneById(Integer id);


    @Select(value = "select id,name,code,cabinet_id as cabinetId,box_size_id boxSizeId, gate_lock_state gateLockState,deposit_state depositState,`status` from locker_box where box_size_id = #{boxSizeId,jdbcType=INTEGER} AND deposit_state='N' AND gate_lock_state<>'ERROR' AND `status`='ENABLE' limit 1")
    Box findOneEnableBox(@Param("boxSizeId") Integer boxSizeId);


    int update(Box box);

    int saveList(Iterable<Box> entities);
}
