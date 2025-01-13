import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        System.out.println(sol(n, list));
    }


    private static int sol(int n, List<Integer> list){
        List<Integer> two = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                two.add(list.get(i) + list.get(j));
            }
        }

        Collections.sort(two);

        int max = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int point = Collections.binarySearch(two, list.get(i) - list.get(j));
                if(point >= 0){
                    max = Math.max(max, list.get(i));
                }
            }
        }

        return max;
    }
}