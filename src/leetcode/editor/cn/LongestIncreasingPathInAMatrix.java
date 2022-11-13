package leetcode.editor.cn;

//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4
//解释：最长递增路径为 [1, 2, 6, 9]。
//
// 示例 2：
//
//
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
//
//
// 示例 3：
//
//
//输入：matrix = [[1]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 2³¹ - 1
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 721 👎 0

public class LongestIncreasingPathInAMatrix{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int m;
    int n;
    int[] deg;
    List<List<Integer>> to;
    int[] dist;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        deg = new int[m*n];
        dist = new int[m*n];
        to = new ArrayList<>();
        for(int i = 0 ; i < m * n ; i++){
            to.add(new ArrayList<>());
        }

        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};

        for(int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (valid(ni , nj) && matrix[ni][nj] > matrix[i][j]){
                        addEdge(num(ni , nj) , num(i , j));
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < deg.length ; i++){
            if(deg[i] == 0){
                q.offer(i);
                dist[i] = 1;
            }
        }

        while (!q.isEmpty()){
            int x = q.poll();
            for(int y : to.get(x)){
                deg[y]--;
                dist[y] = Math.max(dist[x] + 1, dist[y]);
                if (deg[y] == 0) q.offer(y);
            }
        }

        int ans = 0;
        for(int i = 0 ; i < dist.length ; i++){
            ans = Math.max(ans , dist[i]);
        }
        return ans;
    }

    public boolean valid(int ni , int nj){
        return ni >=0 && ni < m && nj >= 0 && nj < n;
    }

    public void addEdge(int u , int v){
        deg[u]++;
        to.get(v).add(u);
    }

    public int num(int i , int j){
        return i * n + j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
