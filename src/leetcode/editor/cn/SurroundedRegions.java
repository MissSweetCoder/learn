package leetcode.editor.cn;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [["X"]]
//输出：[["X"]]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 890 👎 0

public class SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] fa;
    int m ;
    int n ;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        fa = new int[m * n + 1];
        for (int i = 0 ; i < fa.length ; i++) fa[i] = i;

        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};

        int outside = m * n;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j] == 'X') continue;
                for (int k = 0 ; k < 4 ; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n){
                        unionSet(num(i , j) , outside);
                    }else {
                        if (board[ni][nj] == 'O'){
                            unionSet(num(i , j) , num(ni , nj));
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j] == 'O' && find(num(i , j)) != find(outside)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public int num(int i , int j){
        return (i * n) + j;
    }

    public int find(int x){
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    public void unionSet(int x , int y){
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
