package Baekjoon._2000._500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2579 {
    private static int n;
    private static int[] stairs;
    private static Integer dfsDp[];

    public static void main(String[] args) {
        FastScan fs = new FastScan();

        n = fs.nextInt();
        stairs = new int[n+1];
        dfsDp = new Integer[n+1];
        for(int i = 1; i < n+1; i++) {
            stairs[i] = fs.nextInt();
        }
        dfsDp[1] = stairs[1];
        dfsDp[2] = stairs[2];
        if(n > 1){
            dfsDp[3] = dfsDp[1] + dfsDp[2];
        }

        System.out.println("bfs : "+ bfs());
        System.out.println("dfs : "+ dfs(n));
    }

    private static int bfs() {
        int[] dp = new int[n+1];

        dp[1] = stairs[1];

        if(n >= 2){
            dp[2] = stairs[2]+stairs[1];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }

        return dp[n];
    }

    private static int dfs(int num) {

        if(dfsDp == null) {
            dfsDp[num] = Math.max(dfs(num - 2), dfs(num - 3) + stairs[num - 1]) + stairs[num];
        }

        return dfsDp[num];
    }

    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){ return Integer.parseInt(next());}
    }
}
