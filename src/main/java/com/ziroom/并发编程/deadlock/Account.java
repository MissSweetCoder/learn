package com.ziroom.并发编程.deadlock;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月23日 09:47:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer balance;

    public void transfer(Account target,int amt){
        synchronized (target){
            System.out.println("获得锁"+ JSON.toJSONString(target));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this){
                if (this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
