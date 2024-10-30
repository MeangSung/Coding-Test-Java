package Baekjoon._00000._1000._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1389  {
    static int min = 40000;
    static int minIdx = -1;
    static List<Integer>[] relation;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        relation = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }

        solution();
        System.out.println(minIdx);

    }

    private static void solution(){

        for(int i = 1; i <= n; i++){
            int cnt = bfs(i);
            if( cnt < min){
                min = cnt;
                minIdx = i;
            }
        }
    }

    private static int bfs(int start){
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        Queue<Integer> q  = new LinkedList<>();
        visited[start] = 0;
        q.offer(start);

        int cnt = 0;
        while(!q.isEmpty()){
            int prevIdx = q.poll();

            for(int idx : relation[prevIdx]){
                if(visited[idx] == -1){
                    visited[idx] = visited[prevIdx] + 1;
                    cnt += visited[idx];
                    q.offer(idx);
                }
            }
        }

        return cnt;
    }

}
