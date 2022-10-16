package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年03月04日 18:00:00
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] collect = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        int minIndex;
        for (int i = 0 ; i < collect.length ; i++){
            minIndex = i;
            for (int j = i+1 ; j < collect.length ; j++){
                if (collect[j] < collect[minIndex]){
                    minIndex = j;
                }
            }
            int temp = collect[i];
            collect[i] = collect[minIndex];
            collect[minIndex] = temp;
        }
        for (int i = 0 ; i < collect.length ; i++){
            System.out.println(collect[i] + ",");
        }
    }
}
