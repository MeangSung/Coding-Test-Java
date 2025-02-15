package Baekjoon._10000._5000._600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S2_15665 {
    static int n,m;
    static List<Integer> arr = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        temp = new int[m];
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int comp = Integer.parseInt(st.nextToken());
            if(!arr.contains(comp)) {
                arr.add(comp);
            }
        }


        Collections.sort(arr);

        sol(0);

        System.out.println(sb);
    }

    private static void sol(int cnt) {
        if(cnt == m){
            for(int num : temp){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (Integer integer : arr) {
            temp[cnt] = integer;
            sol(cnt + 1);

        }
    }
}
