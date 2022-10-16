package com.ziroom.design.模板;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月13日 14:42:00
 */
public class BClass {
    public void process(ICallback callback){
        callback.methodCallback();
        System.out.println("BClass");
    }
}
