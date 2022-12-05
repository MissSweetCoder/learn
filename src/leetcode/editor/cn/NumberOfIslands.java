package leetcode.editor.cn;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1978 👎 0

public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] fa;

    int m , n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fa = new int[m * n];
        for (int i = 0 ; i < fa.length ; i++) fa[i] = i;

        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j] == '0') continue;

                for (int k = 0 ; k < 4 ; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || ni >= m || nj <0 || nj>= n) continue;
                    if (grid[ni][nj] == '1'){
                        unionSet(num(i , j) , num(ni , nj));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0 ; i < fa.length ; i++){
            if (fa[i] == i && grid[i / n][i % n]  == '1') {
                ans++;
            }
        }
        return ans;
    }

    public int num(int i , int j){
        return i * n + j;
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
