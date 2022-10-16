package com.ziroom.design.模板;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月13日 14:43:00
 */
public class AClass {
    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(new ICallback() {
            @Override
            public void methodCallback() {
                System.out.println("AClass");
            }
        });
    }
}
