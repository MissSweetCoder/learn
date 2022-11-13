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

    private int m;

    private int n;

    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid , i , j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid , int sx , int sy){
        int[] dx = new int[]{-1 , 0 ,1 , 0};
        int[] dy = new int[]{0 , 1 ,0 , -1};

        Queue<Pair<Integer , Integer>> q = new LinkedList<Pair<Integer , Integer>>();
        q.offer(new Pair<Integer , Integer>(sx,sy));
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            Pair<Integer , Integer> pair = q.poll();
            int x = pair.getKey();
            int y = pair.getValue();

            for(int i = 0 ; i < 4 ; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(grid[nx][ny] == '1' && !visited[nx][ny]){
                    q.offer(new Pair<Integer , Integer>(nx,ny));
                    visited[nx][ny] = true;

                }
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
