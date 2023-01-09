package leetcode.editor.cn;

//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
// 字母和数字都属于字母数字字符。
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
//
//
// 示例 2：
//
//
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
//
//
// 示例 3：
//
//
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2 * 10⁵
// s 仅由可打印的 ASCII 字符组成
//
//
// Related Topics 双指针 字符串 👍 597 👎 0

public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int l = getNext(s , 0);
        int r = getPre(s , s.length() - 1);
        while (l < r){
            if (!equalsIgnoreCase(s.charAt(l) , s.charAt(r))) return false;
            l = getNext(s , l + 1);
            r = getPre(s , r - 1);
        }
        return true;
    }

    boolean isDigitalOrLetter(char ch){
        return ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }

    int getNext(String s , int i){
        while (i < s.length() && !isDigitalOrLetter(s.charAt(i))) i++;
        return i;
    }

    int getPre(String s , int i){
        while (i >= 0 && !isDigitalOrLetter(s.charAt(i))) i--;
        return i;
    }

    boolean equalsIgnoreCase(char ch1 , char ch2){
        return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
