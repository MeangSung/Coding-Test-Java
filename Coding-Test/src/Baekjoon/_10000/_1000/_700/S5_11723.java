package Baekjoon._10000._1000._700;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5_11723 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int bitmask = 0;
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String next = st.nextToken();
            int x;
            switch(next){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bitmask |= (1<<(x-1));
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bitmask &= ~(1<<(x-1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bitmask & (1<<(x-1)))!=0?"1\n":"0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bitmask ^= (1<<(x-1));
                    break;
                case "all":
                    bitmask |= (~0);
                    break;
                case "empty":
                    bitmask &= 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
