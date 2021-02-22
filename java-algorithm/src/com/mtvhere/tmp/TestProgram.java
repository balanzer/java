package com.mtvhere.tmp;

import java.util.Arrays;

public class TestProgram {
    public static void main(String[] args) {
        TestProgram solution = new TestProgram();
        char[][] input = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int output = solution.maximalSquare(input);
        System.out.println("Max : " + output);
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        System.out.println("rows : " + rows + ", cols : " + cols);
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;


        for (int i = 1; i <= rows; i++) {
            System.out.println("DP : " + Arrays.toString(dp));


            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {

                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;


                    // maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }


        }

        return maxsqlen * maxsqlen;
    }
}
