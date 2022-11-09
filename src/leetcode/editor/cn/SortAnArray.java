package leetcode.editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 10⁴
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴
//
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 720 👎 0

public class SortAnArray{
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}
