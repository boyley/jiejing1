package com.jiejing.locker.service.impl;

import com.jiejing.locker.domains.ActionLog;
import com.jiejing.locker.repository.ActionLogRepository;
import com.jiejing.locker.service.IActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bogle on 2016/9/2.
 */
@Service
public class ActionLogServiceImpl implements IActionLogService {

    @Autowired
    private ActionLogRepository actionLogRepository;

    @Override
    public ActionLog save(ActionLog actionLog) {
        return this.actionLogRepository.save(actionLog);
    }

    @Override
    public List<ActionLog> save(List<ActionLog> actionLogs) {
        return this.actionLogRepository.save(actionLogs);
    }
}
