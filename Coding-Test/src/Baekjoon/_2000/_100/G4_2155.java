package Baekjoon._2000._100;
import java.util.Scanner;

public class G4_2155 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = Math.max(n,m);
        int b = Math.min(n,m);

        System.out.println(findFloor(a) - findFloor(b));
    }

    private static int findFloor(int n) {
        int level = (int) Math.ceil(Math.pow(n,0.5));

        if((n - (Math.pow(level - 1, 2)+1))%2 == 0){
            return 2*(level-1);
        }
        return 2*(level-1) -1;
    }
}
