package Baekjoon._1000._900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1992 {
    private static int[][] screen;
    private static String res="";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        screen = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++){
                screen[i][j] = Integer.parseInt(str[j]);
            }
        }

        sol(0,0,N);
        System.out.println(res);
    }

    private static void sol(int x, int y, int size){
        if(checkZip(x,y,size)){
            int color = screen[x][y];
            if (color == 1) res+="1";
            if (color == 0) res+="0";
            return;
        }

        int newSize = size/2;

        res+="(";
        sol(x,y,newSize);
        sol(x,y+newSize,newSize);
        sol(x+newSize,y,newSize);
        sol(x+newSize,y+newSize,newSize);
        res+=")";
    }

    private static boolean checkZip(int x, int y, int size){
        int color = screen[x][y];

        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if (color != screen[i][j]) return false;
            }
        }

        return true;
    }
}
