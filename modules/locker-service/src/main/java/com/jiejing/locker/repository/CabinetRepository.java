package com.jiejing.locker.repository;

import com.jiejing.locker.domains.BoxSize;
import com.jiejing.locker.domains.Cabinet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

/**
 * Created by Bogle on 2016/8/29.
 */
@Mapper
public interface CabinetRepository {

    /**
     * 根据id获取柜子信息
     *
     * @param id
     * @return
     */
    Cabinet findOneById(Integer id);

    /**
     * 柜子箱子规格列表
     *
     * @param id
     * @return
     */
    @Select(value = "select id,cabinet_id cabinetId,box_size_id boxSizeId,code,name,price,description from view_box_size where cabinet_id = #{id,jdbcType=INTEGER}")
    List<BoxSize> findBoxSize(@Param("id") Integer id);
}
