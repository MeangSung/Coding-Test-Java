package Programers.Lv4;

import java.util.Arrays;

class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 1;
        int right = distance;

        while (left <= right) {
            int mid = (left + right) / 2;
            int removeCnt = 0;
            int start = 0;

            for (int rock : rocks) {
                if (rock - start < mid) {
                    removeCnt++;
                    continue;
                }
                start = rock;
            }
            if(distance - start < mid) removeCnt++;

            if(removeCnt > n){
                right = mid - 1;
                continue;
            }
            if(removeCnt <= n){
                left = mid + 1;
                answer = mid;
                continue;
            }
        }
        return answer;
    }
}