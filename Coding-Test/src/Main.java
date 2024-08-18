import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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

        String[][] r = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        Arrays.sort(r,new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return !o1[0].equals(o2[0])?o1[0].compareTo(o2[0]):o1[1].compareTo(o2[1]);
            }
        });
        for(String[] rr : r){
            System.out.println(Arrays.toString(rr));

        }

        List<String[]> ss = new ArrayList<>();

    }
}