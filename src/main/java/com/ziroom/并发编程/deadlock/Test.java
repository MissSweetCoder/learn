package com.ziroom.并发编程.deadlock;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月23日 09:52:00
 */
public class Test {
    public static void main(String[] args) {
        Account account1 = new Account(100);
        Account account2 = new Account(200);

        new Thread(() -> {
            account1.transfer(account2,10);
        }).start();

        new Thread(() -> {
            account2.transfer(account1,10);
        }).start();
    }
}
