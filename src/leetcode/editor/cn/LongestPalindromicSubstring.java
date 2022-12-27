package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 5983 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
       int  n = s.length();
       int ansStart = 0;
       int ansLen = 0;

       // 奇数
       for (int centre = 0 ; centre < n ; centre++){
           int l = centre - 1 ; int r = centre + 1;
           while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
               l-- ;
               r++;
           }
           //  l+1 ~ r-1
           if (r - l - 1 > ansLen){
               ansLen = r - l - 1;
               ansStart = l + 1;
           }
       }

       // 偶数
       for (int centre = 1 ; centre < n ; centre++){
           int l = centre - 1 ; int r = centre;
           while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
               l-- ;
               r++;
           }
           //  l+1 ~ r-1
           if (r - l - 1 > ansLen){
               ansLen = r - l - 1;
               ansStart = l + 1;
           }
       }

       return s.substring(ansStart , ansStart + ansLen);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
