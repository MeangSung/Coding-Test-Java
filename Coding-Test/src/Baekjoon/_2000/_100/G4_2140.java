package Baekjoon._2000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_2140 {
    private static final int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    private static final int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    private static boolean[][]visited;
    public static void main(String[] args) {
        FastScan fs = new FastScan();

        int n = fs.nextInt();

        visited = new boolean[n][n];
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            String str = fs.nextLine();
            for(int j = 0; j < n; j++){
                char c = str.charAt(j);
                if(c == '#'){
                    board[i][j] = 9;
                }
                else{
                    board[i][j] = c - '0';
                }
            }
        }

        int count = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++){
                boolean can = true;
                for(int k = 0; k < 8; k++){
                    int cx = i + dx[k];
                    int cy = j + dy[k];

                    if(board[cx][cy] == 0){
                        can = false;
                        break;
                    }
                }

                if(can){
                    for(int k = 0; k < 8; k++){
                        int cx = i + dx[k];
                        int cy = j + dy[k];

                        board[cx][cy]--;
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){return Integer.parseInt(next());}
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
