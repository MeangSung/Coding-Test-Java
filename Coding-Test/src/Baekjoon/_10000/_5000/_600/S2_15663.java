package Baekjoon._10000._5000._600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S2_15663 {
    static int n,m;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        temp = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(sol());
    }

    private static String sol() {
        Set<String> set = new LinkedHashSet<>();

        dfs(0,set);

        StringBuilder sb = new StringBuilder();
        for(String str : set) {
            sb.append(str).append("\n");
        }

        return sb.toString();
    }

    private static void dfs(int k, Set<String> set) {
        if(k >= m){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(temp[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                temp[k] = arr[i];
                dfs(k+1, set);
                visited[i] = false;
            }
        }
    }
}
