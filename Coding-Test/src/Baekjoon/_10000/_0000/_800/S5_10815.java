package Baekjoon._10000._0000._800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol(n,m, nArr,mArr));
    }

    private static String sol(int n, int m, int[] nArr, int[] mArr) {
        Arrays.sort(nArr);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            if(Arrays.binarySearch(nArr, mArr[i]) >= 0) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        return sb.toString();
    }
}
