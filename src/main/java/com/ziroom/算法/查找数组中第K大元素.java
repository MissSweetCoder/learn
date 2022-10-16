package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description 查找数组中第K大元素
 * @createTime 2021年05月04日 14:36:00
 */
public class 查找数组中第K大元素 {
    public static void main(String[] args) {
        int[] collect = {4,2,5,12,3};
        int K = 1;
        int solve = getSolve(collect,0,collect.length - 1,K);
        System.out.println(solve);
    }

    private static int getSolve(int[] collect, int low, int high, int K) {

        int p = collect[high];
        int i = low;
        for (int j = low ; j <= high - 1 ; j++){
            if (collect[j] > p){
                int temp = collect[i];
                collect[i] = collect[j];
                collect[j] = temp;
                i++;
            }
        }
        collect[high] = collect[i];
        collect[i] = p;

        if (i == K-1){
            return collect[i];
        }else if (i < K-1){
            return getSolve(collect,i+1,high,K);
        }else {
            return getSolve(collect,low,i-1,K);
        }
    }
}
