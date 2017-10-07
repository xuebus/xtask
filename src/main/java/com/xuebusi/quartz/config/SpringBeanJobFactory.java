package com.xuebusi.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 为了将我们定义的 Job 交给 Spring 来管理，
 * 这里使用到了 Spring 提供的 AutowireCapableBeanFactory
 *
 * Created by SYJ on 2017/10/7.
 */
@Component
public class SpringBeanJobFactory extends AdaptableJobFactory {

    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobinstance = super.createJobInstance(bundle);
        capableBeanFactory.autowireBean(jobinstance);
        return jobinstance;
    }
}
