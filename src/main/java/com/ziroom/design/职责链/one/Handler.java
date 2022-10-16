package com.ziroom.design.职责链.one;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 09:59:00
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle(){
        Boolean handled = doHandle();
        if (successor != null && !handled){
            successor.handle();
        }
    }

    protected abstract Boolean doHandle();
}
