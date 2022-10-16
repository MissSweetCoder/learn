package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description 查找第一个大于等于给定值的元素
 * @createTime 2021年05月05日 18:54:00
 */
public class 二分查找_练习3 {
    public static void main(String[] args) {
        int[] collect = {3,4,6,7,10};
        int index = bSearch(collect,5);
        System.out.println(index);
    }

    private static int bSearch(int[] collect, int value) {
        int low = 0;
        int high = collect.length - 1;

        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (collect[mid] >= value){
                if (mid == 0 || collect[mid - 1] < value)return mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
