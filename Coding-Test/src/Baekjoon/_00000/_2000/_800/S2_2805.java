package Baekjoon._00000._2000._800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n,m,arr));
    }

    private static long solution(int n, long m, int[] arr) {
        long st = 0;
        long en = 2000000000;

        while(st < en) {
            long mid = (st + en + 1) / 2;

            if(sol(n,m,arr,mid)) st = mid;
            else en = mid - 1;
        }

        return st;
    }

    private static boolean sol(int n, long m, int[] arr, long mid) {
        long count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > mid) count += arr[i] - mid;
        }
        return count >= m;
    }
}
