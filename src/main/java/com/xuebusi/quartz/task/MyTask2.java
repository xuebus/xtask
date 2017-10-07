package com.xuebusi.quartz.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 测试任务2
 *
 * Created by SYJ on 2017/10/7.
 */
@Service
public class MyTask2 extends BaseTask {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MyTask2.execute().new, date = " + new Date());
    }

    @Override
    public String getCronEexpression() {
        return "0/6 * * * * ?";//每6秒执行一次
    }

}
