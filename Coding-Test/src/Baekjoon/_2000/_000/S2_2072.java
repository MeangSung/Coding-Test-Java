package Baekjoon._2000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2072 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sol(arr));
    }

    private static int sol(int[][] arr){

        if(arr.length < 9) return -1;

        int[][] board = new int[20][20];

        for(int i = 0; i < 8; i++){
            board[arr[i][0]][arr[i][1]] = i%2 +1;
        }

        for(int i = 8; i < arr.length; i++){
            board[arr[i][0]][arr[i][1]] = i%2 +1;
            if(is5mock(board, arr[i][0], arr[i][1], i%2 +1)){
                return i+1;
            }
        }
        return -1;
    }

    private static final int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    private static final int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    private static boolean is5mock(int[][] board, int x, int y, int color){
        int[] cnt = new int[4];
        Arrays.fill(cnt,1);

        for(int d = 0; d < 8; d++){
            for(int a = x+dx[d], b = y+dy[d]; a >= 0&& a < board.length && b >= 0 && b < board.length && board[a][b] == color; a+=dx[d], b+=dy[d]){
                cnt[d/2]++;
            }
        }

        for(int i = 0; i < 4; i++){
            if(cnt[i] == 5) return true;
        }

        return false;
    }
}
