import java.util.*;

public class Main{
    static int n;
    static boolean[] isUsed1 = new boolean[16];
    static boolean[] isUsed2 = new boolean[32];
    static boolean[] isUsed3 = new boolean[32];

    static int cnt = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        sol(0);

        System.out.println(cnt);
    }

    private static void sol(int cur){
        if(cur == n){
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(isUsed1[i] || isUsed2[cur + i] || isUsed3[cur - i + n - 1]) continue;
            isUsed1[i] = true;
            isUsed2[i+cur] = true;
            isUsed3[cur - i + n - 1] = true;
            sol(cur + 1);
            isUsed1[i] = false;
            isUsed2[i+cur] = false;
            isUsed3[cur - i + n - 1] = false;
        }
    }
}