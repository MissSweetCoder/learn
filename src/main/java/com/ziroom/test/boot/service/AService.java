package com.ziroom.test.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2023年02月24日 09:47:00
 */
@Component
public class AService {

    @Autowired
    @Lazy
    BService bService;

    @Async
    public void async() {

    }
}
