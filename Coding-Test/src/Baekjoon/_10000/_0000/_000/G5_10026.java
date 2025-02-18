package Baekjoon._10000._0000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_10026 {
    final static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }


        System.out.println(sol(false)+" "+sol(true));
    }

    private static int sol(boolean blindness) {
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, blindness, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int a, int b, boolean blindness, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});
        visited[a][b] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for(int[] dir : dirs) {
                int cx = x + dir[0], cy = y + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n) continue;
                if(visited[cx][cy]) continue;

                if(blindness && (map[x][y] == 'R' || map[x][y] == 'G')) {
                    if(map[cx][cy] == 'R' || map[cx][cy] == 'G') {
                        q.offer(new int[]{cx,cy});
                        visited[cx][cy] = true;
                    }
                }
                else if(map[cx][cy] == map[x][y]) {
                    q.offer(new int[]{cx,cy});
                    visited[cx][cy] = true;
                }
            }
        }
    }
}
