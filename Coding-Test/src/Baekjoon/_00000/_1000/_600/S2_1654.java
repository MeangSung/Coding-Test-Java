package Baekjoon._00000._1000._600;

import java.util.Arrays;
import java.util.Scanner;

public class S2_1654 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        long[] arr = new long[k];

        for(int i = 0; i < k; i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(sol(k,n,arr));
        System.out.println(sol2(k,n,arr));
    }

    // Parametric Search - solve 뺀 경우
    private static long sol2(int k, int n, long[] arr){

        long st = 0;
        long en = Integer.MAX_VALUE;

        while(st < en){
            long mid = (st+en+1)/2;
            if(solve(mid, k, n, arr)) st = mid;
            if(!solve(mid, k, n, arr)) en = mid - 1;
        }

        return st;
    }

    private static boolean solve(long x,int k, int n, long[] arr){
        long count = 0;
        for(int i = 0; i < k; i++) count += arr[i]/x;
        return count >= n;
    }

    //solve()로 빼지 않은 것
    private static long sol(int k, int n, long[] arr){
        Arrays.sort(arr);

        long max = arr[k-1]+1;
        long min = 0;

        while(min < max){
            long mid = (max+min) / 2;

            long count = 0;

            for (long l : arr) {
                count += (l / mid);
            }

            if(count >= n){
                min = mid + 1;
            }

            if(count < n){
                max = mid;
            }
        }

        return min - 1;
    }
}
