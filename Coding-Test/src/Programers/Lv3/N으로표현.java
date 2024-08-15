package Programers.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N으로표현 {
    public int solution(int number, int N){
        if (number == N){
            return 1;
        }

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);

        for (int i =2; i < 9; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(N);
            for (int j = 1; j < i; j++){
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));

            for(int j = 1; j < i; j++){
                for (int num1 : dp.get(j)){
                    int k  = i-j;
                    for( int num2 : dp.get(k)){
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if(num2 != 0){
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number)){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());

        N으로표현 n = new N으로표현();
        System.out.println(n.solution(number, N));
    }
}

