package com.ziroom.design.观察者.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 10:19:00
 */
public class Test {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserverOne());
        concreteSubject.registerObserver(new ConcreteObserverTwo());
        concreteSubject.notifyObserver(new Message("message"));
    }
}
