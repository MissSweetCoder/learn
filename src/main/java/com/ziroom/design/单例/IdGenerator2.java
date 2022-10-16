package com.ziroom.design.单例;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 17:49:00
 */
public class IdGenerator2 {
    private AtomicLong id = new AtomicLong();
    private static IdGenerator2 instance;
    private IdGenerator2(){
        System.out.println("------init-------");
    };
    public static IdGenerator2 getInstance(){
        if (instance == null){
            synchronized (IdGenerator2.class){
                if (instance == null){
                    instance = new IdGenerator2();
                }
            }
        }
        return instance;
    }

    public Long getId(){
        return id.getAndIncrement();
    }
}
