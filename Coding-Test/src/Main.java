public class Main {
    public static void main(String[] args) {

        int[][] points = {{3, 2}, {6, 4},{4, 7},{1, 4}};
        int[][] routes = {{4, 2},{1, 3},{4, 2},{4, 3}};

        System.out.println(new Solution().solution(points,routes));

    }
}