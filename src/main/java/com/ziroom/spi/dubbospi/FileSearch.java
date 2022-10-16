package com.ziroom.spi.dubbospi;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年03月06日 16:35:00
 */
public class FileSearch implements Search{
    @Override
    public void search(String word) {
        System.out.println("FileSearch"+word);
    }
}
