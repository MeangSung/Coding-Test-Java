import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final List<Set<Integer>> direction = Arrays.asList(
            new HashSet<>(Arrays.asList(1, 0)),
            new HashSet<>(Arrays.asList(0, 1)),
            new HashSet<>(Arrays.asList(-1, 0)),
            new HashSet<>(Arrays.asList(0, -1))
    );
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"+-/*",true);

        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());

    }
}