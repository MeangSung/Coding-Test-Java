package Baekjoon._00000._4000;

import java.util.Scanner;

public class S3_1463 {
    public static void main(String[] args) {
        int[] dp = new int[1000003];

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            if(i / 3 > 0 && i % 3 == 0) a = dp[i / 3] + 1;
            if(i % 2 == 0) b = dp[i / 2] + 1;
            c = dp[i-1] + 1;

            dp[i] = Math.min(a,Math.min(b,c));
        }

        System.out.println(dp[n]);
    }
}
