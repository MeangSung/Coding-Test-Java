import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static boolean[][] visited;
    static class Point {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int wPower = 0; int bPower = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    int cnt = BFS(i,j,map[i][j]);
                    if(map[i][j] == 'W') {
                        wPower += cnt;
                    } else {
                        bPower += cnt;
                    }
                }
            }
        }

        System.out.println(wPower);
        System.out.println(bPower);

    }

    public static int BFS(int x, int y, char z) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x,y));

        int rtnCnt = 1;
        while(!q.isEmpty()) {
            Point point = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx >= 0 && nx < N-1 && ny >= 0 && ny < M-1) {
                    if(!visited[nx][ny] && map[nx][ny] == z) {
                        visited[nx][ny] = true;
                        rtnCnt++;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
        return rtnCnt * rtnCnt;
    }
}