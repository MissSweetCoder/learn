package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//
// Related Topics 数组 动态规划 👍 1568 👎 0

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;

        boolean f[] = new boolean[sum+1];
        f[0] = true;

        for (int i = 0 ; i < n ; i++){
            for (int j = sum/2 ; j >= nums[i] ; j--){
                f[j] = f[j] || f[j - nums[i]];
            }
        }

        return f[sum / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
