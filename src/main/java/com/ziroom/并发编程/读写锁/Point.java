package com.ziroom.并发编程.读写锁;

import java.util.concurrent.locks.StampedLock;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月17日 14:49:00
 */
public class Point {
    private int x = 100 , y = 100;
    final StampedLock stampedLock = new StampedLock();

    public int distance(){
        //乐观读锁
        long optimisticReadLock = stampedLock.tryOptimisticRead();//version 1
        int currX = x , currY = y; //other thread -> version1 to version2
        if (!stampedLock.validate(optimisticReadLock)){

            //升级为读锁
            long readLock = stampedLock.readLock();
            try {
                currX = x;
                currY = y;
            }finally {
                stampedLock.unlockRead(readLock);
            }
        }
        return currX * currY;
    }

}
