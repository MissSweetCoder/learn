package com.ziroom.spi.javaspi;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年03月06日 15:41:00
 */
public class DBSearch implements Search{
    @Override
    public void search(String word) {
        System.out.println("DBSearch"+word);
    }
}
