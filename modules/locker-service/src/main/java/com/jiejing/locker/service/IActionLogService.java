package com.jiejing.locker.service;

import com.jiejing.locker.domains.ActionLog;

import java.util.List;

/**
 * Created by Bogle on 2016/9/2.
 */
public interface IActionLogService {

    ActionLog save(ActionLog actionLog);

    List<ActionLog> save(List<ActionLog> actionLogs);
}
