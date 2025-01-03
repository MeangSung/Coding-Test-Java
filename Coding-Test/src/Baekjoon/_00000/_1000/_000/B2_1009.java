package Baekjoon._00000._1000._000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int num = compExtract(a,b);

            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    public static int compExtract(int a, int b){
        List<Integer> arr = new ArrayList<>();

        int cur = a % 10;
        while(!arr.contains(cur)){
            arr.add(cur);
            cur = (cur * a) % 10;
        }
        int idx = (b-1) % arr.size();

        return arr.get(idx)==0? 10 : arr.get(idx);
    }
}
