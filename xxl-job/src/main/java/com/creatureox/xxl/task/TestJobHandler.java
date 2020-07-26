package com.creatureox.xxl.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;

/**
 * @author CreatureOX
 * date: 2020/7/26
 * description:
 */
@Slf4j
@JobHandler(value = "testJobHandler")
public class TestJobHandler extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World.");
        return SUCCESS;
    }
}
