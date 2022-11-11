package leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1951 👎 0

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums , 0 , nums.length - 1 , nums.length - k);
    }

    public int quickSort(int[] nums , int l , int r , int index){
        if(l == r) return nums[l];
        int pivot = partition(nums , l , r);
        if(index <= pivot) return quickSort(nums , l , pivot , index);
        else return quickSort(nums , pivot + 1 , r , index);
    }

    public int partition(int[] nums , int l , int r){
        int pivot = l + (int)(Math.random() * (r - l + 1));
        int pivotVal = nums[pivot];
        while (l <= r){
            while (nums[l] < pivotVal) l++;
            while (nums[r] > pivotVal) r--;
            if(l == r) break;
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
//leetcode submit region end(Prohibit modification and deletion)

}
