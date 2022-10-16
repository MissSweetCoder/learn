package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年05月04日 19:44:00
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] collect = {1,3,5,6};
//        int index = bSearch(collect,5);
//        int index = bSearchWithDG(collect,3,0,collect.length - 1);
        int index = searchInsert(collect,5);
        System.out.println(index);
        Thread thread = new Thread(() -> {

        });
        thread.interrupt();
        thread.isInterrupted();
        Thread.interrupted();
    }

    private static int searchInsert(int[] nums,int target){
        int len = nums.length;
        int right = len - 1,left = 0,ans = len;
        while(left <= right){
            int mid = ((right - left) >> 1) + left ;
            if(target <= nums[mid]){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int bSearchWithDG(int[] collect, int value, int low, int high) {
        int mid = low + ((high - low)>>1);
        if (collect[mid] == value){
            return mid;
        }else if (collect[mid] < value){
            return bSearchWithDG(collect,value,mid + 1,high);
        }else {
            return bSearchWithDG(collect,value,low,mid - 1);
        }
    }


    private static int bSearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 在 nums[left..right] 里查找 target
        while (left < right) {
            // 为了防止 left + right 整形溢出，写成这样
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索区间：[mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间：[left..mid]
                right = mid;
            }
        }

        if (nums[left] == target){
            return left;
        }
        return -1;

    }

    private static int bSearch1(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = ((right - left) >> 1) + left;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;

    }
}
