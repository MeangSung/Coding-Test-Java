package Baekjoon._2000;
import java.io.*;
import java.util.*;

public class S2_2630 {
    private static int white = 0;
    private static int blue = 0;
    private static int[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void sol(int x, int y, int size){

        if(checkColor(x,y,size)){
            int color = board[x][y];
            if(color == 0) white++;
            if(color == 1) blue++;
            return;
        }

        int newSize = size/2;

        sol(x,y,newSize);
        sol(x+newSize,y,newSize);
        sol(x,y+newSize,newSize);
        sol(x+newSize,y+newSize,newSize);
    }

    private static boolean checkColor(int x, int y, int size){
        int color = board[x][y];

        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(board[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
