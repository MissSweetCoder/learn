package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年03月11日 16:29:00
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] collect = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        quickSort(collect,0,collect.length - 1);
        for (int i = 0 ; i < collect.length ; i++){
            System.out.println(collect[i] + ",");
        }
    }

    private static void quickSort(int[] collect, int low, int high) {
        if (low >= high){
            return;
        }

        int p = collect[low];
        int tmp;
        int i = low;
        int j = high;
        while (i < j){
            while (collect[j] >= p && i < j){
                j--;
            }
            while(collect[i] <= p && i < j){
                i++;
            }

            tmp = collect[i];
            collect[i] = collect[j];
            collect[j] = tmp;
        }
        collect[low] = collect[i];
        collect[i]  = p;
        quickSort(collect,low,i-1);
        quickSort(collect,i+1,high);
    }
}
