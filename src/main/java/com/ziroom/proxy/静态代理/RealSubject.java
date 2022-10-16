package com.ziroom.proxy.静态代理;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月22日 10:02:00
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("real subject");
    }
}
