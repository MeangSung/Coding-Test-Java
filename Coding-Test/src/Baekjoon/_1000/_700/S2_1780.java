package Baekjoon._1000._700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1780 {
    private static int[][] paper;
    private static int black = 0;
    private static int white = 0;
    private static int blue = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol(0,0,N);
        System.out.println(black);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void sol(int x, int y, int size){
        if(checkColor(x,y,size)){
            int color = paper[x][y];
            if (color == -1) black++;
            if (color == 0) white++;
            if (color == 1) blue++;
            return;
        }

        int newSize = size /3;


        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                sol(x+ i*newSize, y+j*newSize, newSize);
            }
        }
    }

    private static boolean checkColor(int x, int y, int size){
        int color = paper[x][y];

        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if (paper[i][j] != color) return false;
            }
        }

        return true;
    }
}
