package com.ziroom.算法.排序.比较类排序.选择排序;

/**
 * @author kairanzhang
 * @Description 选择排序
 * @createTime 2022年11月08日 15:55:00
 */
public class ChooseSort {
    public int[] sortArray(int[] nums) {
        for(int i = 0 ; i < nums.length - 1 ; i++){
            int minIndex = i;
            for (int j = i + 1 ; j < nums.length ; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}
