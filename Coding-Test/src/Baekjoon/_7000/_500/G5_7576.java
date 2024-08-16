package Baekjoon._7000._500;

import java.util.*;
import java.io.*;

public class G5_7576{
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int solution(int n, int m, int[][] box ){
        boolean[][] visited = new boolean[n][m];
        int last = -1;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 1){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d: directions){
                int cx = cur[0] + d[0];
                int cy = cur[1] + d[1];

                if(cx <0 || cx >= n || cy <0 || cy >= m) continue;
                if(visited[cx][cy]) continue;
                if(box[cx][cy] != 0) continue;

                visited[cx][cy] = true;
                q.add(new int[]{cx, cy});
                box[cx][cy] = box[cur[0]][cur[1]] + 1;
                last = box[cx][cy];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0){
                    return -1;
                }
            }
        }
        if(last == -1) return 0;
        return last-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] box = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j< m ; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(new G5_7576().solution(n,m,box));
    }

}