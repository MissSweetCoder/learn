package com.ziroom.并发编程.信号量;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月09日 11:26:00
 */
public class Test {
    public static void main(String[] args) {
        String[] message = new String[10];
        for (int i = 0 ; i < 10 ; i++){
            message[i] = "obj_"+i;
        }
        ObjPool<String, String> objPool = new ObjPool<>(message);

        for (int i = 0 ; i < 100 ; i++){
            Thread thread = new Thread(() -> {
                try {
                    objPool.exec(t -> {
                        System.out.println("线程id：" + Thread.currentThread().getId() + "获取到的对象：" + t);
                        return t;
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
