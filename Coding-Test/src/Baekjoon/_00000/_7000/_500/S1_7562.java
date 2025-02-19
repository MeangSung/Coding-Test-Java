package Baekjoon._00000._7000._500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_7562 {
    static final int[][] dirs = new int[][]{{-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bfs(k, start, end);
        }
        System.out.println(sb);
    }

    private static void bfs(int k, int[] start, int[] end) {
        int[][] visited = new int[k][k];

        for(int[] v : visited) Arrays.fill(v, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for(int[] dir : dirs){
                int cx = x + dir[0];
                int cy = y + dir[1];

                if(cx < 0 || cy < 0 || cx >= k || cy >= k) continue;
                if(visited[cx][cy] >= 0) continue;

                visited[cx][cy] = visited[x][y] + 1;
                q.offer(new int[]{cx, cy});
            }
        }

        sb.append(visited[end[0]][end[1]]).append("\n");
    }

}
