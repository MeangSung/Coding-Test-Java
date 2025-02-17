package Baekjoon._10000._4000._900;

import java.util.Scanner;

public class G2_14956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int side = sc.nextInt();
        int walk = sc.nextInt();

        int[] res = sol(side,walk);

        System.out.println(res[0] + " " + res[1]);
    }

    private static int[] sol(int side, int walk) {
        if(side==2){
            switch(walk){
                case 1: return new int[]{1,1};
                case 2: return new int[]{1,2};
                case 3: return new int[]{2,2};
                case 4: return new int[]{2,1};
            }
        }

        int half = side / 2, section = half * half;

        if(walk <= section){
            int[] next = sol(half, walk);
            return new int[]{next[1],next[0]};
        }
        else if (walk <= 2 * section) {
            int[] next = sol(half, walk - section);
            return new int[]{next[0], half + next[1]};
        }
        else if (walk <= 3 * section) {
            int[] next = sol(half, walk - 2 * section);
            return new int[]{next[0] + half , next[1] + half};
        }
        else{
            int[] next = sol(half, walk - 3 * section);
            return new int[]{2 * half - next[1] + 1, half - next[0] + 1};
        }
    }
}
