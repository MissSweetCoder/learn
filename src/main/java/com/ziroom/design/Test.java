package com.ziroom.design;

import com.alibaba.fastjson.JSON;
import com.ziroom.design.单例.IdGenerator1;
import com.ziroom.design.单例.IdGenerator2;
import com.ziroom.design.单例.IdGenerator4;
import com.ziroom.design.建造者.ResourcePoolConfig;

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
//        printTimeStamp("2022-06-01 00:00:00");
//        printTimeStamp("2022-06-30 23:59:59");
//        printTimeStamp("2022-07-01 00:00:00");
//        printTimeStamp("2022-07-31 23:59:59");
//        printTimeStamp("2022-08-01 00:00:00");
//        printTimeStamp("2022-08-31 23:59:59");
//        printTimeStamp("2022-09-01 00:00:00");
//        printTimeStamp("2022-09-30 23:59:59");
//        printTimeStamp("2022-10-01 00:00:00");
//        printTimeStamp("2022-10-31 23:59:59");
//        printTimeStamp("2022-11-01 00:00:00");
//        printTimeStamp("2022-11-30 23:59:59");
//        printTimeStamp("2022-12-01 00:00:00");
//        printTimeStamp("2022-12-31 23:59:59");

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        String[] array = new String[2];
//        list.toArray(array);
//        for (int i = 0 ; i < array.length ; i++){
//            System.out.println(array[i]);
//        }

//        String[] array = new String[]{"a" , "b"};
//        List<String> list = Arrays.asList(array);
//        array[0] = "1";
//        list.stream().forEach(System.out::println);

//        List<String> a = new ArrayList<String>();
//        a.add("1");
//        a.add("2");
//        for (String temp : a) {
//            if ("2".equals(temp)) {
//                a.remove(temp);
//            }
//        }
//        a.stream().forEach(System.out::println);

//        List<String> a = new ArrayList<String>();
//        a.add("1");
//        a.add("2");
//        Iterator<String> iterator = a.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//            iterator.remove();
//        }

        Map<String , String> map = new HashMap<>();
        map.put("key"  , "value");
        Set<String> keySet = map.keySet();
        Collection<String> values = map.values();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        map.forEach((k , v) -> {
            System.out.println(k + " " + v);
        });

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        List<String> list = a.subList(0, 1);
        list.add(0,"1");

//        SimpleDateFormat sdfutc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        System.out.println(sdfutc.format(new Date(1669197372755L)));

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
}
