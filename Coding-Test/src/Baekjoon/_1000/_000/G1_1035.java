package Baekjoon._1000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class G1_1035 {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    ArrayList<Pos> pieces;
    boolean[][] loc = new boolean[5][5];
    int n;
    int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        new G1_1035().sol();
    }

    private void sol() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pieces = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            String strArr = br.readLine();
            for(int j = 0; j < 5; j++){
                if(strArr.charAt(j) == '*'){
                    pieces.add(new Pos(i,j));
                }
            }
        }

        n = pieces.size();
        bfs(0,0);
        System.out.println(res);
    }

    private void bfs(int idx, int sum){
        if(res <= sum) return;
        if(idx == n){
            if(check()){
                res = sum;
            }
            return;
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(loc[i][j]) continue;
                int distant = Math.abs(pieces.get(idx).x - i) + Math.abs(pieces.get(idx).y - j);
                loc[i][j] = true;
                bfs(idx+1, sum + distant);
                loc[i][j] = false;
            }
        }
    }

    private boolean check(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(loc[i][j]){
                    Stack<Pos> stk = new Stack<>();
                    boolean[][] validate = new boolean[5][5];
                    int cnt = 0;
                    stk.push(new Pos(i,j));
                    validate[i][j] = true;
                    while(!stk.isEmpty()){
                        Pos cur = stk.pop();
                        cnt++;
                        for(int k = 0; k < 4; k++){
                            int cx = cur.x - directions[k][0];
                            int cy = cur.y - directions[k][1];

                            if(cx < 0 || cx > 4 || cy < 0 || cy > 4) continue;
                            if(validate[cx][cy]) continue;
                            if(!loc[cx][cy]) continue;

                            validate[cx][cy] = true;
                            stk.push(new Pos(cx,cy));
                        }
                    }

                    return n == cnt;
                }
            }
        }
        return false;
    }

    class Pos{
        int x,y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
