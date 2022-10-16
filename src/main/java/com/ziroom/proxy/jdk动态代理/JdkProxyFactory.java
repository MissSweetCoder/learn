package com.ziroom.proxy.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月22日 10:27:00
 */
public class JdkProxyFactory {

    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    public Object getJdkProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy subject start");
                method.invoke(target,args);
                System.out.println("proxy subject end");
                return null;
            }
        });
    }
}
