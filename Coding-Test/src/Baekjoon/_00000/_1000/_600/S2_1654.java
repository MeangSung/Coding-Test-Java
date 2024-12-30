package Baekjoon._00000._1000._600;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class S2_1654 {
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    int n = sc.nextInt();

    long[] arr = new long[k];

    for(int i = 0; i < k; i++){
        arr[i] = sc.nextLong();
    }

    System.out.println(sol(k,n,arr));
}

    private static long sol(int k, int n, long[] arr){
        Arrays.sort(arr);

        long max = arr[k-1]+1;
        long mid = 0;
        long min = 0;

        while(min < max){
            mid = (max+min) / 2;

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
