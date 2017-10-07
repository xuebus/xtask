package com.xuebusi.quartz.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 要执行的任务
 * Created by SYJ on 2017/10/7.
 */
@Service
public class HelloService {

    //打印当前日期
    public void hello() {
        System.out.println("\t\t\t" + this.getClass().getSimpleName() + ".hello(), date=" + new Date());
    }

}
