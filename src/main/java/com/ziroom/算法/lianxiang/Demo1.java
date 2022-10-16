package com.ziroom.算法.lianxiang;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年04月04日 19:14:00
 */
public class Demo1 {
    public static void main(String[] args) {
        Other other = new Other();
        new Demo1().addOne(other);
        System.out.println(other.i);
    }

    public void addOne(final Other o){
        o.i++;
    }
}
