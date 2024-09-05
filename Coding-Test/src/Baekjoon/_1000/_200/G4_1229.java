package Baekjoon._1000._200;

import java.util.Arrays;
import java.util.Scanner;

public class G4_1229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sol(n));
    }

    private static int sol(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int idx = 0;
        int sixNum = sixN(idx);
        for (int i = 1; i <= n; i++) {
            int next = sixN(idx+1);

            if(next == i){
                dp[i] = 1;
                continue;
            }

            if(i > next) {
                idx++;
            }

            for(int j = idx; j >= 0; j++){
                sixNum = sixN(j);
                if(dp[sixNum] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i-sixNum]+dp[sixNum]);
            }
        }

        return dp[n];
    }

    private static int sixN(int n) {
        return 2*n*n - n;
    }
}
