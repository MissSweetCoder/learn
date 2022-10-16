package com.ziroom.design.职责链.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 10:07:00
 */
public class HandlerB extends Handler{
    @Override
    protected Boolean doHandle() {
        System.out.println("HandlerB");
        return false;
    }
}
