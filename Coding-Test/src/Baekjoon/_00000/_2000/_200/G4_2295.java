package Baekjoon._00000._2000._200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class G4_2295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                list.add(arr.get(i) + arr.get(j));
            }
        }
        Collections.sort(list);

        int max = 0;

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int point = Collections.binarySearch(list, arr.get(i) - arr.get(j));
                if(point >= 0){
                    max = Math.max(max, arr.get(i));
                }
            }
        }

        System.out.println(max);
    }
}
