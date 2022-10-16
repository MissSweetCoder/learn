package com.ziroom.算法;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年03月04日 16:53:00
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] collect = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        int length = collect.length;

        for (int i = 0 ; i < length ; i++){
            boolean flag = false;
            for (int j = 0 ; j < length - i - 1 ; j++){
                if (collect[j] > collect[j+1]){
                    int temp = collect[j+1];
                    collect[j+1] = collect[j];
                    collect[j] = temp;
                    flag = true;
                }
            }
            if (!flag)break;
        }

        for (int i = 0 ; i < collect.length ; i++){
            System.out.println(collect[i] + ",");
        }
    }
}
