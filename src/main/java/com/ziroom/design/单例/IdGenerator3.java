package com.ziroom.design.单例;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 17:59:00
 */
public class IdGenerator3 {
    private AtomicLong id = new AtomicLong();
    private IdGenerator3(){
        System.out.println("---------init--------");
    };
    private static class Holder{
        private static final IdGenerator3 id = new IdGenerator3();
    }
    public static IdGenerator3 getInstance(){
        return Holder.id;
    }
    public Long getId(){
        return id.incrementAndGet();
    }

}
