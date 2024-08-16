import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
    private static final List<Set<Integer>> direction = Arrays.asList(
            new HashSet<>(Arrays.asList(1, 0)),
            new HashSet<>(Arrays.asList(0, 1)),
            new HashSet<>(Arrays.asList(-1, 0)),
            new HashSet<>(Arrays.asList(0, -1))
    );
    public static void main(String[] args) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        Point p = q.poll();
    }
}