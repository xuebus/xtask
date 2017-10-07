package com.xuebusi.quartz.task;

import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 测试任务1
 *
 * Created by SYJ on 2017/10/7.
 */
@Service
public class MyTask extends BaseTask {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MyTask.execute().new, date = " + new Date());
    }

    @Override
    public String getCronEexpression() {
        return "0/3 * * * * ?";//每3秒执行一次
    }
}
