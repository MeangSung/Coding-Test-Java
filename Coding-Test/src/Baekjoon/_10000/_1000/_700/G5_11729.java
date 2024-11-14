package Baekjoon._10000._1000._700;

import java.util.Scanner;

public class G5_11729 {
    private static StringBuilder sb= new StringBuilder();
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sol(n,1, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void sol(int n, int a, int b) {
        if(n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            cnt++;
            return;
        }

        sol(n-1, a, 6-a-b );
        sol(1,a,b);
        sol(n-1, 6-a-b , b);
    }
}
