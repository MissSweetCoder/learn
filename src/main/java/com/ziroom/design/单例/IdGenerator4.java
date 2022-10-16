package com.ziroom.design.单例;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 18:05:00
 */
public enum IdGenerator4 {
    INSTANCE;
    private AtomicLong atomicLong = new AtomicLong();
    public Long getId(){
        return atomicLong.incrementAndGet();
    }
}
