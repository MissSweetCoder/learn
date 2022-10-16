package com.ziroom.proxy.jdk动态代理;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月22日 10:32:00
 */
public class Test {
    public static void main(String[] args) {
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(new RealSubject());
        Subject subject = (Subject) jdkProxyFactory.getJdkProxy();
        System.out.println(subject.getClass());
        subject.request();
    }
}
