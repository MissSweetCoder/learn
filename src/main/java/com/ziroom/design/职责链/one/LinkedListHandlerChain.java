package com.ziroom.design.职责链.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 10:08:00
 */
public class LinkedListHandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler){
        handler.setSuccessor(null);

        if (head == null && tail == null){
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(){
        if (head != null){
            head.handle();
        }
    }
}
