package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
//
// Related Topics 回溯 👍 1281 👎 0

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int n, k;
    List<Integer> chosen = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1);
        return ans;
    }

    public void recur(int i) {
        if (chosen.size() > k || chosen.size() + (n - i + 1) < k) return;
        if (i == n + 1) {
            ans.add(new ArrayList<>(chosen));
            return;
        }

        recur(i + 1);
        chosen.add(i);
        recur(i + 1);
        chosen.remove(chosen.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
