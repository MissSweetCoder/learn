package com.ziroom.算法;

/**
 * @author kairanzhang
 * @Description TODO
 * @createTime 2021年03月12日 20:31:00
 */
public class 计数排序 {
    public static void main(String[] args) {
        int[] A = {1, 23, 567, 4, 3, 57, 2, 11, 2};
        int[] B = countSort(A,567);
        for (int i = 0 ; i < B.length ; i++){
            System.out.println(B[i] + ",");
        }
    }

    private static int[] countSort(int[] A, int k) {
        int[] C = new int[k+1];
        int sum = 0;

        for (int i = 0 ; i < A.length ; i++){
            C[A[i]] += 1;
        }

        for (int i = 0 ; i < k+1 ; i++){
            sum += C[i];
            C[i] = sum;
        }

        int[] B = new int[A.length];
        for (int i = 0 ; i < A.length ; i++){
            B[C[A[i]] - 1] = A[i];
            C[A[i]] --;
        }
        return B;
    }
}

