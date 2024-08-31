package Baekjoon._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1106 {
    public static void main(String[] args){
        FastScan fs = new FastScan();

        int C = fs.nextInt();
        int N = fs.nextInt();

        int[] dp = new int[100001];
        int[][] city = new int[N][2];

        for(int i = 0; i < N; i++){
            int cost = fs.nextInt();
            int customer = fs.nextInt();

            city[i] = new int[]{cost,customer};
        }

        System.out.println(sol(C,N,dp,city));

    }

    private static int sol(int C, int N, int[] dp, int[][] city){

        for(int i = 1; i < 100001; i++){
            for(int j = 0; j < N; j++){
                if(city[j][0] <= i){
                    dp[i] = Math.max(dp[i], dp[i - city[j][0]] + city[j][1]);
                }
            }

            if(dp[i] >= C){
                return i;
            }
        }

        return 0;
    }

    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){br = new BufferedReader(new InputStreamReader(System.in));}

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){return Integer.parseInt(next());}
        String nextString(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}


