package Baekjoon._1000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1005 {
    static int n;
    static int k;
    static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            times = new int[n+1];
            for (int j = 0; j < n+1; j++) {
                list.add(new ArrayList<>());
            }


            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++){
                times[j] = Integer.parseInt(st.nextToken());
            }

            int[] startEndCount = new int[n+1];
            for(int j = 1; j < k+1; j++){
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                startEndCount[v2]++;
            }
            int goal = Integer.parseInt(br.readLine());

            sb.append(sol(startEndCount, list, goal)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int sol(int[] startEndCount, List<List<Integer>> list, int goal) {
        int[] result = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n+1; i++){
            result[i] = times[i];

            if(startEndCount[i] == 0 ){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int target: list.get(node)){
                result[target] = Math.max(result[target], result[node] + times[target]);
                startEndCount[target]--;

                if(startEndCount[target] == 0){
                    q.add(target);
                }
            }

        }
        return result[goal];
    }


}
