package leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
//
// Related Topics 哈希表 字符串 回溯 👍 2189 👎 0

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<String> ans = new ArrayList<>();

    private String digits;

    private Map<Character,String> alphabet = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        this.digits = digits;

        alphabet.put('2', "abc");
        alphabet.put('3', "def");
        alphabet.put('4', "ghi");
        alphabet.put('5', "jkl");
        alphabet.put('6', "mno");
        alphabet.put('7', "pqrs");
        alphabet.put('8', "tuv");
        alphabet.put('9', "wxyz");

        if(digits.isEmpty()) return ans;

        dfs(0,"");
        return ans;
    }

    public void dfs(int index , String str){
        if(index == digits.length()){
            ans.add(str);
            return;
        }

        char curr = digits.charAt(index);
        for (char c : alphabet.get(curr).toCharArray()){
            dfs(index + 1 , str + c);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
