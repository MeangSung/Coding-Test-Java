package Baekjoon._00000._9000._400;

import java.io.IOException;
import java.util.Scanner;

public class G3_9466 {
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;
    static int[] state, arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            arr = new int[n + 1];
            state = new int[n + 1];

            for(int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = 1; i <= n; i++) {
                if(state[i] == NOT_VISITED) sol(i);
            }

            int cnt = 0;
            for(int i = 1; i <= n; i++ ){
                if(state[i] != CYCLE_IN ) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void sol(int x) {
        int cur = x;
        while(true){
            state[cur] = x;
            cur = arr[cur];

            if(state[cur] == x){
                while(state[cur] != CYCLE_IN){
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }

            else if(state[cur] != NOT_VISITED) return;
        }
    }

}
