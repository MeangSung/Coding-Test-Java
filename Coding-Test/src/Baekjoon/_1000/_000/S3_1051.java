package Baekjoon._1000._000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1051 {
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        int n = fs.nextInt();
        int m = fs.nextInt();

        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = fs.nextLine();
            for(int j = 0; j < m; j++){
                 board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println((int) Math.pow(sol(n,m,board),2));
    }

    private static int sol(int n, int m, int[][] board){
        int max = 1;

        int len = Math.min(n, m);

        while(len > 1){
            for(int i = 0; i <= n - len;i++){
                for(int j = 0; j <= m - len;j++){
                    int num = board[i][j];
                    if(num == board[i][j+len-1] && num == board[i+len-1][j] && num == board[i+len-1][j+len-1]){
                        max = Math.max(max, len);
                    }
                }
            }
            len--;
        }

        return max;
    }


    static class FastScan {
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
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){ return Integer.parseInt(next()); }

        String nextLine(){
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
