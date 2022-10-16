package com.ziroom.design.观察者.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 10:17:00
 */
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne update");
    }
}
