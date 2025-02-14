import java.util.*;

public class Main{
    static char[][] map = new char[5][5];
    static boolean[] visited = new boolean[25];
    static int[] selected = new int[7];
    static int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            map[i] = sc.nextLine().toCharArray();
        }

        find(0,0,0);
    }

    private static void find(int idx, int cnt, int sCnt){
        if(cnt == 7){
            if(sCnt >= 4){
                if(search()) res++;
                return;
            }
            return;
        }

        for(int i = idx; i < 25; i++){
            selected[cnt] = i;
            visited[i] = true;
            if(map[i/5][i%5] == 'S') find(i+1, cnt+1, sCnt+1);
            else find(i+1,cnt+1,sCnt);
            visited[i] = false;
        }
    }

    private static boolean search(){
        int cnt = 1;
        boolean[] adjVisited = new boolean[25];
        Queue<Integer> q = new LinkedList<>();

        q.add(selected[0]);

        while(!q.isEmpty()){
            int now = q.poll();
            adjVisited[now] = true;

            for(int[] d : directions){
                int cx = now/5 + d[0];
                int cy = now%5 + d[1];

                if(cx < 0 || cy < 0 || cx >= 5 || cy >= 5) continue;
                if(adjVisited[cx*5+cy]) continue;
                if(!visited[cx*5+cy]) continue;

                cnt++;
                adjVisited[cx*5+cy] = true;
                q.add(cx*5+cy);
            }
        }

        return cnt == 7;
    }

}