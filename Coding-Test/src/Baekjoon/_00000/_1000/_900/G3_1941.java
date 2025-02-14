package Baekjoon._00000._1000._900;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G3_1941 {
    static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static String[][] map = new String[5][5];
    static boolean[] visited = new boolean[25];
    static int[] selected = new int[7];
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            map[i] = sc.nextLine().split("");
        }

        find(0,0,0);

        System.out.println(count);
    }

    private static void find(int idx, int cnt, int sCnt) {
        if(cnt == 7){
            if(sCnt >= 4){
                if(search()) count++;
                return;
            }
            return;
        }

        for(int i = idx; i < 25; i++){
            visited[i] = true;

            selected[cnt] = i;

            if(map[i/5][i%5].equals("S")) find(i+1,cnt+1, sCnt+1);
            else find(i+1,cnt+1, sCnt);

            visited[i] = false;
        }


    }

    //인접하는지 체크하는 메서드
    private static boolean search() {
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();

        q.add(selected[0]);

        boolean[] adjVisit = new boolean[25];

        while(!q.isEmpty()){
            int now = q.poll();
            adjVisit[now] = true;

            for(int[] d : directions){
                int cx = now/5 + d[0];
                int cy = now%5 + d[1];

                if (cx < 0 || cx >= 5 || cy < 0 || cy >= 5) continue;
                if(adjVisit[cx*5 + cy]) continue;
                if(!visited[cx*5 + cy]) continue;

                cnt++;
                adjVisit[cx*5 + cy] = true;
                q.add(cx*5 + cy);
            }
        }

        return cnt >= 7;

    }

}
