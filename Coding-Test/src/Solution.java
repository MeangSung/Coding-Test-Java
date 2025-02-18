import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Integer,int[]> pointMap = new HashMap<>();
    static Map<Integer, Map<String, Integer>> timePositionMap = new HashMap<>();

    public int solution(int[][] points, int[][] routes) {

        for (int i = 0; i < points.length; i++) {
            pointMap.put(i +1, points[i]);
        }

        for(int[] route : routes) {
            int time = 0;
            int[] currentPosition = pointMap.get(route[0]);

            for(int j = 1; j < route.length; j++) {
                int[] nextPosition = pointMap.get(route[j]);
                time = moveRobot(currentPosition, nextPosition, time);
                currentPosition = nextPosition;
            }
        }

        int riskCount = 0;

        for(Map<String, Integer> timePosition : timePositionMap.values()) {
            for(int count : timePosition.values()){
                if(count > 1) riskCount++;
            }
        }

        return riskCount;
    }

    private int moveRobot(int[] currentPosition, int[] nextPosition, int startTime) {
        int r1 = currentPosition[0], c1 = currentPosition[1], r2 = nextPosition[0], c2 = nextPosition[1];
        int time = startTime;

        if(time == 0){
            String positionKey = r1 + "," + c1;
            timePositionMap.putIfAbsent(time, new HashMap<>());
            Map<String, Integer> positionMap = timePositionMap.get(time);
            positionMap.put(positionKey, positionMap.getOrDefault(positionKey, 0) + 1);
        }

        while(r1 != r2 || c1 != c2) {

            if(r1 > r2) r1--;
            else if(r1 < r2) r1++;
            else if(c1 > c2) c1--;
            else c1++;

            time++;

            String positionKey = r1 + "," + c1;
            timePositionMap.putIfAbsent(time, new HashMap<>());
            Map<String, Integer> positionMap = timePositionMap.get(time);
            positionMap.put(positionKey, positionMap.getOrDefault(positionKey, 0) + 1);
        }

        return time;
    }

}