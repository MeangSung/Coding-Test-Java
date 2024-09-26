package Baekjoon._1000._100;

import java.util.Scanner;

public class S5_1193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int squareCount = 1, squareSum = 0;

        while(true){
            if(n <= squareCount + squareSum){
                if(squareCount % 2 == 1){
                    System.out.println(squareCount - (n - squareSum -1) + "/" + (n - squareSum));
                    break;
                }
                else{
                    System.out.println(n-squareSum + "/" + (squareCount - (n - squareSum -1) ));
                    break;
                }
            }
            squareSum += squareCount;
            squareCount++;
        }
    }
}
