package Baekjoon._10000._5000._600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S2_15664 {
    //공통 사항
    static int n,m;
    static int[] arr;
    static int[] temp;

    //개선
    static StringBuilder sb = new StringBuilder();

    //첫 번째 시도
    static boolean[] visited;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        /**
         * 개선
         */

        sol2(0,0);

        System.out.println(sb);

        /**
         * 첫 번째 시도
         */
//        visited = new boolean[n];
//        temp = new int[m];
//        sol(0,0);
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int[] arr : list){
//            for(int i : arr){
//                sb.append(i).append(" ");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
    }

    static void sol2(int start, int cnt){
        if(cnt == m){
            for(int num : temp) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i = start; i < n; i++){
            if(arr[i] == prev) continue;
            temp[cnt] = arr[i];
            sol2(i+1, cnt+1);
            prev = arr[i];
        }
    }

    static void sol(int idx, int cnt) {
        if(cnt == m){
            checkDuplicate();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[idx] = arr[i];
                sol(idx+1,cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void checkDuplicate() {
        int[] clone = temp.clone();
        Arrays.sort(clone);
        for(int[] arr : list){
            int cnt = 0;
            for(int i = 0; i < m; i++){
                if(arr[i] == clone[i]) cnt++;
            }
            if(cnt == m) return;
        }
        list.add(clone);
    }
}
