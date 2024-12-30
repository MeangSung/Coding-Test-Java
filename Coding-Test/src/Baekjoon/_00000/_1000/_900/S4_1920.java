package Baekjoon._00000._1000._900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920 {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            System.out.println(binarySearch(Integer.parseInt(st.nextToken())));
        }
    }

    private static int binarySearch(int target){
        int st = 0;
        int en = n-1;
        while(st <= en){
            int mid = (st+en)/2;
            if(arr[mid] > target) en = mid-1;
            if(arr[mid] < target) st = mid+1;
            if(arr[mid] == target) return 1;
        }
        return 0;
    }
}
