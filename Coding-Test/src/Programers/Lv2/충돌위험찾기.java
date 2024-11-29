package Programers.Lv2;

import java.util.HashMap;
import java.util.Map;

public class 충돌위험찾기 {
    static Map<Integer,int[]> pointsMap = new HashMap<>();
    static Map<Integer,Map<String,Integer>> visitedMap = new HashMap<>();

    public int solution(int[][] points, int[][] routes){

        for(int i = 0; i < points.length; i++){
            pointsMap.put(i+1,points[i]);
        }

        for(int[] route : routes){
            int time = 0;
            int[] currentPosition = pointsMap.get(route[0]);

            for(int j = 1; j < route.length; j++){
                int[] nextPosition = pointsMap.get(route[j]);
                time = moveRobot(currentPosition,nextPosition,time);

                currentPosition = nextPosition;
            }
        }

        return countRisk();
    }

    private int countRisk() {
        int riskCount = 0;

        for(Map<String, Integer> map : visitedMap.values()){
            for(int risk : map.values()){
                if(risk > 1) riskCount++;
            }
        }

        return riskCount;
    }

    private int moveRobot(int[] currentPosition, int[] nextPosition, int startTime){
        int time = startTime;

        int r1 = currentPosition[0], c1 = currentPosition[1], r2 = nextPosition[0], c2 = nextPosition[1];

        if(time == 0){
            String keyWord = r1+","+c1;
            visitedMap.putIfAbsent(time,new HashMap<>());
            Map<String,Integer> positionMap = visitedMap.get(time);
            positionMap.put(keyWord, positionMap.getOrDefault(keyWord,0)+1);
        }

        while(r1 != r2 || c1 != c2){

            if(r1 > r2) r1--;
            else if(r1 < r2) r1++;
            else if(c1 > c2) c1--;
            else c1++;

            time++;

            String keyWord = r1+","+c1;
            visitedMap.putIfAbsent(time,new HashMap<>());
            Map<String,Integer> positionMap = visitedMap.get(time);
            positionMap.put(keyWord, positionMap.getOrDefault(keyWord,0)+1);
        }

        return time;
    }
}
