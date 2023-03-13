package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
//
// Related Topics 数组 回溯 👍 1300 👎 0

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    boolean[] used;
    List<Integer> a = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        recur(0, nums);
        return ans;
    }

    public void recur(int pos, int[] nums) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(a));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            a.add(nums[i]);
            recur(pos + 1, nums);
            a.remove(a.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
