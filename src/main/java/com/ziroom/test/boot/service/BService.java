package com.ziroom.test.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2023年02月24日 09:49:00
 */
@Component
public class BService {

    @Autowired
    @Lazy
    AService aService;

//    @Async
    public void async() {

    }
}
