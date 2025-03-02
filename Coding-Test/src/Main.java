import java.util.Scanner;

public class Main{
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;
    static int[] arr, state;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();

            arr = new int[n+1];
            state = new int[n+1];

            for(int i = 1; i <= n; i++){
                arr[i] = sc.nextInt();
            }

            for(int i = 1; i <= n; i++){
                if(state[i] == NOT_VISITED) sol(i);
            }

            int cnt = 0;
            for(int i = 1; i <= n; i++){
                if(state[i] != CYCLE_IN) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void sol(int start){
        int cur = start;
        while(true){
            state[cur] = start;
            cur = arr[cur];

            if(state[cur] == start){
                while(state[cur] != CYCLE_IN){
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }

            if(state[cur] != NOT_VISITED) return;
        }
    }

}