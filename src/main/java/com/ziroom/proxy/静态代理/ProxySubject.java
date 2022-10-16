package com.ziroom.proxy.静态代理;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月22日 10:06:00
 */
public class ProxySubject implements Subject{

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("proxy request start");
        realSubject.request();
        System.out.println("proxy request end");
    }
}
