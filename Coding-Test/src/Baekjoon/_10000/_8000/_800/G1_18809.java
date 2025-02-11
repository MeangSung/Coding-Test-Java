package Baekjoon._10000._8000._800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int time;
    int type;
    public Pair(int time, int type) {
        this.time = time;
        this.type = type;
    }
}

public class G1_18809 {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n,m,r,g;
    static int[][] garden;
    static Pair[][] visited;
    static List<int[]> gg = new ArrayList<>();
    static int max = 0;
    static int[] idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        garden = new int[n][m];
        visited = new Pair[n][m];

        for(int i = 0;i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < m;j++) {
                int component = Integer.parseInt(st.nextToken());
                garden[i][j] = component;
                if(component == 2) gg.add(new int[]{i,j});
            }
        }

        idx = new int[gg.size()];

        backtrackGreen(0,0);

        System.out.println(max);
    }


    private static void backtrackGreen(int start, int k) {
        if(k == g){
            backtrackRed(0,0);
            return;
        }

        for(int i = start; i < idx.length; i++){
            if(idx[i] == 0){
                idx[i] = 1;
                backtrackGreen(i+1, k+1);
                idx[i] = 0;
            }
        }
    }

    private static void backtrackRed(int start, int k) {
        if(k == r){
            bfs();

            visited = new Pair[n][m];
            return;
        }
        for(int i = start; i < idx.length; i++){
            if(idx[i] == 0){
                idx[i] = 2;
                backtrackRed(i+1, k+1);
                idx[i] = 0;
            }
        }
    }

    private static void bfs() {
        int fc = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < idx.length; i++){
            if(idx[i] == 1){
                int x = gg.get(i)[0];
                int y = gg.get(i)[1];
                visited[x][y] = new Pair(1, 1);
                q.offer(new int[]{x,y,1});
            }
        }

        for(int i = 0; i < idx.length; i++){
            if(idx[i] == 2){
                int x = gg.get(i)[0];
                int y = gg.get(i)[1];
                visited[x][y] = new Pair(1, 2);
                q.offer(new int[]{x,y,2});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int seed = cur[2];
            int currentTime = visited[x][y].time;
            int currentType = visited[x][y].type;

            if(currentType == 3) continue;

            for(int[] d : directions){
                int cx = x + d[0];
                int cy = y + d[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if(garden[cx][cy] == 0) continue;

                if(visited[cx][cy] == null){
                    visited[cx][cy] = new Pair(currentTime+1, currentType);
                    q.add(new int[]{cx,cy,seed});
                    continue;
                }

                if(currentType != visited[cx][cy].type && currentTime +1 == visited[cx][cy].time){
                    visited[cx][cy] = new Pair(-1, 3);
                    fc ++;
                }
            }

            max = Math.max(max, fc);
        }
    }


}
