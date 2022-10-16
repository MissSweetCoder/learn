package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description 查找最后一个小于等于给定值的元素
 * @createTime 2021年05月05日 19:04:00
 */
public class 二分查找_练习4 {
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
            if (collect[mid] <= value){
                if(mid == collect.length - 1 || collect[mid + 1] > value)return mid;
                low = mid + 1;

            }else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
