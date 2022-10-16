package com.ziroom.proxy.静态代理;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月22日 10:10:00
 */
public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject subject = new ProxySubject(realSubject);
        subject.request();
    }
}
