package Programers.Lv2;

public class 땅따먹기 {

    int solution(int[][] land) {
        int n = land.length-1;
        for(int i = 1; i < n+1; i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }
        return Math.max(land[n][0],Math.max(land[n][1],Math.max(land[n][2],land[n][3])));

    }


}
