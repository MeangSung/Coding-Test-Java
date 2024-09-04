package Baekjoon._2000._500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2502 {
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        int d = fs.nextInt();
        int k = fs.nextInt();


        for(int n : sol(d,k)){
            System.out.println(n);
        }
    }

    private static int[] sol(int d, int k) {
        int[][] dp = new int[d+1][2];
        dp[1] = new int[]{1,0};
        dp[2] = new int[]{0,1};

        for(int i = 3; i <= d; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int first = dp[d][0];
        int second = dp[d][1];

        int res1 = 1;
        int res2 = 1;
        while(true){
            if((k-first*res1)%second == 0){
                res2 = (k-first*res1)/second;
                break;
            }
            res1++;
        }

        return new int[]{res1,res2};
    }

    private static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {return Integer.parseInt(next());}
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
