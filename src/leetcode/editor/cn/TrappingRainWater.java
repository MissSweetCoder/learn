package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4080 👎 0

public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        preMax[0] = heights[0];
        for (int i = 1 ; i < n ; i++) preMax[i] = Math.max(preMax[i - 1], heights[i]);
        sufMax[n - 1] = heights[n - 1];
        for (int i = n - 2 ; i >= 0 ; i--) sufMax[i] = Math.max(sufMax[i + 1], heights[i]);
        for (int i = 1 ; i < n - 1 ; i++) {
            int up = Math.min(preMax[i - 1], sufMax[i + 1]);
            int bottom = heights[i];
            if (up > bottom) ans += up - bottom;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
