package Baekjoon._00000._1000._600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class G3_1600 {
    private static int[][] map;
    private static boolean[][][] visited;
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int[][] horseDirections = {{-2, -1}, {-2, 1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}};
    static int k,w,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k+1];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,k,0));
        visited[0][0][k] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();


            if(cur.x == h-1 && cur.y == w-1) {
                return cur.count;
            }

            for(int[] dir : directions) {
                int cx = cur.x + dir[0];
                int cy = cur.y + dir[1];

                if(cx < 0 || cx >= h || cy < 0 || cy >= w) continue;
                if(map[cx][cy] == 1) continue;
                if(visited[cx][cy][cur.cnt]) continue;

                visited[cx][cy][cur.cnt] = true;
                q.offer(new Pair(cx,cy,cur.cnt,cur.count + 1));
            }

            if(cur.cnt > 0) {
                for (int[] horseDirection : horseDirections) {
                    int cx = cur.x + horseDirection[0];
                    int cy = cur.y + horseDirection[1];

                    if(cx < 0 || cx >= h || cy < 0 || cy >= w) continue;
                    if(map[cx][cy] == 1) continue;
                    if(visited[cx][cy][cur.cnt-1]) continue;

                    visited[cx][cy][cur.cnt-1] = true;
                    q.offer(new Pair(cx,cy,cur.cnt-1,cur.count + 1));
                }
            }
        }
        return -1;
    }

    static class Pair{
        int x;
        int y;
        int cnt;
        int count;

        public Pair(int x, int y, int cnt, int count) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.count = count;
        }
    }
}
