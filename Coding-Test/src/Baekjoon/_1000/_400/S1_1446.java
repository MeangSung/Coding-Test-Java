package Baekjoon._1000._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1446 {
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        int n = fs.nextInt();
        int d = fs.nextInt();

        int[][] shortcut = new int[n][3];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                shortcut[i][j] = fs.nextInt();
            }
        }

        System.out.println(sol(n,d,shortcut));
    }

    private static int sol(int n, int d, int[][] shortcut) {
        int[] dp = new int[d+1];
        for(int i = 0; i < d+1; i++) {
            dp[i] = i;
        }

        for(int i = 1; i <= d; i++){

            dp[i] = Math.min(dp[i], dp[i-1] + 1);
            for(int j = 0; j < n; j++){
                if(shortcut[j][1] == i){
                    dp[i] = Math.min(dp[i], dp[shortcut[j][0]] + shortcut[j][2]);
                }
            }
        }

        return dp[d];

    }

    private static class FastScan {
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

        int nextInt(){return Integer.parseInt(next());}
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
