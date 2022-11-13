package leetcode.editor.cn;

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
// Related Topics 数组 回溯 👍 1551 👎 0

public class NQueens{
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;

    private List<Integer> p;

    private List<List<Integer>> ans;

    private boolean[] used;

    private HashSet<Integer> useMin;

    private HashSet<Integer> useMax;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        p = new ArrayList<>();
        ans = new ArrayList<>();
        used = new boolean[n];
        useMin = new HashSet<>();
        useMax = new HashSet<>();

        dfs(0);

        List<List<String>> result = new ArrayList<>();
        for(List<Integer> eachAns : ans){
            List<String> pattern = new ArrayList<>();
            for (int row = 0 ; row < eachAns.size() ; row++){
                StringBuilder str = new StringBuilder(".".repeat(n));
                str.setCharAt(eachAns.get(row) , 'Q');
                pattern.add(str.toString());
            }
            result.add(pattern);
        }
        return result;
    }

    public void dfs(int row){
        if(row == n){
            ans.add(new ArrayList<>(p));
            return;
        }

        for(int col = 0 ; col < n ; col++){
            if(!used[col] && !useMax.contains(row + col) && !useMin.contains(row - col)){
                p.add(col);
                used[col] = true;
                useMax.add(row + col);
                useMin.add(row - col);
                dfs(row + 1);
                useMin.remove(row - col);
                useMax.remove(row + col);
                used[col] = false;
                p.remove(p.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
