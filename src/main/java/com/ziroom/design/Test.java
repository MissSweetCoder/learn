package com.ziroom.design;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ziroom.design.单例.IdGenerator1;
import com.ziroom.design.单例.IdGenerator2;
import com.ziroom.design.单例.IdGenerator4;
import com.ziroom.design.建造者.ResourcePoolConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年09月02日 17:32:00
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }

    public static void printTimeStamp(String s) {
        System.out.println(s);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, dateTimeFormatter);
        System.out.println(LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

    }

    public static void test(Integer... ids){

    }

    public static BiConsumer<IdGenerator1, IdGenerator2> generate(){
        return (T,U)->{
            T.getId();
            U.getId();
        };
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class User {
        private String id;
    }
}
