package com.ziroom.design;

import com.alibaba.fastjson.JSON;
import com.ziroom.design.单例.IdGenerator1;
import com.ziroom.design.单例.IdGenerator2;
import com.ziroom.design.单例.IdGenerator4;
import com.ziroom.design.建造者.ResourcePoolConfig;

import java.util.function.BiConsumer;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 17:32:00
 */
public class Test {
    public static void main(String[] args) {
//        Runnable runnable = () -> {
//            long id = IdGenerator4.INSTANCE.getId();
//            System.out.println(id);
//        };
//        Thread thread1 = new Thread(runnable);
//        Thread thread2 = new Thread(runnable);
//        thread1.start();
//        thread2.start();

        ResourcePoolConfig resourcePoolConfig = new ResourcePoolConfig.Builder().setName("1234").setMaxTotal(10).setMaxIdle(9).setMinIdle(8).builder();
        System.out.println(JSON.toJSONString(resourcePoolConfig));
    }
    public static BiConsumer<IdGenerator1, IdGenerator2> generate(){
        return (T,U)->{
            T.getId();
            U.getId();
        };
    }
}
