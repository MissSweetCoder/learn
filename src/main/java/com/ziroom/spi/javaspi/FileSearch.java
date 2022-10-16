package com.ziroom.spi.javaspi;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年03月06日 15:40:00
 */
public class FileSearch implements Search{
    @Override
    public void search(String word) {
        System.out.println("FileSearch"+word);
    }
}
