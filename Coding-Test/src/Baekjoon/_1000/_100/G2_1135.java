package Baekjoon._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2_1135 {
    private static int[] dp;
    private static List<Integer>[] tree;

    public static void main(String[] args) {
        FastScan fs = new FastScan();

        int n = fs.nextInt();
        dp = new int[n];
        tree = new ArrayList[n];
        for(int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        int[] input = Arrays.stream(fs.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for(int i = 1; i < n; i++) tree[input[i]].add(i);

        System.out.println(dfs(0));
    }

    private static int dfs(int cur){
        int cnt = 0, max = 0;
        Queue<int[]> q = new PriorityQueue<>((o1,o2) -> o2[1] - o1[1]);
        for(Integer next : tree[cur]){
            dp[next] = dfs(next);
            q.add(new int[]{next, dp[next]});
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            cnt++;
            max = Math.max(max, node[1]+cnt);
        }
        return max;
    }

    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
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

        int nextInt(){ return Integer.parseInt(next()); }

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
