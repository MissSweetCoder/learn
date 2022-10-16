package com.ziroom.design.观察者.two;

import java.util.concurrent.Executor;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 17:38:00
 */
public class AsyncEventBus extends EventBus{
    public AsyncEventBus(Executor executor){
        super(executor);
    }
}
