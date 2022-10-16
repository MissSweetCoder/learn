package com.ziroom.design.职责链.two;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月26日 10:43:00
 */
public class ArrayHandlerChain {
    private List<IHandler> handlers = Lists.newArrayList();

    public void addHandler(IHandler handler){
        handlers.add(handler);
    }

    public void handle(){
        for (IHandler handler : handlers){
            boolean handled = handler.handle();
            if (handled){
                break;
            }
        }
    }
}
