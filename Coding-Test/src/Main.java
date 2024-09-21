import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.get(1).add(2);
        map.get(2).add(3);
        map.get(3).add(4);
        map.get(1).add(4);
        map.get(2).add(5);
        map.get(3).add(6);
        for(Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(Integer i : list) {
                System.out.println(i);
            }
        }
    }
}