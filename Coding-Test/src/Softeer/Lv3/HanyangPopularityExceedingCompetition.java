package Softeer.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HanyangPopularityExceedingCompetition {
    static int[][] arr, dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        dp = new int[n][2];

        for(int i =0 ; i< n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol());
    }

    private static int sol(){
        dp[0][0] = calculate(0, arr[0][0], arr[0][1]) ? 1 : 0;

        for(int i = 1; i < n; i++){
            int pi = arr[i][0];
            int ci = arr[i][1];

            int x1 = dp[i-1][0], x2 = dp[i-1][1];

            int nx1 = calculate(x1, pi, ci) ? x1 + 1 : x1;
            int nx2 = calculate(x2, pi, ci) ? x2 + 1 : x2;

            dp[i][0] = Math.max(nx1, nx2);
            dp[i][1] = Math.max(x1,x2);
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }


    private static boolean calculate(int x, int p, int c){
        return Math.abs(p - x) <= c;
    }
}
