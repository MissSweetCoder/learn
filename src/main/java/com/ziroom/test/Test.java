package com.ziroom.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年08月03日 11:27:00
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
//        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
//        BigInteger[] bigIntegers = iterate.toArray(BigInteger[]::new);
//        System.out.println(Arrays.toString(bigIntegers));
//
//        Random random = new Random();
//        Stream<Integer> generate = Stream.generate(random::nextInt).limit(10);
//        Integer[] integers = generate.toArray(Integer[]::new);
//        System.out.println(Arrays.toString(integers));
//
//        Object[] objects = Stream.iterate(1, p -> p * 2).peek(e -> System.out.println(e + " ")).limit(20).toArray();
//        List<String> collect = Arrays.asList("1", "2").stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());

//        List<String> list = Lists.newArrayList();
//        Optional<String> s = Optional.ofNullable("1234");
//        s.ifPresent(list::add);
//        s.map(list::add);
//        System.out.println(JSON.toJSONString(list));

//        Optional<Double> aDouble = Optional.of(1234d).flatMap(Test::inverse).flatMap(Test::squareRoot);
//        System.out.println(aDouble.orElseThrow(() -> new RuntimeException()));

//        List<Integer> list = Lists.newArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        Integer integer = list.stream().reduce(Integer::sum).orElseThrow(() -> new RuntimeException());
//        System.out.println(integer);

//        Student student1 = Student.builder().name("name1").age("age1").build();
//        Student student2 = Student.builder().name("name2").age("age2").build();
//        List<Student> students = Lists.newArrayList(student1,student2);
//        Map<String, Set<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.toSet()));
//        Map<String, Long> collect1 = students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));

//        Map<String,LongAdder> map = new HashMap<>();
//        map.putIfAbsent("key", new LongAdder());
//        map.get("key").increment();
//        System.out.println(JSON.toJSONString(map));

//        Map<String,Integer> map = new HashMap<>();
//        map.compute("key",(k,v)->v == null ? 1 : v + 1);
//        System.out.println(JSON.toJSONString(map));

//        Map<String,LongAdder> map = new HashMap<>();
//        map.computeIfAbsent("key",key -> new LongAdder());
//        System.out.println(JSON.toJSONString(map));

//        Map<String,Integer> map = new HashMap<>();
//        map.put("key",1);
//        map.merge("key",1,(oldValue,newValue)->oldValue + newValue);
//        map.merge("key",1,Integer::sum);
//        System.out.println(JSON.toJSONString(map));

//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            return null;
//        });
//        completableFuture.thenApply(result -> {
//            int i = result;
//            return i;
//        }).thenApply(result -> {
//            System.out.println("middle method");
//            return "middle method";
//        }).exceptionally(e -> {
//            e.printStackTrace();
//            return "error";
//        }).thenAccept(System.out::println);
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//            return 1;
//        });
//        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
//            return 2;
//        });
//        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future1, future2);
//        System.out.println(future1.join() + future2.join());

//        CompletableFuture.supplyAsync(() -> 1).whenComplete((result,error) -> {
//            System.out.println(result);
//            error.printStackTrace();
//        }).handle((result,error) -> {
//            return 2;
//        }).thenApply(Objects::toString).thenAccept(System.out::println);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<CompletableFuture<Integer>> collect = IntStream.range(1, 10).mapToObj(i -> {
//            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//                if (i == 5) {
//                    throw new RuntimeException("test");
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(i);
//                return i;
//            }, executorService)
//                    .exceptionally((error) -> {
//                        error.printStackTrace();
//                        return 100;
//                    });
//            return future;
//        }).collect(Collectors.toList());
//        CompletableFuture.allOf(collect.toArray(new CompletableFuture[]{})).join();
        StringBuilder sb = new StringBuilder();
        sb.append("{" +
                "\"query\": {" +
                "\"bool\": {" +
                "\"must\": [");
        String timeJosn = "{" +
                "\"range\": {" +
                "\"crtTime\": {" +
                "\"gte\": \"" + "2023-03-06 12:02:00" + "\"," +
                "\"lt\": \"" + "2023-03-06 12:03:00" + "\"" +
                "}" +
                "}" +
                "}";
        sb.append(timeJosn);
        String reqJson = ",{\n" +
                    "        \"match\": {\n" +
                    "\"requestUri.keyword\": \"" + "requestUrl" + "\"" +
                    "        }\n" +
                    "      }";

        sb.append(reqJson);
        sb.append("]");
        sb.append("}");
        sb.append("},");
        sb.append("\"size\": 0,");
        sb.append("\"aggs\":{");
        sb.append("\"all_tags\":{");
        sb.append("\"terms\":{");
        sb.append("\"field\":\"requestUri.keyword\",");
        sb.append("\"size\": 99999999");
        sb.append("},");
        sb.append("\"aggs\": {");
        sb.append("\"serCode\": {");
        sb.append("\"terms\": {");
        sb.append("\"field\": \"serviceId.keyword\"");
        sb.append("},");
        sb.append("\"aggs\": {");
        sb.append("\"avg_delay\": {");
        sb.append("\"avg\": {");
        sb.append("\"field\": \"costTimes\"");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        sb.append("}");
        System.out.println(sb.toString());
    }

    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x){
        return  x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

//    @Data
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public class Student{
//        private String name;
//        private String age;
//    }
}
