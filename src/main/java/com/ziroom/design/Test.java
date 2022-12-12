package com.ziroom.design;

import com.alibaba.fastjson.JSON;
import com.ziroom.design.单例.IdGenerator1;
import com.ziroom.design.单例.IdGenerator2;
import com.ziroom.design.单例.IdGenerator4;
import com.ziroom.design.建造者.ResourcePoolConfig;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.BiConsumer;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 17:32:00
 */
public class Test {
    public static void main(String[] args) {
//        printTimeStamp("2022-09-01 00:00:00");
//        printTimeStamp("2022-09-30 23:59:59");
//        printTimeStamp("2022-10-01 00:00:00");
//        printTimeStamp("2022-10-31 23:59:59");
//        printTimeStamp("2022-11-01 00:00:00");
//        printTimeStamp("2022-11-30 23:59:59");
//        SimpleDateFormat sdfutc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        System.out.println(sdfutc.format(new Date(1669197372755L)));
        System.out.println(-1 % 3);
        System.out.println(-2 % 3);
        System.out.println(-4 % 3);
    }

    private static void printTimeStamp(String s) {
        System.out.println(s);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter);
        System.out.println(LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

    }

    public static BiConsumer<IdGenerator1, IdGenerator2> generate(){
        return (T,U)->{
            T.getId();
            U.getId();
        };
    }
}
