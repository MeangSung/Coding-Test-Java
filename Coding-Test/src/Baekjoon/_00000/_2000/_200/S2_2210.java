package Baekjoon._00000._2000._200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2_2210 {
    static int[][] map = new int[5][5];
    static List<String> list = new ArrayList<>();
    static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0;i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sol();
    }

    private static void sol() {
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 5;j++) {
                dfs(i,j);
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int startX, int startY) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(startX,startY,new StringBuilder()));

        while(!stack.isEmpty()) {
            Node cur = stack.pop();

            if(cur.sb.length()>5) {
                if(!list.contains(cur.sb.toString())){
                    list.add(cur.sb.toString());
                    cnt++;
                }
                continue;
            }

            for(int[] direction : directions) {
                int cx = cur.x+direction[0];
                int cy = cur.y+direction[1];

                if(cx < 0 || cx >= 5 || cy < 0 || cy >= 5) continue;

                stack.push(new Node(cx,cy,new StringBuilder().append(cur.sb).append(map[cx][cy])));
            }
        }
    }

    static class Node{
        int x,y;
        StringBuilder sb;

        Node(int x,int y,StringBuilder sb){
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }
}
