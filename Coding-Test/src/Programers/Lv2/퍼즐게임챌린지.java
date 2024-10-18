package Programers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퍼즐게임챌린지 {
    public static void main(String[] args){
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        int limit = 30;

        System.out.println(new 퍼즐게임챌린지().solution(diffs,times,limit));
    }

    private int solution(int[] diffs, int[] times, int limit){
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();

        while (left < right){

            int mid = (left + right) / 2;
            if(search(mid,diffs,times,limit)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean search(int level, int[] diffs, int[] times, int limit){
        int res = 0;
        int prevTime = 0;
        for(int i = 0; i < diffs.length; i++){
            int diff = diffs[i];
            int time = times[i];

            int v = diff - level;
            if(v < 0) v = 0;

            res += v * (prevTime + time) + time;
            prevTime = time;
        }

        return res <= limit;
    }
}
