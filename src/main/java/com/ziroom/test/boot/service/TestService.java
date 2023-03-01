package com.ziroom.test.boot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2023年02月23日 18:21:00
 */
@Service
public class TestService {

    @Async
    public void testMyAsync() {
        try {
            Thread.sleep(2000);
            System.out.println("testMyAsync 当前线程-----" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public Future<String> testMyAsyncWithReturn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AsyncResult<String>("testMyAsyncWithReturn 当前线程-----" + Thread.currentThread().getName());
    }
}
