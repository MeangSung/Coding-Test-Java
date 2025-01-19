package Baekjoon._10000._6000._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] snacks = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n,m,snacks));
    }

    private static long solution(int n, int m, int[] snacks) {

        long st = 0;
        long en = 1000000000;

        while (st < en) {
            long mid = (st + en + 1) / 2;

            if(sol(n, m, snacks, mid)) st = mid;
            else en = mid - 1;
        }


        return st;
    }

    private static boolean sol(int n, int m, int[] snacks, long mid) {
        int count = 0;
        for(int i = 0; i < m; i++) count+= (int) (snacks[i] / mid);
        return count >= n;
    }
}
