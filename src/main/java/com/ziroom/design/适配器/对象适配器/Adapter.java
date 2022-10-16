package com.ziroom.design.适配器.对象适配器;

import com.ziroom.design.适配器.类适配器.ITarget;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月08日 09:54:00
 */
public class Adapter implements ITarget {
    private Adaptee adaptee;

    public void setAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
