package Baekjoon._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[3];
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(i == 0){
                dp = new int[]{r,g,b};
                continue;
            }
            int prev0 = dp[0];
            int prev1 = dp[1];
            int prev2 = dp[2];

            dp[0] = Math.min(r + prev1, r + prev2);
            dp[1] = Math.min(g + prev0, g + prev2);
            dp[2] = Math.min(b + prev0, b + prev1);

        }

        System.out.println(Math.min(dp[0], Math.min(dp[1],dp[2])));
    }

}
