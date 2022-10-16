package com.ziroom.算法;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年03月05日 11:51:00
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] collect = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        mergeSort(collect,collect.length-1,0);

        for (int i = 0 ; i < collect.length ; i++){
            System.out.println(collect[i] + ",");
        }
    }

    private static void mergeSort(int[] collect, int high, int low) {
        int mid = (high+low)/2;
        if (low < high){
            //右边
            mergeSort(collect,high,mid+1);
            //左边
            mergeSort(collect,mid,low);
            merge(collect,high,mid,low);
        }
    }

    private static void merge(int[] collect, int high, int mid, int low) {
        int[] newCollect = new int[high-low+1];

        int i = low;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= high){
            if (collect[i] < collect[j]){
                newCollect[k++] = collect[i++];
            }else {
                newCollect[k++] = collect[j++];
            }
        }

        while (i <= mid){
            newCollect[k++] = collect[i++];
        }

        while (j <= high){
            newCollect[k++] = collect[j++];
        }

        for (int index = 0 ; index < newCollect.length ; index++){
            collect[low+index] = newCollect[index];
        }
    }
}
