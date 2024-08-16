package Baekjoon._1000._900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1926 {
    private final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int[] solution(int n, int m, int[][] paper){
        int paperCount = 0;
        int maxx = 0;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(paper[i][j] == 1 && visited[i][j] == 0){
                    int sum = bfs(paper,visited,i,j);
                    paperCount++;
                    maxx = Math.max(maxx, sum);
                }
            }
        }
        return new int[]{paperCount,maxx};
    }

    private int bfs(int[][] paper,int[][] visited,int x, int y){
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int dx = cur[0];
            int dy = cur[1];
            for(int[] d : directions){
                int newX = dx + d[0];
                int newY = dy + d[1];
                if(newX >=0 && newX < paper.length && newY >=0 && newY < paper[0].length){
                    if(paper[newX][newY] == 1 && visited[newX][newY] == 0){
                        visited[newX][newY] = 1;
                        q.add(new int[]{newX, newY});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        S1_1926 s = new S1_1926();
        int[] res = s.solution(n, m, paper);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
