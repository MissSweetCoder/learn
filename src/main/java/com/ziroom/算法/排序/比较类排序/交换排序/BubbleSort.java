package com.ziroom.算法.排序.比较类排序.交换排序;

/**
 * @author kairanzhang
 * @Description 冒泡排序
 * @createTime 2022年11月08日 11:38:00
 */
public class BubbleSort {
    public int[] sortArray(int[] nums) {
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            boolean sort = true;
            for(int j = 0 ; j < i ; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    sort = false;
                }
            }
            if(sort) break;;
        }
        return nums;
    }
}
