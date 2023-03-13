package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics 字符串 动态规划 回溯 👍 3108 👎 0

public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Integer, List<String>> store = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return Arrays.asList("");
        if (store.containsKey(n)) return store.get(n);
        List<String> ans = new ArrayList<>();
        for (int k = 1 ; k <= n ; k++) {
            List<String> A = generateParenthesis(k - 1);
            List<String> B = generateParenthesis(n - k);
            for (String a : A) {
                for (String b : B) {
                    ans.add("(" + a + ")" + b);
                }
            }
        }
        store.put(n, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
