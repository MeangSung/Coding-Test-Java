package Baekjoon._10000._5000._600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15649 {

    static int n, m;
    static int[] temp = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sol(0);
        System.out.println(sb.toString());
    }

    private static void sol(int k) {
        if(k == m){
            for(int i = 0; i < m; i++){
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                temp[k] = i;
                visited[i] = true;
                sol(k + 1);
                visited[i] = false;
            }
        }
    }
}
