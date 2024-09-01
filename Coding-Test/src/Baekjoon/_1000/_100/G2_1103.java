package Baekjoon._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_1103 {
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int n,m;
    private static int[][] dp;
    private static String[][] points;
    private static boolean infinite = false;
    private static boolean[][] visited;
    private static int max = 0;
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        n = fs.nextInt();
        m = fs.nextInt();
        points = new String[n][m];
        for(int i = 0; i < n; i++){
            points[i] = fs.nextLine().split("");
        }
        dp = new int[n][m];
        visited = new boolean[n][m];

        dfs(0,0,1);

        if(infinite) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int moveCnt){
        if(moveCnt > max){
            max = moveCnt;
        }
        int nextMovePoint = Integer.parseInt(points[x][y]);

        for(int[] direction : directions){
            int cx = x + nextMovePoint*direction[0];
            int cy = y + nextMovePoint*direction[1];

            if(cx <0 || cx >= n || cy <0 || cy >= m) continue;

            if(points[cx][cy].equals("H")) continue;

            if(moveCnt < dp[cx][cy]) continue;

            if(visited[cx][cy]) {
                infinite = true;
                return;
            }

            visited[cx][cy] = true;
            dfs(cx,cy,moveCnt+1);
            visited[cx][cy] = false;
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){ return Integer.parseInt(next()); }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
