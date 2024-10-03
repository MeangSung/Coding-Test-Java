package Baekjoon._10000._1000._700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_11724 {
    private static boolean[] visited;
    private static List<Integer>[] map;
    private static int n,m,cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            map[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                bfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);

        while(!q.isEmpty()){
            int cur = q.poll();

            if(map[cur].isEmpty()) continue;

            for(int j : map[cur]){
                if(!visited[j]){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
        cnt++;
    }
}
