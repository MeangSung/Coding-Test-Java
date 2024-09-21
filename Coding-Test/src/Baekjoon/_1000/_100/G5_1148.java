package Baekjoon._1000._100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1148 {
    private static final int A_TO_Z = 'z' - 'a' +1;
    private static final int LIMIT_WORD = 200000;

    public static void main(String[] args) {
        FastScan fs = new FastScan();
        byte[][] wordCnt = new byte[LIMIT_WORD][A_TO_Z];
        int n = 0;

        while(true){
            String word = fs.nextLine();
            if(word.equals("-")) break;
            for(int i = 0; i < word.length(); i++){
                wordCnt[n][word.charAt(i)-'A']++;
            }
            n++;
        }

        StringBuilder sb = new StringBuilder();
        while(true){
            String board = fs.nextLine();
            if(board.equals("#")) break;
            byte[] boardCnt = new byte[A_TO_Z];
            for(int i = 0; i < board.length();i++){
                boardCnt[board.charAt(i)-'A']++;
            }
            int[] result = new int[A_TO_Z];
            int max = 0;
            int min = LIMIT_WORD;
            for(int i = 0; i < n; i++){
                if(!isValid(wordCnt[i],boardCnt)) continue;

                for(int j = 0; j < A_TO_Z; j++){
                    if(wordCnt[i][j] != 0) result[j]++;
                }
            }

            for(int i = 0; i < A_TO_Z; i++){
                if(boardCnt[i] == 0) continue;
                if(result[i] > max) max = result[i];
                if(result[i] < min) min = result[i];
            }

            for(int i = 0; i < A_TO_Z; i++){
                if(boardCnt[i] != 0 && result[i] == min){
                    sb.append((char) (i + 'A'));
                }
            }
            sb.append(' ').append(min).append(' ');

            for(int i = 0; i < A_TO_Z; i++){
                if(boardCnt[i] != 0 && result[i] == max){
                    sb.append((char) (i + 'A'));
                }
            }
            sb.append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isValid(byte[] word, byte[] board){
        for(int i = 0; i < A_TO_Z; i++){
            if(board[i] < word[i]) return false;
        }
        return true;
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
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
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
