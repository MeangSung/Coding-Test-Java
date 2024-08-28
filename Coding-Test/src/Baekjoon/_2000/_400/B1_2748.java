package Baekjoon._2000._400;

import java.util.Scanner;

class B1_2748{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dp = new long[91];
        dp[1] = 1L;
        for(int i = 2; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];

        System.out.println(dp[n]);
    }
}

