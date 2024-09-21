import java.util.*;
import java.io.*;

public class Main{
    private static final int A_TO_Z = 'z' - 'a' + 1;
    private static final int WORD_LIMIT = 200000;

    public static void main(String[] args) {
        FastScan fs = new FastScan();
        int n = 0;
        byte[][] wordCnt = new byte[WORD_LIMIT][A_TO_Z];

        while(true){
            String word = fs.nextLine();
            if(word.equals("-")) break;
            for(int i = 0; i < word.length(); i++){
                wordCnt[n][word.charAt(i) - 'A']++;
            }
            n++;
        }

        StringBuilder sb = new StringBuilder();
        while(true){
            String board = fs.nextLine();
            if(board.equals("#"))break;

            byte[] boardCnt = new byte[A_TO_Z];
            for(int i = 0; i < board.length(); i++){
                boardCnt[board.charAt(i) - 'A']++;
            }

            int min = WORD_LIMIT+1;
            int max = 0;
            int[] result = new int[A_TO_Z];

            for(int i = 0; i < n; i++){
                if(!isValid(wordCnt[i], boardCnt)) continue;

                for(int j = 0; j < A_TO_Z; j++){
                    if(wordCnt[i][j] != 0) result[j]++;
                }
            }

            for(int i = 0; i < A_TO_Z; i++){
                if(boardCnt[i] == 0) continue;
                if(min > result[i]) min = result[i];
                if(max < result[i]) max = result[i];
            }

            for(int i = 0; i < A_TO_Z; i++){
                if(min == result[i] && boardCnt[i] != 0){
                    sb.append((char)(i + 'A'));
                }
            }
            sb.append(' ').append(min).append(' ');

            for(int i = 0; i < A_TO_Z; i++){
                if(max == result[i] && boardCnt[i] != 0){
                    sb.append((char)(i+'A'));
                }
            }
            sb.append(' ').append(max).append('\n');
        }

        System.out.println(sb);

    }

    private static boolean isValid(byte[] word, byte[] board){
        for(int i = 0; i < A_TO_Z; i ++){
            if(board[i] < word[i]) return false;
        }
        return true;
    }

    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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