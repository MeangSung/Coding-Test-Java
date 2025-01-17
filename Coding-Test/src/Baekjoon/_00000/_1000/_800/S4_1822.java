package Baekjoon._00000._1000._800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S4_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] aArr = new int[n];
        int[] bArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol(aArr,bArr));
    }

    private static String sol(int[] aArr, int[] bArr) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        List<Integer> list = new ArrayList<>();

        for(int num : aArr){
            if(Arrays.binarySearch(bArr, num) < 0) list.add(num);
        }

        sb.append(list.size()).append("\n");
        for (int num : list) {
            sb.append(num).append(" ");
        }

        return sb.toString();
    }
}
