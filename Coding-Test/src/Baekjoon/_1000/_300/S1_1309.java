package Baekjoon._1000._300;

import java.util.Scanner;

public class S1_1309 {
    private static final int T = 9901;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] dp = new int[n+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i = 2; i <= n; i++) {
            int dp0 = dp[i-1][0];
            int dp1 = dp[i-1][1];
            int dp2 = dp[i-1][2];

            dp[i][0] = (dp0 + dp1 + dp2) % T;
            dp[i][1] = (dp0 + dp2) % T;
            dp[i][2] = (dp0 + dp1) % T;

        }

        long res = (dp[n][0] + dp[n][1] + dp[n][2]) % T;
        System.out.println(res);
    }

}
