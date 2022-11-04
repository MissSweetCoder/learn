package com.ziroom.算法;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2022年10月23日 15:29:00
 */
public class Solution2 {
    // 分治解法
    public List<String> generateParenthesis(int n) {
        if (store == null) store = new HashMap<>();
        if (n == 0) return Arrays.asList("");
        if (store.containsKey(n)) return store.get(n); // 记忆化
        List<String> ans = new ArrayList<String>();
        for (int k = 1; k <= n; k++) { // 加法原理 ()
            List<String> A = generateParenthesis(k - 1);
            System.out.println("n = " + n + "，k = " + k + "，A" + JSON.toJSONString(A));
            List<String> B = generateParenthesis(n - k);//2
            System.out.println("n = " + n + "，k = " + k + "，B" +  JSON.toJSONString(B));
            // S=(A)B
            // 乘法原理
            for (String a : A){
                for (String b : B){
                    ans.add("(" + a + ")" + b);
                }
            }
            System.out.println("-----" + JSON.toJSONString(ans) + "--------");
        }
        store.put(n, ans);
        return ans;
    }

    HashMap<Integer, List<String>> store;

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.generateParenthesis(3);
    }
    /**
     * (A)B
     * n
     * (A) k
     * B n - k
     * __|____ ()()()
     * ____|__ ()()()
     *
     * () (A)
     * ()() B
     * */
}
