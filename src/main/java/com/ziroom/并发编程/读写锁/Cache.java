package com.ziroom.并发编程.读写锁;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月09日 16:49:00
 */
public class Cache<K,V> {

    private final Map<K,V> cacheMap = Maps.newHashMap();

    private final ReadWriteLock rtl = new ReentrantReadWriteLock();

    private final Lock r = rtl.readLock();

    private final Lock w = rtl.writeLock();

    V get(K k){
        V v = null;
        r.lock();
        try {
            v = cacheMap.get(k);
        }finally {
            r.unlock();
        }

        if (v != null){
            return v;
        }

        w.lock();
        try {
            v = cacheMap.get(k);
            if (v == null){
                //put操作 省略
                v = cacheMap.get(k);
            }
        }finally {
            w.unlock();
        }

        return v;
    }


}
