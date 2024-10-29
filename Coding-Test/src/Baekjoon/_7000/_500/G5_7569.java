package Baekjoon._7000._500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

public class G5_7569 {
    static int n,m,h;
    static int[][][] box;
    static int[][] direction = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(sol());
    }

    private static int sol() {
        int day = bfs();
        return lastCheck() ? day : -1;
    }

    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        int day = 0;

        for(int[] arr : initCheck()) q.offer(new Pair(arr,0));

        while(!q.isEmpty()) {
            Pair p = q.poll();

            day = Math.max(day,p.day);

            for(int[] dir : direction) {
                int ch = p.loc[0] + dir[0];
                int cx = p.loc[1] + dir[1];
                int cy = p.loc[2] + dir[2];

                if(ch < 0 || ch >= h || cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if(box[ch][cx][cy] != 0) continue;

                box[ch][cx][cy] = 1;
                q.offer(new Pair(new int[]{ch,cx,cy},p.day+1));
            }
        }

        return day;
    }

    private static List<int[]> initCheck() {
        List<int[]> init = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[i][j][k] == 1) {
                        init.add(new int[]{i, j, k});
                    }
                }
            }
        }
        return init;
    }

    private static boolean lastCheck(){
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    static class Pair{
        int[] loc;
        int day;

        public Pair(int[] loc, int day) {
            this.loc = loc;
            this.day = day;
        }
    }
}
