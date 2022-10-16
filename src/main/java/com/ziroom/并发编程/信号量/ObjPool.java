package com.ziroom.并发编程.信号量;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月09日 10:59:00
 */
public class ObjPool<T,R> {

    private  List<T> pool;

    private Semaphore semaphore;

    ObjPool(T[] array){
        pool = new Vector<T>();
        int size = array.length;
        for (int i = 0 ; i < size ; i++){
            pool.add(array[i]);
        }
        semaphore = new Semaphore(size);
    }

    R exec(Function<T,R> function) throws InterruptedException {
        T t = null;
        try {
            semaphore.acquire();
            t = pool.remove(0);
            return function.apply(t);
        }finally {
            pool.add(t);
            semaphore.release();
        }
    }

}
