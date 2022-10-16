package com.ziroom.design.单例;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 17:27:00
 */
public class IdGenerator1 {
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator1 instance = new IdGenerator1();
    private IdGenerator1(){
        System.out.println("---------init--------");
    };
    public static IdGenerator1 getInstance(){
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}
