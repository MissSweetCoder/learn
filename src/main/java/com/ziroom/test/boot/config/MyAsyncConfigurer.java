package com.ziroom.test.boot.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2023年02月23日 18:02:00
 */
@Configuration
@EnableAsync
public class MyAsyncConfigurer implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setKeepAliveSeconds(60);//线程空闲时间
        executor.setQueueCapacity(10);//队列程度
        executor.setThreadNamePrefix("my-executor1-");//线程前缀名称
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//配置拒绝策略
        executor.setAllowCoreThreadTimeOut(true);// 允许销毁核心线程
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            System.out.println(method.getName() + "发生异常！异常原因：" + throwable.getMessage() );
        };
    }
}
