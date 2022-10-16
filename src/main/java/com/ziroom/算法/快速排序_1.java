package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月03日 23:40:00
 */
public class 快速排序_1 {
    public static void main(String[] args) {
        int[] collect = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        quickSort(collect,0,collect.length - 1);
        for (int i = 0 ; i < collect.length ; i++){
            System.out.println(collect[i] + ",");
        }
    }

    private static void quickSort(int[] collect, int low, int high) {
        if (low >= high)return;

        //分区点
        int p = collect[high];
        int i = low;
        for (int j = low; j <= high-1 ; j++){
            if (collect[j] < p){
                int temp = collect[i];
                collect[i] = collect[j];
                collect[j] = temp;
                i++;
            }
        }
        collect[high] = collect[i];
        collect[i] = p;

        quickSort(collect,low,i-1);
        quickSort(collect,i+1,high);
    }
}
