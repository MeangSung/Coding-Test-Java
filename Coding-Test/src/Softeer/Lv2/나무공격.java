package Softeer.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무공격 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        requestMap(n, br, m, arr);

        int[][] atk = new int[2][2];
        requestAtk(atk,br);

        for(int[] a : atk) {
            for(int i = a[0] -1 ; i < a[1] ; i++) {
                if(arr[i] > 0 ) arr[i]--;
            }
        }

        System.out.println(Arrays.stream(arr).sum());
    }

    private static void requestMap(int n, BufferedReader br, int m, int[] arr) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                cnt += Integer.parseInt(st.nextToken());
            }
            arr[i] = cnt;
        }
    }

    private static void requestAtk(int[][] atk, BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                atk[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
