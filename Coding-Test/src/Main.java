import java.util.*;

public class Main{
    static int n,m;
    static int[] temp = new int[10];
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        sol(0);
        System.out.println(sb.toString());
    }

    private static void sol(int k){
        if(k >= m){
            for(int i = 0; i < m; i++){
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[k] = i;
                sol(k+1);
                visited[i] = false;
            }
        }
    }

}