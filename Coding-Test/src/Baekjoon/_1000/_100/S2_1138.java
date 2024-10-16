package Baekjoon._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_1138 {
    public static void main(String[] args) throws IOException {
        new S2_1138().sol();
    }

    private void sol() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] ars = br.readLine().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int taller = Integer.parseInt(ars[i]);
            int position = searchPosition(arr, taller, n);
            arr[position] = i+1;
        }

        print(arr);
    }

    private int searchPosition(int[] arr, int taller, int n){
        for(int i = 0; i < n; i++){
            if(taller == 0 && arr[i] == 0){
                return i;
            }
            if(arr[i] == 0) taller--;
        }
        return -1;
    }

    private void print(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
