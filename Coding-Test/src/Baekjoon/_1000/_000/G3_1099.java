package Baekjoon._1000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_1099 {
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        String hStr = fs.nextLine();
        int n = fs.nextInt();
        String[] words = new String[n];

        for(int i = 0; i < n; i++) {
            words[i] = fs.nextLine();
        }

        System.out.println(sol(hStr,n,words));
    }

    private static int sol(String hStr, int n, String[] words) {
        int[] dp = new int[hStr.length()+1];
        Arrays.fill(dp,Integer.MAX_VALUE - 51);
        String[] splitHStr;

        dp[0] = 0;
        for(int i = 1; i <= hStr.length(); i++) {
            splitHStr = new String[i];
            for(int j = 0; j < i; j++) {
                splitHStr[j] = hStr.substring(j,i);
            }

            for(int j = 0; j < splitHStr.length; j++) {
                for(int k = 0; k < n; k++){
                    if(!compareWords(splitHStr[j], words[k])) continue;

                    int diff = diff(splitHStr[j],words[k]);

                    if(j == 0 ) {
                        dp[i] = Math.min(dp[i], diff);
                        continue;
                    };

                    dp[i] = Math.min(dp[i],diff+dp[j]);
                }
            }
        }
        if(dp[hStr.length()] != Integer.MAX_VALUE - 51) {
            return dp[hStr.length()];
        }else{
            return -1;
        }
    }

    private static int diff(String w1, String w2) {
        int cnt = 0;
        for(int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) cnt++;
        }
        return cnt;
    }

    private static boolean compareWords(String w1, String w2) {
        if(w1.length() != w2.length()) return false;
        int[] check = new int[26];
        for(int i = 0; i < w1.length(); i++) {
            check[w1.charAt(i) - 'a']++;
            check[w2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(check[i] != 0) return false;
        }
        return true;
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

        int nextInt(){ return Integer.parseInt(next()); }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
