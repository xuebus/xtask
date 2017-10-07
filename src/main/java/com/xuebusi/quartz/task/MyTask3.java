package com.xuebusi.quartz.task;

import com.xuebusi.quartz.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试任务3:
 *   推荐使用这种类似于注入 HelloService 并调用其中的方法的方式来执行定时任务
 *
 * Created by SYJ on 2017/10/7.
 */
@Service
public class MyTask3 extends BaseTask {

    @Autowired
    private HelloService helloService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        helloService.hello();
    }

    @Override
    public String getCronEexpression() {
        return "0/8 * * * * ?";//每8秒执行一次
    }

}
