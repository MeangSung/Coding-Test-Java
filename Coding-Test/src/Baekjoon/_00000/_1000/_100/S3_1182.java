package Baekjoon._00000._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3_1182 {
    static int n,s;
    static List<Integer> list = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        sol(0,0);
        if(s == 0) cnt--;

        System.out.println(cnt);
    }

    private static void sol(int cur, int sum) {
        if(cur == n) {
            if(sum == s) cnt++;
            return;
        }

        sol(cur+1, sum);
        sol(cur+1, sum+list.get(cur));
    }
}
