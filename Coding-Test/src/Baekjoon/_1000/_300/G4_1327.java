package Baekjoon._1000._300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_1327 {
    static class Point{
        int num;
        int idx;

        public Point(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }

    private static int[] arr;
    private static int n,k;
    private static int res=0,cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n; i > 0; i--) {
            bfs(i);
        }

        if(res != -1){
            res = cnt;
        }
        System.out.println(res);
    }

    private static void bfs(int num) {

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(Arrays.toString(arr));
            if(cur == num-1) continue;
            if(cur > n-k){
                res = -1;
                continue;
            }

            int next = cur - 1 + k;
            cnt++;
            int nextNum = arr[next];
            arr[next] = num;
            arr[cur] = nextNum;
            q.add(next);
        }
    }
}
