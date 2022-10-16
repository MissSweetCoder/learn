package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description 查找最后一个值等于给定值的元素
 * @createTime 2021年05月05日 18:37:00
 */
public class 二分查找_练习2 {
    public static void main(String[] args) {
        //数组有序但是有重复数据
        int[] collect = {1,3,4,5,6,8,8,8,11,18};
        int index = bSearch(collect,8);
        System.out.println(index);
    }

    private static int bSearch(int[] collect, int value) {
        int low = 0;
        int high = collect.length - 1;
        while (low <= high){
            int mid = low + ((high - low)>>1);
            if (collect[mid] < value){
                low = mid + 1;
            }else if (collect[mid] > value){
                high = mid - 1;
            }else {
                if (mid == collect.length || collect[mid + 1] != value)return mid;
                low = mid + 1;
            }
        }
        return -1;
    }
}
