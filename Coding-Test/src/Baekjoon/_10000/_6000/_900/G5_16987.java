package Baekjoon._10000._6000._900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_16987 {
    static int n;
    static int[] d = new int[10], w = new int[10];
    static int max = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        sol(0);

        System.out.println(max);
    }

    private static void sol(int k) {
        if(k == n){
            max = Math.max(max, cnt);
            return;
        }

        if(d[k] <= 0){
            sol(k+1);
            return;
        }

        boolean hitOccur = false;

        for(int i = 0; i < n; i++){
            if(i == k || d[i] <= 0) continue;

            hitOccur = true;

            d[k] -= w[i];
            d[i] -= w[k];
            if(d[k] <= 0) cnt++;
            if(d[i] <= 0) cnt++;
            sol(k+1);
            if(d[k] <= 0) cnt--;
            if(d[i] <= 0) cnt--;
            d[k] += w[i];
            d[i] += w[k];
        }

        if(!hitOccur) sol(k+1);
    }

}
