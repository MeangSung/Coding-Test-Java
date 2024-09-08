package Baekjoon._1000._600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1679 {
    static class Number{
        int val;
        int cnt;

        public Number(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        FastScan fs = new FastScan();

        int n = fs.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = fs.nextInt();
        }
        int k = fs.nextInt();

        System.out.println(sol(n,arr,k));
    }

    private static String sol(int n, int[] arr, int k){
        boolean[] visited = new boolean[arr[n-1]*k+2];
        Queue<Number> q = new LinkedList<>();
        q.add(new Number(0,0));
        while(!q.isEmpty()){
            Number num = q.poll();
            if(num.cnt == k) continue;

            for(int i = 0; i < n; i++){
                int now = num.val + arr[i];
                if(!visited[now]){
                    visited[now] = true;
                    q.add(new Number(now, num.cnt+1));
                }
            }
        }
        int res = 0;
        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                res = i;
                break;
            }
        }

        if(res%2==0){
            return "holsoon win at " + res;
        }
        else{
            return "jjaksoon win at " + res;
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {return Integer.parseInt(next());}
    }
}
