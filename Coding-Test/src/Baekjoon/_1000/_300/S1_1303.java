package Baekjoon._1000._300;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1303 {
    static int[][] d = {{1,0},{0,1},{0,-1},{-1,0}};
    static int n,m,c=0,w=0,b=0;
    static Character[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new Character[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = tmp.charAt(j);
                map[i][j]= c;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    c=1;
                    visited[i][j] = true;
                    q.add(new Point(i,j));

                    bfs();

                    if(map[i][j] == 'W') {
                        w+=c*c;
                    }
                    if(map[i][j] == 'B') {
                        b+=c*c;
                    }
                }
            }
        }

        System.out.println(w + " " + b);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int[] cd : d) {
                int cx = x + cd[0];
                int cy = y + cd[1];

                if(cx < 0 || cx > n-1 || cy < 0 || cy > m-1) continue;
                if(visited[cx][cy]) continue;
                if(map[x][y] != map[cx][cy]) continue;

                c++;
                visited[cx][cy] = true;
                q.add(new Point(cx,cy));
            }
        }
    }
}
