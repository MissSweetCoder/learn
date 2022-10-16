package com.ziroom.design.适配器.类适配器;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月08日 09:51:00
 */
public class Adapter extends Adaptee implements ITarget{

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }
}
