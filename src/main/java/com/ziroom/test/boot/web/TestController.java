package com.ziroom.test.boot.web;

import com.ziroom.test.boot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2023年02月23日 18:20:00
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/async")
    public String testMyAsyncConfigurer() {
        Future<String> stringFuture = testService.testMyAsyncWithReturn();
        try {
            System.out.println(stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
