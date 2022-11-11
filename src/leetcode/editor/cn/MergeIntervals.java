package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
//
//
// Related Topics 数组 排序 👍 1705 👎 0

public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> events = new ArrayList<>();
        for(int[] interval : intervals){
            events.add(new int[]{interval[0] , 1});
            events.add(new int[]{interval[1] + 1 , -1});
        }
        events.sort((a , b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        int start = 0;
        int cover = 0;
        List<int []> ans = new ArrayList<>();
        for(int[] event : events){
            if(cover == 0) start = event[0];
            cover += event[1];
            if(cover == 0) ans.add(new int[]{start , event[0] - 1});
        }
        return ans.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
