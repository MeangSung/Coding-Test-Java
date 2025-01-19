import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] snacks = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n,m,snacks));
    }

    private static long solution(int n, int m, int[] arr){
        long st = 0;
        long en = 1000000000;

        while(st < en){
            long mid = (st + en + 1) / 2;

            if(sol(n,m,arr,mid)) st = mid;
            else en = mid - 1;

        }

        return st;
    }

    private static boolean sol(int n, int m, int[] arr, long mid){
        int count = 0;
        for(int i = 0; i < m; i++) count += (int) (arr[i] / mid);
        return count >= n;
    }

}