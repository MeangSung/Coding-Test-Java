package Programers.Lv1;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장많이받은선물 {
    static int[][] points;
    static String[] friends;
    static String[] gifts;
    public int solution(String[] friends, String[] gifts) {
        this.friends = friends;
        this.gifts = gifts;
        int[][] points = new int[friends.length][friends.length];
        StringTokenizer st;

        for(String gift : gifts){
            st = new StringTokenizer(gift);
            int giver = findFriend(st.nextToken());
            int sender = findFriend(st.nextToken());
            points[giver][sender]++;
            points[sender][giver]--;
        }

        int max = 0;

        for(int i = 0; i < points.length; i++){
            int sum = 0;
            for(int j = 0; j < points[i].length;j++){
                if(j == i) continue;
                if(points[i][j] == 0 &&
                        Arrays.stream(points[i]).sum() >
                                Arrays.stream(points[j]).sum()){
                    sum++;
                    continue;
                }
                if(points[i][j] > 0) sum++;
            }
            max = Math.max(sum,max);
        }

        return max;
    }

    private static int findFriend(String name){
        int m = -1;
        for(int i = 0; i < friends.length; i++){
            if(friends[i].equals(name)) {
                m = i;
                break;
            }
        }
        return m;
    }
}