package Programers.Lv3;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times){
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;
        long result = right;

        while(left <= right){
            long mid = (right + left) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if(cnt >= n){
                result = mid;
                right = mid - 1;
            }
            if(cnt < n){
                left = mid + 1;
            }
        }

        return result;
    }
}
