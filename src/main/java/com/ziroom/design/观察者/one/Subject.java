package com.ziroom.design.观察者.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月09日 10:04:00
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);
}
