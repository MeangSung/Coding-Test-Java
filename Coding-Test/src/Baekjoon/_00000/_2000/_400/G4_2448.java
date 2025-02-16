package Baekjoon._00000._2000._400;

import java.util.Scanner;

public class G4_2448 {
    static boolean[][] board = new boolean[1024*3][1024*3*2-1];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sol(n, 0, n-1);

        printStars(n);

        System.out.println(sb);
    }

    private static void sol(int n, int x, int y){
        if(n == 3){
            fillStars(x,y);
            return;
        }

        int cn = n / 2;
        sol(cn,x,y);
        sol(cn, x+cn, y-cn);
        sol(cn, x+cn, y+cn);
    }

    private static void fillStars(int x, int y){
        board[x][y] = true;
        board[x+1][y-1] = true;
        board[x+1][y+1] = true;
        for(int i = y-2; i <= y+2; i++) board[x+2][i] = true;
    }

    private static void printStars(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n*2-1; j++){
                sb.append(board[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }
    }
}
