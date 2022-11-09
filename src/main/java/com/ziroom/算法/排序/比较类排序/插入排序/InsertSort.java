package com.ziroom.算法.排序.比较类排序.插入排序;

/**
 * @author kairanzhang
 * @Description 插入排序
 * @createTime 2022年11月08日 15:06:00
 */
public class InsertSort {
    public int[] sortArray(int[] nums) {
        for(int i = 1 ; i < nums.length ; i++){
            int temp = nums[i];
            int j = i;
            while(j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
