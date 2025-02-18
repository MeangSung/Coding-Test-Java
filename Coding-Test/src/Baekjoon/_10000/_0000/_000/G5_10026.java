package Baekjoon._10000._0000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class G5_10026 {
    final static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] count = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new char[n][n];

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        IntStream.range(0,n).forEach(i -> {
            IntStream.range(0,n).forEach(j->{
               if(!visited[i][j]) {
                   bfs_general(new int[]{i, j});
                   count[0]++;
               };
            });
        });

        visited = new boolean[n][n];

        IntStream.range(0,n).forEach(i -> {
            IntStream.range(0,n).forEach(j->{
                if(!visited[i][j]) {
                    bfs_blindness(new int[]{i, j});
                    count[1]++;
                }
            });
        });

        System.out.println(count[0]+" "+count[1]);
    }

    private static void bfs_general(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        char cons = map[start[0]][start[1]];
        q.offer(start);
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;

            for(int[] dir : dirs) {
                int cx = x + dir[0], cy = y + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n) continue;
                if(visited[cx][cy]) continue;
                if(map[cx][cy] != cons) continue;

                q.offer(new int[]{cx, cy});
            }
        }
    }

    private static void bfs_blindness(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        char cons = map[start[0]][start[1]];
        q.offer(start);
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;
            for(int[] dir : dirs) {
                int cx = x + dir[0], cy = y + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n) continue;
                if(visited[cx][cy]) continue;

                switch (cons) {
                    case 'G', 'R':
                        if(map[cx][cy] == 'G' || map[cx][cy] == 'R') q.offer(new int[]{cx, cy});
                        break;
                    case 'B':
                        if(map[cx][cy] == 'B') q.offer(new int[]{cx, cy});
                }
            }
        }
    }
}
