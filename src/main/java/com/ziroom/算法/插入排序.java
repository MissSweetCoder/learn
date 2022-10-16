package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年03月05日 10:30:00
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] collect = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        for (int i = 1 ; i < collect.length ; i++){
            int value = collect[i];
            int j = i - 1;
            for (; j >= 0 ; j--){
                if (collect[j] > value){
                    collect[j + 1] = collect[j];
                }else {
                    break;
                }
            }
            collect[j + 1] = value;
        }

        for (int i = 0 ; i < collect.length ; i++){
            System.out.println(collect[i] + ",");
        }
    }
}
