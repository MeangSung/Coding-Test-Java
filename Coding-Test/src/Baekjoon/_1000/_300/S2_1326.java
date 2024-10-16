package Baekjoon._1000._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1326 {
    static int res = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[] bridge = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) bridge[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        sol(n, bridge, start, end);
    }

    private static void sol(int n, int[] bridge, int start, int end) {
        if(start == end) {
            System.out.println(0);;
            return;
        }

        if(bfs(start, end, bridge)){
            System.out.println(res);
        }
        else{
            System.out.println(-1);
        }


    }

    private static boolean bfs(int start, int end, int[] bridge) {
        Queue<Frug> q = new LinkedList<>();
        q.add(new Frug(start, 0));
        boolean[] visited = new boolean[bridge.length];

        while(!q.isEmpty()) {
            Frug cur = q.poll();
            visited[cur.loc] = true;
            int num = bridge[cur.loc];
            int jump = cur.loc;

            while(true){
                jump += num;

                if(jump > n) break;
                if(visited[jump]) continue;

                if(jump == end){
                    res = Math.min(res, cur.count+1);
                    return true;
                }

                q.add(new Frug(jump, cur.count+1));
            }

            jump = cur.loc;
            while (true) {
                jump -= num;

                if(jump < 1) break;
                if(visited[jump]) continue;

                if(jump == end){
                    res = Math.min(res, cur.count+1);
                    return true;
                }
                q.add(new Frug(jump, cur.count+1));
            }

        }
        return false;
    }

    static class Frug{
        int loc, count;
        public Frug(int loc, int count){
            this.loc = loc;
            this.count = count;
        }
    }
}
