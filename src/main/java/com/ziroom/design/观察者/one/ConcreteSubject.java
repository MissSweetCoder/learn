package com.ziroom.design.观察者.one;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 10:10:00
 */
public class ConcreteSubject implements Subject{
    List<Observer> observers = Lists.newArrayList();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        observers.stream().forEach(o -> {
            o.update(message);
        });
    }
}
