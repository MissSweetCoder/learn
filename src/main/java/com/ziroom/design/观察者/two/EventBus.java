package com.ziroom.design.观察者.two;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 17:26:00
 */
public class EventBus {
    private Executor executor;
    private ObserverRegister register = new ObserverRegister();

    public EventBus() {
        this(Executors.newSingleThreadExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object observer){
        register.register(observer);
    }

    public void post(Object event){
        List<ObserverAction> observerActions = register.match(event);
        observerActions.stream().forEach(observerAction -> {
            executor.execute(() -> observerAction.execute(event));
        });
    }
}
