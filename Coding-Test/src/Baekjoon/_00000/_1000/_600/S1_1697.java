package Baekjoon._00000._1000._600;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_1697 {
    static int[] map = new int[200001];
    final static int[] walks = {-1,1,2};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Arrays.fill(map,-1);
        System.out.println(sol(n,k));
    }

    public static int sol(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        map[n] = 0;
        q.add(n);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == k) return map[cur];
            for(int walk : walks){
                int next;
                if(walk == 2){
                    next = 2 * cur;
                }
                else{
                    next = cur + walk;
                }

                if(next < 0 || next >= 200001) continue;
                if(map[next] != -1) continue;

                map[next] = map[cur]+1;
                q.add(next);
            }
        }
        return -1;

    }

}
