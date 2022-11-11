package leetcode.editor.cn;

//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
// 你需要返回给定数组中的重要翻转对的数量。
//
// 示例 1:
//
//
//输入: [1,3,2,3,1]
//输出: 2
//
//
// 示例 2:
//
//
//输入: [2,4,3,5,1]
//输出: 3
//
//
// 注意:
//
//
// 给定数组的长度不会超过50000。
// 输入数组中的所有数字都在32位整数的表示范围内。
//
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 383 👎 0

public class ReversePairs{
    public static void main(String[] args) {
        Solution solution = new ReversePairs().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int ans = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums , 0 , nums.length - 1);
        return ans;
    }

    public void mergeSort(int[] nums , int l , int r){
        if(l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums , l , mid);
        mergeSort(nums , mid + 1 , r);
        cal(nums , l , mid , r);

        merge(nums , l , mid , r);
    }

    public void cal(int[] nums , int left , int mid , int right){
        int j = mid;
        for(int i = left ; i <= mid ; i++){
            while (j < right && nums[i] > 2l * nums[j + 1]) j++;
            ans += j - mid;
        }
    }

    public void merge(int[] nums , int left , int mid , int right){
        int[] temp = new int[right - left + 1];
        int i = left , j = mid + 1 , k = 0;

        while(i <= mid && j <= right){
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

//        for (int k = 0 ; k < temp.length ; k++){
//            if(j > right || (i <= mid && nums[i] <= nums[j])) temp[k] = nums[i++];
//            else temp[k] = nums[j++];
//        }

        for(int index = 0 ; index < temp.length ; index++){
            nums[left + index] = temp[index];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
