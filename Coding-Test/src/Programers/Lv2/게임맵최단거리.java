package Programers.Lv2;
import java.util.*;

public class 게임맵최단거리 {
    private final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int[] d : directions){
                int cx = cur[0] + d[0];
                int cy = cur[1] + d[1];

                if(cx < 0 || cx > maps.length-1 || cy < 0 || cy > maps[0].length-1) continue;
                if(visited[cx][cy]) continue;
                if(maps[cx][cy] != 1) continue;

                visited[cx][cy] = true;
                maps[cx][cy] = maps[cur[0]][cur[1]] +1;
                q.add(new int[]{cx,cy});
            }
        }

        if(maps[maps.length-1][maps[0].length-1] == 1){
            return -1;
        }

        return maps[maps.length-1][maps[0].length-1];
    }

}
