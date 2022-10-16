package com.ziroom.proxy.cglib动态代理;

import com.ziroom.proxy.静态代理.Subject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年04月22日 10:02:00
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("real subject");
        Map<Character,Character> map = new HashMap<Character,Character>(4){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        String s = "1111";
    }
}
