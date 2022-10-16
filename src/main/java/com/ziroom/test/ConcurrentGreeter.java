package com.ziroom.test;

import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月02日 19:25:00
 */
public class ConcurrentGreeter extends Greeter{
    @Override
    public void greet(){
        Thread t = new Thread(() -> super.greet());
//        Thread t = new Thread(super::greet);
        t.start();
    }

    public static void repeatMessage(String text , int count, List<Integer> countList){
        int[] counter = new int[1];
        Runnable r = () -> {
            counter[0]++;
            countList.add(1);
            while (count > 0){

            }
        };
        new Thread(r).start();
    }
}
