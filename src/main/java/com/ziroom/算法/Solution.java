package com.ziroom.算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年07月27日 11:17:00
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format("%0"+4+"d",999L%(long)Math.pow(10, 4)));
    }

    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private static void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }
}
