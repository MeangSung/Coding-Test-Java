package Baekjoon._00000._9000._600;

import java.util.Scanner;

public class G4_9663 {
    static int N;
    static int cnt = 0;

    static boolean[] isUsed1 = new boolean[30];
    static boolean[] isUsed2 = new boolean[30];
    static boolean[] isUsed3 = new boolean[30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        sol(0);

        System.out.println(cnt);
    }

    private static void sol(int cur) {
        if(cur == N) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if (isUsed1[i] || isUsed2[cur + i] || isUsed3[cur - i + N - 1]) {
                continue;
            }
            isUsed1[i] = true;
            isUsed2[cur + i] = true;
            isUsed3[cur-i+N-1] = true;
            sol(cur + 1);
            isUsed1[i] = false;
            isUsed2[cur + i] = false;
            isUsed3[cur-i+N-1] = false;
        }
    }
}
