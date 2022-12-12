package leetcode.editor.cn;

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
//
//
// 示例 2：
//
//
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= haystack.length, needle.length <= 10⁴
// haystack 和 needle 仅由小写英文字符组成
//
//
// Related Topics 双指针 字符串 字符串匹配 👍 1668 👎 0

public class FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        haystack = " " + haystack;
        needle = " " + needle;

        int p = (int)1e9 + 7;
        int b = 131;
        long pow = 1;
        long nHash = 0;
        for (int i = 1 ; i <= m ; i++){
            nHash = (nHash * b + needle.charAt(i) - 'a' + 1) % p;
            pow = pow * b % p;
        }

        long[] sHash = new long[n + 1];
        for (int i = 1 ; i <= n ; i++){
            sHash[i] = (sHash[i - 1] * b + haystack.charAt(i) - 'a' + 1) % p;
        }

        for (int r = m ; r <= n ; r++){
            int l = r - m + 1;
            long hash = ((sHash[r] - sHash[l - 1] * pow) % p + p) % p;

            if (hash == nHash){
                return r - m;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
