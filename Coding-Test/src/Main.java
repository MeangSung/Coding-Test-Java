import java.util.*;

public class Main{
    static int[] arr = new int[10005];
    static int k,n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        for(int i = 0; i < k; i++) arr[i] = sc.nextInt();

        System.out.println(solution());
    }

    private static long solution(){

        long st = 0;
        long en = Integer.MAX_VALUE;

        while(st < en){
            long mid = (st+en+1)/2;
            if(solve(mid)) st = mid;
            if(!solve(mid)) en = mid - 1;
        }

        return st;
    }

    private static boolean solve(long x){
        long count = 0;
        for(int i = 0; i < k; i++) count += arr[i]/x;
        return count >= n;
    }

}