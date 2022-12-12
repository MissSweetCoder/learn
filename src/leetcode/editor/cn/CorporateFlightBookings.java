package leetcode.editor.cn;

//这里有 n 个航班，它们分别从 1 到 n 进行编号。
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
//
//
//
// 示例 1：
//
//
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
//
//
// 示例 2：
//
//
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2 * 10⁴
// 1 <= bookings.length <= 2 * 10⁴
// bookings[i].length == 3
// 1 <= firsti <= lasti <= n
// 1 <= seatsi <= 10⁴
//
//
// Related Topics 数组 前缀和 👍 428 👎 0

public class CorporateFlightBookings{
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] delta = new int[n + 2];
        for (int i = 0 ; i < bookings.length ; i++){
            int first = bookings[i][0];
            int second = bookings[i][1];
            int seats = bookings[i][2];
            delta[first] += seats;
            delta[second + 1] -= seats;
        }
        int[] sum = new int[n + 1];
        for (int i = 1 ; i < n + 1 ; i++){
            sum[i] = sum[i - 1] + delta[i];
        }
        int[] ans = new int[n];
        for (int i = 1 ; i < n + 1 ; i++){
            ans[i - 1] = sum[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
