package com.ziroom.spi.javaspi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年03月06日 15:44:00
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = load.iterator();
        while (iterator.hasNext()){
            Search next = iterator.next();
            next.search("hello world");
        }
    }
}
