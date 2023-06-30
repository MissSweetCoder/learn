package com.ziroom.并发编程.lesson1;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2023年06月05日 17:47:00
 */
public class Test {

    private long count = 0;

    public void  add() {
        int idx = 0;
        while (idx++ < 100000) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();

        Thread t1 = new Thread(() -> {
            test.add();
        });

        Thread t2 = new Thread(() -> {
            test.add();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(test.count);
    }
}
