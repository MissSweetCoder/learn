package com.ziroom.design.职责链.two;


/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 10:50:00
 */
public class HandlerB implements IHandler {
    @Override
    public boolean handle() {
        System.out.println("HandlerB");
        return false;
    }
}
