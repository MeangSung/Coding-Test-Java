package Baekjoon._00000._5000._400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_5427 {
    static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            char[][] map = new char[b][a];
            int[] start = new int[2];
            List<int[]> fires = new ArrayList<>();
            for(int i = 0; i < b; i++){
                String s = br.readLine();
                for(int j = 0; j < a; j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '@') {
                        start[0] = i;
                        start[1] = j;
                    }
                    if(map[i][j] == '*') fires.add(new int[]{i,j});
                }
            }

            sb.append(bfs(map, start, fires)).append("\n");
        }
        System.out.println(sb);
    }

    private static String bfs(char[][] map, int[] start, List<int[]> fires){
        Queue<int[]> q = new LinkedList<>();
        int[][] fire_visited = new int[map.length][map[0].length];

        for(int[] f : fires) {
            fire_visited[f[0]][f[1]] = 1;
            q.offer(f);
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for(int[] dir : dirs) {
                int cx = x + dir[0];
                int cy = y + dir[1];

                if(cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) continue;
                if(map[cx][cy] == '#') continue;
                if(fire_visited[cx][cy] > 0) continue;

                fire_visited[cx][cy] = fire_visited[x][y] + 1;
                q.offer(new int[]{cx, cy});
            }
        }

        int[][] visited = new int[map.length][map[0].length];
        q.offer(start);
        visited[start[0]][start[1]] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int cx = x + dir[0];
                int cy = y + dir[1];

                if (cx < 0 || cy < 0 || cx >= map.length || cy >= map[0].length) {
                    return String.valueOf(visited[x][y]);
                }

                if (map[cx][cy] == '#') {
                    continue;
                }

                if(visited[cx][cy] > 0) continue;

                if (fire_visited[cx][cy] != 0 &&fire_visited[cx][cy] <= visited[x][y] + 1) {
                    continue;
                }
                visited[cx][cy] = visited[x][y] + 1;
                q.offer(new int[]{cx, cy});
            }

        }
        return "IMPOSSIBLE";
    }
}
