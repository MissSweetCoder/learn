package leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//
//
//
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
//
//
//
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
//
// Related Topics 栈 数组 单调栈 👍 2311 👎 0

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private class Rect {
        public int height;
        public int width;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] heightWithZero = Arrays.copyOf(heights, n + 1);
        heightWithZero[n] = 0;

        Stack<Rect> s = new Stack<>();
        int ans = 0;
        for (int h : heightWithZero) {
            int accumulatedWidth = 0;
            while (!s.isEmpty() && s.peek().height >= h) {
                accumulatedWidth += s.peek().width;
                ans = Math.max(ans, accumulatedWidth * s.peek().height);
                s.pop();
            }
            Rect rect = new Rect();
            rect.height = h;
            rect.width = accumulatedWidth + 1;
            s.push(rect);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
