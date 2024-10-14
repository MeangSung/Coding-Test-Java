package Baekjoon._1000._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1325 {
    static int n,m;
    static List<Integer>[] arr;
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        n = fs.nextInt();
        m = fs.nextInt();

        arr = new List[n + 1];

        for(int i = 0; i <= n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int a = fs.nextInt();
            int b = fs.nextInt();

            arr[b].add(a);
        }

        int[] res = new int[n + 1];
        int max = 0;

        for(int i = 1; i <= n; i++){
            res[i] = bfs(i);
            max = Math.max(max, res[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(max == res[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(int a){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = true;

        int count = 1;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i : arr[cur]){
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
                count++;
            }
        }
        return count;
    }

    static class FastScan{
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

        int nextInt() { return Integer.parseInt(next()); }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
