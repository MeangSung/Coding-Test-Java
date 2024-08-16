import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final List<Set<Integer>> direction = Arrays.asList(
            new HashSet<>(Arrays.asList(1, 0)),
            new HashSet<>(Arrays.asList(0, 1)),
            new HashSet<>(Arrays.asList(-1, 0)),
            new HashSet<>(Arrays.asList(0, -1))
    );
    public static void main(String[] args) {
        int[] r = {6,1,2,3,4,5};
        Arrays.sort(r);
        System.out.println(r[r.length-1]);
    }
}