package Baekjoon._00000._4000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_4179 {
    static int n,m;
    static char[][] map;
    static int[][] jihoonTimes;
    static int[][] fireTimes;
    static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        jihoonTimes = new int[n][m];
        fireTimes = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    private static String bfs() {

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                jihoonTimes[i][j] = -1;
                fireTimes[i][j] = -1;
                if(map[i][j] == 'F') {
                    fireTimes[i][j] = 0;
                    q1.offer(new int[]{i,j});
                }
                if(map[i][j] == 'J') {
                    jihoonTimes[i][j] = 0;
                    q2.offer(new int[]{i,j});
                }
            }
        }

        while(!q1.isEmpty()){
            int[] loc = q1.poll();

            int x = loc[0];
            int y = loc[1];

            for(int[] dir : directions) {
                int cx = x + dir[0];
                int cy = y + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
                if(map[cx][cy] == '#') continue;
                if(fireTimes[cx][cy] >= 0) continue;

                fireTimes[cx][cy] = fireTimes[x][y] + 1;
                q1.offer(new int[]{cx,cy});
            }
        }

        while(!q2.isEmpty()){
            int[] loc = q2.poll();
            int x = loc[0];
            int y = loc[1];

            for(int[] dir : directions) {
                int cx = x + dir[0];
                int cy = y + dir[1];

                if(cx < 0 || cx >= n || cy < 0 || cy >= m) {
                    return String.valueOf(jihoonTimes[x][y] + 1);
                }
                if(map[cx][cy] == '#') continue;
                if(jihoonTimes[cx][cy] >= 0) continue;
                if(fireTimes[cx][cy] != -1 &&fireTimes[cx][cy] <= jihoonTimes[x][y] + 1) continue;

                jihoonTimes[cx][cy] = jihoonTimes[x][y] + 1;
                q2.offer(new int[]{cx,cy});
            }
        }
        return "IMPOSSIBLE";
    }
}
