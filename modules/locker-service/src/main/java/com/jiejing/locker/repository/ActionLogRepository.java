package com.jiejing.locker.repository;

import com.jiejing.locker.domains.ActionLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Bogle on 2016/9/2.
 */
@Mapper
public interface ActionLogRepository  {

    int saveList(List<ActionLog> actionLogs);
}
