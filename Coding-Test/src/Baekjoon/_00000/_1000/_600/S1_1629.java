package Baekjoon._00000._1000._600;

import java.util.Scanner;

public class S1_1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        System.out.println(sol(a,b,c));
    }

    private static long sol(long a, long b, long c) {
        if(b == 1) return a % c;

        long val = sol(a,b/2,c);

        val = val * val % c;
        if(b % 2 == 0) return val;
        else return val * a % c;
    }
}
