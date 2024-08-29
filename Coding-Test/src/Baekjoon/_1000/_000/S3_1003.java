package Baekjoon._1000._000;

import java.util.Scanner;

public class S3_1003 {
    private static int[][] dp = new int[41][2];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scan.nextInt();

        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        sol();

        for(int i = 0; i < n; i++){
            int num = scan.nextInt();
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void sol(){
        for(int i = 2; i < dp.length; i++){
            dp[i] = new int[]{dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]};
        }
    }
}
