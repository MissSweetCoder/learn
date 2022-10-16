package com.ziroom.design.职责链.two;


/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 10:24:00
 */
public class Application {
    public static void main(String[] args) {
        ArrayHandlerChain arrayHandlerChain = new ArrayHandlerChain();
        arrayHandlerChain.addHandler(new HandlerA());
        arrayHandlerChain.addHandler(new HandlerB());
        arrayHandlerChain.handle();
    }
}
