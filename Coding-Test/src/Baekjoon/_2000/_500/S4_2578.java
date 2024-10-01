package Baekjoon._2000._500;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Point> hash = new HashMap<Integer, Point>();
        int[][] board = new int[5][5];
        boolean[][] visited = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                hash.put(board[i][j], new Point(i, j));
            }
        }

        int cnt = 0;
        int res = 0;
        boolean win = false;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 5; j++) {
                cnt++;
                int num = Integer.parseInt(st.nextToken());
                Point p = hash.get(num);
                visited[p.x][p.y] = true;

                if(!win && cnt > 12){
                    win = bingo(visited);
                    res = cnt;
                }
            }
        }
        System.out.println(res);

    }

    private static boolean bingo(boolean[][] visited) {
        int bingo = 0;
        for(int i = 0; i < 5; i++) {
            int w = 0;
            int l = 0;
            for(int j = 0; j < 5; j++) {
                if(visited[i][j]) {
                    w++;
                }
                if(visited[j][i]) {
                    l++;
                }
            }
            if(w == 5) bingo++;
            if(l == 5) bingo++;
        }
        if(visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) bingo++;
        if(visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) bingo++;

        return bingo >= 3;
    }


}
