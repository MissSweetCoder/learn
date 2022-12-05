package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。
//
//
//
// 示例 1：
//
//
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] 是一个小写英文字母
// 1 <= words.length <= 3 * 10⁴
// 1 <= words[i].length <= 10
// words[i] 由小写英文字母组成
// words 中的所有字符串互不相同
//
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 726 👎 0

public class WordSearchIi{
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Node{
        String word;
        HashMap<Character , Node> child;
        Node(){
            word = null;
            child = new HashMap<Character , Node>();
        }
    }

    int m ,n ;
    List<String> ans;
    boolean[][] visited ;
    Node root;
    int[] dx = {-1 , 0 , 1 , 0};
    int[] dy = {0 , 1 , 0 , -1};

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        ans = new ArrayList<>();
        root = new Node();

        for (String word : words){
            insert(word , root);
        }

        for (int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                visited = new boolean[m][n];
                visited[i][j] = true;
                dfs(board , i , j , root);
            }
        }
        return ans;
    }

    public void dfs(char[][] board , int i , int j , Node curr){
        char ch = board[i][j];
        if (!curr.child.containsKey(ch)) return;
        Node fa = curr;
        curr = fa.child.get(ch);
        if (curr.word != null){
            ans.add(curr.word);
            curr.word = null;
        }
        if (curr.child.isEmpty()){
            fa.child.remove(ch);
        }
        for (int k = 0 ; k < 4 ; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= m || y >= n) continue;
            if(visited[x][y]) continue;
            visited[x][y] = true;
            dfs(board , x , y ,curr);
            visited[x][y] = false;
        }
    }

    public void insert(String word , Node root){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.child.containsKey(ch)){
                curr.child.put(ch , new Node());
            }
            curr = curr.child.get(ch);
        }
        curr.word = word;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
