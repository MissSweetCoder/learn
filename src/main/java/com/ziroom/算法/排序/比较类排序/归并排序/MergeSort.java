package com.ziroom.算法.排序.比较类排序.归并排序;

/**
 * @author kairanzhang
 * @Description 归并排序
 * @createTime 2022年11月08日 16:49:00
 */
class MergeSort {
    public int[] sortArray(int[] nums) {
        int left = 0 , right = nums.length - 1;
        mergeSort(nums , left , right);
        return nums;
    }

    public void mergeSort(int[] nums , int left , int right){
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums , left , mid);
        mergeSort(nums , mid + 1 ,right);
        merge(nums , left , mid , right);
    }

    public void merge(int[] nums , int left , int mid , int right){
        int[] temp = new int[right - left + 1];
        int i = left , j = mid + 1 , k = 0;

        while (i <= mid && j <= right){
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for(int p = 0 ; p < temp.length ; p++){
            nums[left + p] = temp[p];
        }
    }
}
