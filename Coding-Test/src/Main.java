import Programers.Lv3.입국심사;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(1);
        list.removeAll(List.of());

        for (Integer i : list) {
            System.out.printf(i + " ");
        }
    }
}