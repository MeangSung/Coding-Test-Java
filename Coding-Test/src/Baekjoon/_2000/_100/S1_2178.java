package Baekjoon._2000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {
    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int solution(int n, int m, int[][] map){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int[] d : directions){
                int cx = cur[0] + d[0];
                int cy = cur[1] + d[1];

                if(cx <0 || cx >= n || cy <0 || cy >= m) continue;
                if(map[cx][cy] == 0) continue;
                if(visited[cx][cy]) continue;

                visited[cx][cy] = true;
                map[cx][cy] = map[cur[0]][cur[1]] + 1;
                q.add(new int[]{cx, cy});
            }
        }
        return map[n-1][m-1];
    }

//    public int bfs(int[][] map, int[][] visited){
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{0,0,1});
//        visited[0][0] = 1;
//        int res = 0;
//        while(!q.isEmpty()){
//            int[] cur = q.poll();
//            int x = cur[0];
//            int y = cur[1];
//            int cnt = cur[2];
//            if(x == map.length-1 && y == map[0].length-1){
//                res = cnt;
//            }
//            for (int[] d : directions){
//                int newX = x + d[0];
//                int newY = y + d[1];
//                if(newX >=0 && newX < map.length && newY >=0 && newY < map[0].length){
//                    if(map[newX][newY] == 1 && visited[newX][newY] == 0){
//                        visited[newX][newY] = 1;
//                        q.add(new int[]{newX, newY, cnt+1});
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] a = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(a[j]);
            }
        }
        System.out.println(new S1_2178().solution(n, m, map));
    }
}
