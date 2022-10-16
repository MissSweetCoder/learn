package com.ziroom.design.职责链.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 10:24:00
 */
public class Application {
    public static void main(String[] args) {
        LinkedListHandlerChain handlerChain = new LinkedListHandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.handle();
    }
}
