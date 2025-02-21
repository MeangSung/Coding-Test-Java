package Baekjoon._00000._6000.__500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_6593 {
    static final int[][] dirs = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;

            char[][][] map = new char[l][r][c];
            boolean[][][] visited = new boolean[l][r][c];
            int[] start = new int[3];
            int[] end = new int[3];

            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    String arr = br.readLine();
                    for(int k = 0; k < c; k++){
                        char ch = arr.charAt(k);
                        if(ch == 'S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }
                        if(ch == 'E'){
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                        map[i][j][k] = ch;
                    }
                }
                br.readLine();
            }

            sb.append(bfs(map,visited,start,end)).append("\n");
        }

        System.out.println(sb);
    }

    private static String bfs(char[][][] map, boolean[][][] visited, int[] start, int[] end){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            int time = cur[3];

            if(z == end[0] && x == end[1] && y == end[2]){
                return "Escaped in "+time+" minute(s).";
            }

            for(int[] dir : dirs){
                int cz = z + dir[0];
                int cx = x + dir[1];
                int cy = y + dir[2];

                if(cz < 0 || cx < 0 || cy < 0 || cz >= map.length || cx >= map[0].length || cy >= map[0][0].length) continue;
                if(map[cz][cx][cy] == '#') continue;
                if(visited[cz][cx][cy]) continue;

                visited[cz][cx][cy] = true;
                q.offer(new int[]{cz, cx, cy, time+1});
            }
        }
        return "Trapped!";
    }
}
