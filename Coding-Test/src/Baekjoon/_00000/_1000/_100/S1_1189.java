package Baekjoon._00000._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S1_1189 {
    static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static int r,c,k;
    static int N=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(dfs());
    }

    private static int dfs() {
        Stack<Han> stack = new Stack<>();
        boolean[][] firstVisited = new boolean[r][c];
        firstVisited[r-1][0] = true;
        stack.push(new Han(r-1,0,1,firstVisited));

        while(!stack.isEmpty()) {
            Han cur = stack.pop();

            if(cur.x == 0 && cur.y == c-1) {
                if(cur.cnt == k){
                    N++;
                }
                continue;
            }

            for(int[] d : directions) {
                int cx = cur.x + d[0];
                int cy = cur.y + d[1];

                if(cx < 0 || cx >= r || cy < 0 || cy >= c) continue;
                if(cur.visited[cx][cy]) continue;
                if(map[cx][cy] == 'T') continue;

                boolean[][] newVisited= copyVisited(cur.visited);
                newVisited[cx][cy] = true;
                stack.push(new Han(cx,cy,cur.cnt + 1,newVisited));
            }
        }

        return N;
    }

    private static boolean[][] copyVisited(boolean[][] visited) {
        boolean[][] newVisited= new boolean[r][c];
        for(int i = 0; i < r; i++) {
            newVisited[i] = visited[i].clone();
        }
        return newVisited;
    }

    static class Han{
        int x;
        int y;
        int cnt;
        boolean[][] visited;

        public Han(int x, int y, int cnt, boolean[][] visited) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.visited = visited;
        }
    }
}
