package com.ziroom.算法.排序.比较类排序.交换排序;

/**
 * @author kairanzhang
 * @Description 快速排序
 * @createTime 2022年11月08日 11:35:00
 */
public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums , 0 , nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums , int l , int r){
        if(l >= r) return;
        int pivot = partition(nums , l , r);
        quickSort(nums , l , pivot);
        quickSort(nums , pivot + 1 , r);
    }

    public int partition(int[] nums , int l , int r){
        int pivot = l + (int)(Math.random() * (r - l + 1));
        int pivotVal = nums[pivot];
        while(l <= r){
            while(pivotVal > nums[l]) l++;
            while (pivotVal < nums[r]) r--;
            if(l == r)break;
            if(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;r--;
            }
        }
        return r;
    }

}
