package com.ziroom.proxy.jdk动态代理;

public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("real subject");
    }
}