package Baekjoon._1000._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1497 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m;
    private static long[] guitars;
    private static int minGuitars = Integer.MAX_VALUE;
    private static int maxPlay = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        guitars = new long[n];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String canPlay = st.nextToken();
            long bitmask = 0;
            for(int j = m; j > 0; j--){
                if(canPlay.charAt(j-1) == 'Y') bitmask |= (1L << (m-j));
            }
            guitars[i] = bitmask;
        }

        for(int i = 1; i <=n; i++){
            sol(0,0,i,0);
            if(maxPlay == m) break;
        }

        System.out.println(minGuitars == Integer.MAX_VALUE ? -1 : minGuitars);
    }

    private static void sol(int cnt, int start, int cur, long canPlaySum) {
        if(cnt == cur){
            int canPlayNum = Long.bitCount(canPlaySum);
            if(canPlayNum > maxPlay){
                maxPlay = canPlayNum;
                minGuitars = cur;
            }
            return;
        }

        for(int i = start; i < n; i++){
            sol(cnt+1, i+1,cur,canPlaySum|guitars[i]);
        }
    }
}
