package com.ziroom.design.观察者.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 10:19:00
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo update");
    }
}
